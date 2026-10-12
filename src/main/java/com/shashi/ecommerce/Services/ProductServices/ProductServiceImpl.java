package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.DTOs.ProductsDTOs.ProductDTOS;
import com.shashi.ecommerce.Entity.ProductsEntity.*;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.ProductRepositories.*;
import com.shashi.ecommerce.Services.ClassConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ClassConverterService classConverterService;

    private final BrandsRepository brandsRepository;

    private final CategoryRepository categoryRepository;

    private final ProductVariantsService productVariantsService;

    private final ProductImagesService productImagesService;

    @Override
    public Page<ProductDTOS.GetAllProductDTO> getProducts(int pageNumber) {

        Pageable productPage = PageRequest.of(pageNumber , 12);

        Page<Products> products = productRepository.findAll(productPage);

        return products.map(classConverterService::toProductDTO);
    }

    @Override
    public ProductDTOS.AddProductResponseDTO addProduct(ProductDTOS.AddFullProductRequestDTO request) {

       List<ProductImages> listOfProductImages = request.imagesRequest().stream().map(classConverterService::toProductImage).toList();
       List<ProductVariant> listOfProductVariants = request.variantsRequest().stream().map(classConverterService::toProductVariant).toList();
       Optional<Brands> optionalBrands = brandsRepository.findById(request.productRequest().brandId());
       Optional<Categories> optionalCategories = categoryRepository.findById(request.categoryId());
       if (optionalBrands.isEmpty() || optionalCategories.isEmpty()){
           throw new ResourceNotFoundException("Brand or Category is Not Found !");
       }
       Categories category = optionalCategories.get();
       Brands brand = optionalBrands.get();

        Products newProduct = new Products();

        newProduct.setBaseDescription(request.productRequest().baseDescription());
        newProduct.setBasePrice(request.productRequest().basePrice());
        newProduct.setBrands(brand);
        newProduct.setProductName(request.productRequest().productName());
        newProduct.setIsActive(true);
        newProduct.setCategories(category);

        for (ProductImages productsImages : listOfProductImages){
            productsImages.setProducts(newProduct);
        }
        newProduct.setProductImages(listOfProductImages);

        for (ProductVariant productsVariants : listOfProductVariants){
            productsVariants.setProducts(newProduct);
        }
        newProduct.setProductVariant(listOfProductVariants);

        productRepository.save(newProduct);

        return new ProductDTOS.AddProductResponseDTO("Product Added Successfully");
    }

    @Override
    public ProductDTOS.GetProductDetailsDTO getProductDetails(long id) {

       Optional<Products> optionalProducts = productRepository.findById(id);
       if (optionalProducts.isEmpty()){
           throw new ResourceNotFoundException("Product Not Found !");
       }
       Products product = optionalProducts.get();

        return new ProductDTOS.GetProductDetailsDTO(
                classConverterService.toProductDTO(product),
                productVariantsService.getProductVariants(id).stream().map(classConverterService::toProductVariantDTO).toList(),
                productImagesService.getProductImages(id).stream().map(classConverterService::toProductImagesDTO).toList()
                );
    }


}

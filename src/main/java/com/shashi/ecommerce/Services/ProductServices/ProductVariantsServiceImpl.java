package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.Entity.ProductsEntity.ProductVariant;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.ProductRepositories.ProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductVariantsServiceImpl implements ProductVariantsService{

    private final ProductVariantRepository productVariantRepository;

    @Override
    public List<ProductVariant> getProductVariants(long productId) {

       return productVariantRepository.findByProductsId(productId);

    }

    @Override
    public ProductVariant getProductVariant(long variantId) {

        Optional<ProductVariant> optionalProductVariant = productVariantRepository.findById(variantId);
        if (optionalProductVariant.isEmpty()){
            throw new ResourceNotFoundException("Product variant Not Found !");
        }

        return optionalProductVariant.get();
    }

    @Override
    public ProductVariant saveProductVariant(ProductVariant productVariant) {

        return productVariantRepository.save(productVariant);
    }

}

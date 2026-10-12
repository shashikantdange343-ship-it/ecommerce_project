package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.DTOs.ProductsDTOs.ProductDTOS;
import com.shashi.ecommerce.Entity.ProductsEntity.Products;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<ProductDTOS.GetAllProductDTO> getProducts(int pageNumber);

    ProductDTOS.AddProductResponseDTO addProduct(ProductDTOS.AddFullProductRequestDTO request);

    public ProductDTOS.GetProductDetailsDTO getProductDetails(long id);

}

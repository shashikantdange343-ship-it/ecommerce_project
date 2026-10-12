package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.Entity.ProductsEntity.ProductImages;

import java.util.List;

public interface ProductImagesService {
    List<ProductImages> getProductImages(long productId);
}

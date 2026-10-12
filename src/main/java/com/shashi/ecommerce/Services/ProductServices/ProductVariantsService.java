package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.Entity.ProductsEntity.ProductVariant;

import java.util.List;

public interface ProductVariantsService {
    List<ProductVariant> getProductVariants(long productId);
    ProductVariant getProductVariant(long variantId);
}

package com.shashi.ecommerce.Services.ProductServices;

import com.shashi.ecommerce.Entity.ProductsEntity.ProductImages;
import com.shashi.ecommerce.Repository.ProductRepositories.ProductImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImagesServiceImpl implements ProductImagesService{

    private final ProductImagesRepository productImagesRepository;

    @Override
    public List<ProductImages> getProductImages(long productId) {
       return productImagesRepository.findByProductsId(productId);
    }
}

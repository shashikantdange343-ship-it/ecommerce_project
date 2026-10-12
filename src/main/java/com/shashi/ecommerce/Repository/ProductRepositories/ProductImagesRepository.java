package com.shashi.ecommerce.Repository.ProductRepositories;

import com.shashi.ecommerce.Entity.ProductsEntity.ProductImages;
import com.shashi.ecommerce.Entity.ProductsEntity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
    List<ProductImages> findByProductsId(long productId);
}

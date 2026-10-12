package com.shashi.ecommerce.Repository.ProductRepositories;

import com.shashi.ecommerce.Entity.ProductsEntity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant , Long> {
    List<ProductVariant> findByProductsId(long productId);
}

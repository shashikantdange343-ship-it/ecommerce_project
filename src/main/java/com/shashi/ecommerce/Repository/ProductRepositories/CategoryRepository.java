package com.shashi.ecommerce.Repository.ProductRepositories;

import com.shashi.ecommerce.Entity.ProductsEntity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories , Long > {
}

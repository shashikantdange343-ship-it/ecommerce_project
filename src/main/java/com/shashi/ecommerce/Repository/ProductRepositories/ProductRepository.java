package com.shashi.ecommerce.Repository.ProductRepositories;

import com.shashi.ecommerce.Entity.ProductsEntity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ProductRepository extends JpaRepository<Products , Long > {

}

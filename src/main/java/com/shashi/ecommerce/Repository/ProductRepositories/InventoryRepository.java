package com.shashi.ecommerce.Repository.ProductRepositories;

import com.shashi.ecommerce.Entity.ProductsEntity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}

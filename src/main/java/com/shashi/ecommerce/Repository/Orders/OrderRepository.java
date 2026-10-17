package com.shashi.ecommerce.Repository.Orders;

import com.shashi.ecommerce.Entity.Orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
}

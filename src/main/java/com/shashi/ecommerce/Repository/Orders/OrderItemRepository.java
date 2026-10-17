package com.shashi.ecommerce.Repository.Orders;

import com.shashi.ecommerce.Entity.Orders.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems , Long > {
}

package com.shashi.ecommerce.Services.OrderServices;

import com.shashi.ecommerce.DTOs.OrdersDTOs.OrderItemDTOs;
import com.shashi.ecommerce.Entity.Orders.OrderItems;

import java.util.List;

public interface OrderItemService {

    OrderItems AddOrderItems(OrderItemDTOs.OrderItemRequestDTO orderItems);

}

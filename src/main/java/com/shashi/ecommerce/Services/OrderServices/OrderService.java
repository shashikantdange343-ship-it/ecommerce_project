package com.shashi.ecommerce.Services.OrderServices;

import com.shashi.ecommerce.DTOs.OrdersDTOs.OrderDTOs;
import com.shashi.ecommerce.DTOs.OrdersDTOs.OrderItemDTOs;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    OrderDTOs.OrderResponse handleOrders(OrderDTOs.OrderRequestDTO order, String userName);

    OrderDTOs.OrderDetailsListDTO ordersList(String userName );
}

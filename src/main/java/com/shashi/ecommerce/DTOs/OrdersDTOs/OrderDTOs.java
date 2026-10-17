package com.shashi.ecommerce.DTOs.OrdersDTOs;

import com.shashi.ecommerce.DTOs.UserDTOs.AddressDTOs;

import java.util.List;

public class OrderDTOs {

    public record OrderRequestDTO(
            List<OrderItemDTOs.OrderItemRequestDTO> orderItems,

            Long addressId

    ){}

    public record OrderResponse(
            String message
    ){}

    public record OrderDetailsDTO(

            List<OrderItemDTOs.OrderItemDetailsDTO> orderItems ,

            Double totalAmount
    ){}

    public record OrderDetailsListDTO(
            List<OrderDetailsDTO> orders
    ){}
}

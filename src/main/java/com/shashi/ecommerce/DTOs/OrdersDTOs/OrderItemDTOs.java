package com.shashi.ecommerce.DTOs.OrdersDTOs;

import com.shashi.ecommerce.DTOs.ProductsDTOs.ProductVariantsDTOS;
import com.shashi.ecommerce.Entity.Orders.OrderStatus;
import jakarta.validation.constraints.NotNull;

public class OrderItemDTOs {

    public record OrderItemRequestDTO(

            @NotNull
            Long variantId ,

            @NotNull
            int quantity
    ){}
    public record OrderItemVariantDetailsDTO(

            Long productVariantId,

            String variantColor,

            Double variantSize,

            Double price,

            Double extraPrice

    ){}
    public record OrderItemDetailsDTO(

            String productName ,

            String brandName,

            OrderItemVariantDetailsDTO variant,

            Integer quantity,

            OrderStatus orderStatus

    ){}
}

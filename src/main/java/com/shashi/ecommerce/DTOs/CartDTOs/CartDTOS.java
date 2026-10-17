package com.shashi.ecommerce.DTOs.CartDTOs;

import com.shashi.ecommerce.DTOs.ProductsDTOs.ProductDTOS;
import com.shashi.ecommerce.DTOs.ProductsDTOs.ProductVariantsDTOS;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CartDTOS {
    public record AddToCartRequestDTO(

            @NotNull
            Long variantId,

            @NotNull
            Integer quantity
    ) {}

    public record AddToCartResponseDTO(
            String message
    ){}

    public record CartProductDTO(
            String productName,

            String brandName,

            ProductVariantsDTOS.ProductVariantDTO productVariant,

            Integer quantity
    ){}

    public record ViewCartDTO(
            List<CartProductDTO> cartProducts,

            Double totalAmount
    ){}
}

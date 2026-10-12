package com.shashi.ecommerce.Services.CartServices;

import com.shashi.ecommerce.DTOs.CartDTOs.CartDTOS;

public interface CartService {
    CartDTOS.AddToCartResponseDTO addToCart(CartDTOS.AddToCartRequestDTO request , String userName);

    CartDTOS.ViewCartDTO viewToCart( String userName);
}

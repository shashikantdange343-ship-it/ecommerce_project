package com.shashi.ecommerce.Services.CartServices;

import com.shashi.ecommerce.DTOs.CartDTOs.CartDTOS;
import com.shashi.ecommerce.Entity.Cart.Cart;
import com.shashi.ecommerce.Entity.Cart.CartItems;

import java.util.List;

public interface CartItemService {
    CartItems AddCartItem(Cart cart, CartDTOS.AddToCartRequestDTO request);

    List<CartItems> getCartItems(Cart cart);
}

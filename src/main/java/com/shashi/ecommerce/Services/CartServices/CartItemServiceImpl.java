package com.shashi.ecommerce.Services.CartServices;

import com.shashi.ecommerce.DTOs.CartDTOs.CartDTOS;
import com.shashi.ecommerce.Entity.Cart.Cart;
import com.shashi.ecommerce.Entity.Cart.CartItems;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.Cart.CartItemRepository;
import com.shashi.ecommerce.Services.ProductServices.ProductVariantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService{

    private final CartItemRepository cartItemRepository;

    private final ProductVariantsService productVariantsService;

    @Override
    public CartItems AddCartItem(Cart cart , CartDTOS.AddToCartRequestDTO request) {

        CartItems newCartItem = new CartItems();
        newCartItem.setCart(cart);
        newCartItem.setProductVariant(productVariantsService.getProductVariant(request.variantId()));
        newCartItem.setQuantity(request.quantity());
        return newCartItem;

    }

    @Override
    public List<CartItems> getCartItems(Cart cart) {
       Optional<List<CartItems>> optionalCartItems = cartItemRepository.findByCartId(cart.getId());
       if (optionalCartItems.isEmpty()){
           throw new ResourceNotFoundException("No Cart Items !");
       }
        return optionalCartItems.get();
    }
}

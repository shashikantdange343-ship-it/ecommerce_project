package com.shashi.ecommerce.Services.CartServices;

import com.shashi.ecommerce.DTOs.CartDTOs.CartDTOS;
import com.shashi.ecommerce.Entity.Cart.Cart;
import com.shashi.ecommerce.Entity.Cart.CartItems;
import com.shashi.ecommerce.Entity.ProductsEntity.ProductVariant;
import com.shashi.ecommerce.Entity.UsersEntity.User;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.Cart.CartRepository;
import com.shashi.ecommerce.Repository.ProductRepositories.ProductVariantRepository;
import com.shashi.ecommerce.Services.ClassConverterService;
import com.shashi.ecommerce.Services.ProductServices.ProductVariantsService;
import com.shashi.ecommerce.Services.UserServices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final ProductVariantsService productVariantsService;

    private final ClassConverterService classConverterService;

    private final UserService userService;

    private final CartRepository cartRepository;

    private final CartItemService cartItemService;

    @Override
    public CartDTOS.AddToCartResponseDTO addToCart(CartDTOS.AddToCartRequestDTO request, String userName) {
        User existingUser = userService.getUser(userName);
        Cart userCart = cartRepository.findByUserId(existingUser.getId());
        ProductVariant productVariant = productVariantsService.getProductVariant(request.variantId());

        if (userCart == null){
            Cart newCart = new Cart();
            newCart.setCartItems(new ArrayList<>());
            newCart.setUser(existingUser);
            newCart.setTotalPrice(0.0);

           userCart = cartRepository.save(newCart);
        }
        if (userCart.getCartItems() == null){
            userCart.setCartItems(new ArrayList<>());
        }

        userCart.setUser(existingUser);


        boolean isAlreadyExists = false;
        List<CartItems> cartItemsList = cartItemService.getCartItems(userCart);
        double totalAmount = 0.0;
        for (CartItems cartItems : cartItemsList){
           totalAmount = totalAmount + cartItems.getProductVariant().getExtraPrice()+
                   cartItems.getProductVariant().getProducts().getBasePrice()
                           *cartItems.getQuantity();

            if (cartItems.getProductVariant().getId().equals(request.variantId())){
                cartItems.setQuantity(cartItems.getQuantity() + request.quantity());
                isAlreadyExists = true;
                break;
            }
        }


        if (!isAlreadyExists){
            CartItems newcartItem = cartItemService.AddCartItem(userCart,request);
            userCart.getCartItems().add(newcartItem);
        }
        userCart.setTotalPrice(totalAmount+request.quantity()*productVariant.getProducts().getBasePrice()+productVariant.getExtraPrice());

        productVariantsService.saveProductVariant(productVariant);
        cartRepository.save(userCart);

        return new CartDTOS.AddToCartResponseDTO(" Item Added Successfully !");

    }


    @Override
    public CartDTOS.ViewCartDTO viewToCart(String userName) {
        User existingUser = userService.getUser(userName);
        Cart userCart = cartRepository.findByUserId(existingUser.getId());

        if (userCart == null){
            return new CartDTOS.ViewCartDTO(new ArrayList<>(),0.0);
        }
        return new CartDTOS.ViewCartDTO(cartItemService.getCartItems(userCart).stream()
                .map(classConverterService::toCartProductDTO).toList(),
                userCart.getTotalPrice());
    }
}

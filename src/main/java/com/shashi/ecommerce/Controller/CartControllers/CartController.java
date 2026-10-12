package com.shashi.ecommerce.Controller.CartControllers;

import com.shashi.ecommerce.DTOs.CartDTOs.CartDTOS;
import com.shashi.ecommerce.Services.CartServices.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {

    private final CartService cartService;

    @GetMapping("/view")
    public ResponseEntity<CartDTOS.ViewCartDTO> viewCart(Principal principal){
        String userName = principal.getName();
        return ResponseEntity.ok(cartService.viewToCart(userName));
    }

    @PostMapping
    public ResponseEntity<CartDTOS.AddToCartResponseDTO> addToCart(@RequestBody CartDTOS.AddToCartRequestDTO request, Principal principal){
        String userName = principal.getName();
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addToCart(request, userName));
    }
}

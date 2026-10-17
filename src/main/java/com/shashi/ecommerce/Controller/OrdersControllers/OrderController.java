package com.shashi.ecommerce.Controller.OrdersControllers;

import com.shashi.ecommerce.DTOs.OrdersDTOs.OrderDTOs;
import com.shashi.ecommerce.Services.OrderServices.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<OrderDTOs.OrderResponse> placeOrder(@RequestBody OrderDTOs.OrderRequestDTO orderRequest, Principal principal){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.handleOrders(orderRequest, principal.getName()));
    }

    @GetMapping("/all")
    public ResponseEntity<OrderDTOs.OrderDetailsListDTO> orderDetails(Principal principal){
        return ResponseEntity.ok(orderService.ordersList(principal.getName()));
    }

}

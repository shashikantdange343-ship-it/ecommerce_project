package com.shashi.ecommerce.Controller.UserController;

import com.shashi.ecommerce.DTOs.UserDTOs.AuthDTOs;
import com.shashi.ecommerce.Services.UserServices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthDTOs.RegisterResponseDTO> register(@RequestBody AuthDTOs.RegisterRequestDTO requestDTO){
       return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(requestDTO)) ;
    }
}

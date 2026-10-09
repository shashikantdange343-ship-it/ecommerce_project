package com.shashi.ecommerce.Controller.UserControllers;

import com.shashi.ecommerce.DTOs.UserDTOs.AuthDTOs;
import com.shashi.ecommerce.Services.UserServices.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<AuthDTOs.RegisterResponseDTO> register(@Valid @RequestBody AuthDTOs.RegisterRequestDTO requestDTO){
       return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(requestDTO)) ;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDTOs.LoginResponseDTO> loginUser(@Valid @RequestBody AuthDTOs.LoginRequestDTO requestDTO){
        return ResponseEntity.ok().body(userService.loginUser(requestDTO));
    }

}

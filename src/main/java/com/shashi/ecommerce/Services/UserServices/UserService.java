package com.shashi.ecommerce.Services.UserServices;

import com.shashi.ecommerce.DTOs.UserDTOs.AuthDTOs;

public interface UserService {

    AuthDTOs.RegisterResponseDTO registerUser(AuthDTOs.RegisterRequestDTO request);

}

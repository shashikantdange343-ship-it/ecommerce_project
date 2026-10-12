package com.shashi.ecommerce.Services.UserServices;

import com.shashi.ecommerce.DTOs.UserDTOs.AuthDTOs;
import com.shashi.ecommerce.Entity.UsersEntity.User;

public interface UserService {

    AuthDTOs.RegisterResponseDTO registerUser(AuthDTOs.RegisterRequestDTO request);

    AuthDTOs.LoginResponseDTO loginUser(AuthDTOs.LoginRequestDTO request);

    User getUser(String userName);

}

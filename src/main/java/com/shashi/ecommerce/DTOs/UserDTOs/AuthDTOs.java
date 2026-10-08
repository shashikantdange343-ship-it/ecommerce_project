package com.shashi.ecommerce.DTOs.UserDTOs;

public class AuthDTOs {
    //LOGIN DTOs
    public record LoginRequestDTO(String userName , String password){}
    public record LoginResponseDTO(){}

    //REGISTER DTOs
    public record RegisterRequestDTO(String email , String password , String firstName , String lastName , String PhoneNo, String userName ){}
    public record RegisterResponseDTO(String message){}
}

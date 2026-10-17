package com.shashi.ecommerce.DTOs.UserDTOs;

import com.shashi.ecommerce.Entity.UsersEntity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

public class AddressDTOs {

    public record SetAddressRequestDTO(

            @NotBlank
            String addressType,

            @NotBlank
            String street,

            @NotBlank
            String city,

            @NotBlank
            String state,

            @NotNull
            Integer pinCode,

            Boolean isDefault

    ){}

    public record SetAddressResponseDTO(

            Long id,

            @NotBlank
            String addressType,

            @NotBlank
            String street,

            @NotBlank
            String city,

            @NotBlank
            String state,

            @NotNull
            Integer pinCode
    ){}


}

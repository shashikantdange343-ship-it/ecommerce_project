package com.shashi.ecommerce.DTOs.UserDTOs;

import java.time.LocalDateTime;

public record ExceptionDTO(LocalDateTime timestamp , String message , String details , int status) {
}

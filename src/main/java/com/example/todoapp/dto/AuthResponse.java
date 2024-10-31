package com.example.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * `@authority` DUSHAN MALINDA
 * 18:29
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.dto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String message;
}

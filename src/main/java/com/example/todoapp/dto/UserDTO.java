package com.example.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * `@authority` DUSHAN MALINDA
 * 18:21
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.dto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID id;
    private String email;
    private String password;
}

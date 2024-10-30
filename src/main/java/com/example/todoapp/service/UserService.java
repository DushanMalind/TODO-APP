package com.example.todoapp.service;

import com.example.todoapp.dto.UserDTO;
import com.example.todoapp.entity.User;

/**
 * `@authority` DUSHAN MALINDA
 * 18:42
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.service
 */
public interface UserService {
    int saveUser(UserDTO userDTO);
    User findByEmail(String email);

}

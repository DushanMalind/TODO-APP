package com.example.todoapp.controller;

import com.example.todoapp.dto.AuthRequest;
import com.example.todoapp.dto.AuthResponse;
import com.example.todoapp.dto.UserDTO;
import com.example.todoapp.entity.User;
import com.example.todoapp.service.impl.UserServiceImpl;
import com.example.todoapp.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

/**
 * `@authority` DUSHAN MALINDA
 * 12:49
 * 31/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.controller
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil; // Keep this final
    private final UserServiceImpl userService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest authRequest) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(authRequest.getEmail());
        userDTO.setPassword(authRequest.getPassword());

        int userId = userService.saveUser(userDTO);
        if (userId == 0) {
            throw new RuntimeException("User registration failed");
        }
        // Generate token using email
        String token = jwtUtil.generateToken(authRequest.getEmail());
        System.out.println("Token: " + token);

        // Return the token and a message
        return new AuthResponse(token, "User registered successfully with ID: " + userId);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        // Generate token using email
        String token = jwtUtil.generateToken(authRequest.getEmail());
        System.out.println("Token: " + token);

        // Return the token and a message
        return new AuthResponse(token, "User logged in successfully");
    }
}

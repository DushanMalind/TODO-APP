package com.example.todoapp.exception;

import com.example.todoapp.dto.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * `@authority` DUSHAN MALINDA
 * 14:52
 * 31/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.exception
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({UnauthorizedException.class})
    public ResponseEntity<AuthResponse> handleUnauthorizedException(UnauthorizedException ex) {
        AuthResponse response = new AuthResponse(null, "Unauthorized access: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
    }
}



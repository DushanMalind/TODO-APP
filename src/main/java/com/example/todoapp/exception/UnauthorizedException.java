package com.example.todoapp.exception;

/**
 * `@authority` DUSHAN MALINDA
 * 14:55
 * 31/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.exception
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}

package com.example.todoapp.exception;

/**
 * `@authority` DUSHAN MALINDA
 * 23:41
 * 31/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.exception
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }

    // Optionally, you can override the getMessage() method if needed.
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}


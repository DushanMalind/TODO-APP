package com.example.todoapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * `@authority` DUSHAN MALINDA
 * 18:07
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.entity
 */

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}

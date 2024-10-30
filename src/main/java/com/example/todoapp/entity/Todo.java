package com.example.todoapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * `@authority` DUSHAN MALINDA
 * 18:12
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.entity
 */

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;
    private String description;
    private Boolean completed;
    private String priority;
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

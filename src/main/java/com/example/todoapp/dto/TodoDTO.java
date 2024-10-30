package com.example.todoapp.dto;

import lombok.Data;

import java.util.Date;

/**
 * `@authority` DUSHAN MALINDA
 * 18:23
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.dto
 */
@Data
public class TodoDTO {
    private String title;
    private String description;
    private Boolean completed;
    private String priority;
    private Date dueDate;
}

package com.example.todoapp.service;

import com.example.todoapp.dto.TodoDTO;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;

import java.util.List;

/**
 * `@authority` DUSHAN MALINDA
 * 19:52
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.service
 */
public interface TodoService {
    Todo createTodo(TodoDTO todoDTO, User user);
    List<Todo> getTodos(User user);
    Todo updateTodo(Long id, TodoDTO todoDTO, User user);
    void deleteTodo(Long id, User user);
}

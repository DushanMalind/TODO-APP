package com.example.todoapp.service;

import com.example.todoapp.dto.TodoDTO;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

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
    Todo updateTodo(UUID id, TodoDTO todoDTO, User user);
    void deleteTodo(UUID id, User user);

    Page<Todo> getTodosByPage(User user, Pageable pageable);
    List<Todo> searchTodos(User user, String keyword);
}

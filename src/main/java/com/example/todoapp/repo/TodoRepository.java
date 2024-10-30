package com.example.todoapp.repo;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * `@authority` DUSHAN MALINDA
 * 18:36
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.repo
 */
public interface TodoRepository extends JpaRepository<Todo, UUID> {
    List<Todo> findByUser(User user);
}

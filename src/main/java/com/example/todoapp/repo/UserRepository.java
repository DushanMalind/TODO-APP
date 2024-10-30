package com.example.todoapp.repo;

import com.example.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * `@authority` DUSHAN MALINDA
 * 18:33
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.repo
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}

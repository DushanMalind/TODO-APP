package com.example.todoapp.repo;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    List<Todo> findByUser(User user, org.springframework.data.domain.Sort sort);

    // Custom query for searching todos by title containing a keyword
    @Query("SELECT t FROM Todo t WHERE t.user = :user AND LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Todo> findByUserAndTitleContainingIgnoreCase(@Param("user") User user, @Param("keyword") String keyword);
}

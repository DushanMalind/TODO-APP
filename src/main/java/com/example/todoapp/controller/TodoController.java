package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoDTO;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.exception.UnauthorizedException;
import com.example.todoapp.service.impl.TodoServiceImpl;
import com.example.todoapp.service.impl.UserServiceImpl;
import com.example.todoapp.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * `@authority` DUSHAN MALINDA
 * 14:26
 * 31/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.controller
 */
@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoServiceImpl todoService;
    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;

    private String getEmailFromToken(String token) {
        return jwtUtil.getEmailFromToken(token.replace("Bearer ", ""));
    }

    @PostMapping("/add")
    public Todo createTodo(@RequestHeader("Authorization") String token, @RequestBody TodoDTO todoDTO) {
       try {
           String email = getEmailFromToken(token.substring(7));
           User user = userService.findByEmail(email);
           return todoService.createTodo(todoDTO, user);
       }catch (Exception e){
           System.out.println("Exception occurred: " + e.getMessage());
           throw new UnauthorizedException("Unauthorized access: Invalid token or user not found");
       }
    }

    @GetMapping("/get")
    public List<Todo> getTodos(@RequestHeader("Authorization") String token) {
        try {
            String email = getEmailFromToken(token.substring(7));
            User user = userService.findByEmail(email);
            return todoService.getTodos(user);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            throw new UnauthorizedException("Unauthorized access: Invalid token or user not found");
        }
    }

    @PutMapping("/update/{id}")
    public Todo updateTodo(@RequestHeader("Authorization") String token, @PathVariable UUID id, @RequestBody TodoDTO todoDTO) {
        String email = getEmailFromToken(token);
        User user = userService.findByEmail(email);
        return todoService.updateTodo(id, todoDTO, user);
    }




    /*@PostMapping("/add")
    public ResponseEntity<Todo> createTodo(@RequestHeader("Authorization") String token, @RequestBody TodoDTO todoDTO) {
        try {
            String email = getEmailFromToken(token.substring(7));
            User user = userService.findByEmail(email);

            if (user == null) {
                throw new UnauthorizedException("Unauthorized access: User not found");
            }
            Todo createdTodo = todoService.createTodo(todoDTO, user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);

        } catch (UnauthorizedException e) {
            throw e;

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            throw new UnauthorizedException("Unauthorized access: Invalid token or user not found");
        }
    }*/

}

package com.example.todoapp.service.impl;

import com.example.todoapp.dto.TodoDTO;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.repo.TodoRepository;
import com.example.todoapp.service.TodoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * `@authority` DUSHAN MALINDA
 * 19:55
 * 30/10/2024
 * ASUS
 * Todo-App
 * com.example.todoapp.service.impl
 */
@Service
@RequiredArgsConstructor
@Transactional
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Todo createTodo(TodoDTO todoDTO, User user) {
        Todo todo = modelMapper.map(todoDTO, Todo.class);
        todo.setUser(user);
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public List<Todo> getTodos(User user) {
        return todoRepository.findByUser(user);
    }

    @Override
    public Todo updateTodo(UUID id, TodoDTO todoDTO, User user) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        if (!todo.getUser().equals(user)) {
            throw new RuntimeException("Unauthorized access");
        }
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.getCompleted());
        todo.setPriority(todoDTO.getPriority());
        todo.setDueDate(todoDTO.getDueDate());
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public void deleteTodo(UUID id, User user) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        if (todo.getUser().getId().equals(user.getId())) {
            todoRepository.delete(todo);
        }
    }

    @Override
    public Page<Todo> getTodosByPage(User user, Pageable pageable) {
        return todoRepository.findByUser(user, pageable);
    }

    @Override
    public List<Todo> searchTodos(User user, String keyword) {
        return todoRepository.findByTitleContainingAndUser(keyword, user);
    }
}

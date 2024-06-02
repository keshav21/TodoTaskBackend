package com.todo.service;

import com.todo.models.TodoItem;
import com.todo.models.enums.Status;
import com.todo.models.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    // Get all todo items
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    // Create a new todo item
    public TodoItem createTodoItem(TodoItem todoItem) {
        // Generate a unique ID for the todo item
        todoItem.setId(UUID.randomUUID());
        // Print the todo item to the console
        System.out.println(todoItem);
        // Save the todo item to the database
        return todoItemRepository.save(todoItem);
    }

    // Update an existing todo item
    public TodoItem updateTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    // Delete a todo item by ID
    public boolean deleteTodoItem(String id) {
        if (!todoItemRepository.existsById(UUID.fromString(id))) {
            return false;
        }
        todoItemRepository.deleteById(UUID.fromString(id));
        return true;
    }

    // Cancel a todo item by ID
    public TodoItem cancelTodoItem(String id) {
        // Find the todo item by ID
        TodoItem todoItem = todoItemRepository.findById(UUID.fromString(id)).orElse(null);
        // If the todo item exists, set it as cancelled
        if (todoItem != null) {
            todoItem.setCanceled(true);
            todoItem.setStatus(Status.cancelled.toString());
            return todoItemRepository.save(todoItem);
        }
        return null;
    }
}

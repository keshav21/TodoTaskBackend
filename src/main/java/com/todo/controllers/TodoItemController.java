package com.todo.controllers;

import com.todo.models.TodoItem;
import com.todo.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    // Get all todo items
    @GetMapping("/get/all")
    public List<TodoItem> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }

    // Create a new todo item
    @PostMapping("/create")
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.createTodoItem(todoItem);
    }

    // Update an existing todo item
    @PutMapping("/update")
    public TodoItem updateTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.updateTodoItem(todoItem);
    }

    // Delete a todo item by ID
    @DeleteMapping("/delete/{id}")
    public boolean deleteTodoItem(@PathVariable String id) {
        return todoItemService.deleteTodoItem(id);
    }

    // Cancel a todo item by ID
    @PostMapping("cancel/{id}")
    public TodoItem cancelTodoItem(@PathVariable String id) {
        return todoItemService.cancelTodoItem(id);
    }
}

package com.todo.controllers;

import com.todo.models.TodoItem;
import com.todo.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/todo")
public class TodoItemController {

    private static final Logger logger = LoggerFactory.getLogger(TodoItemController.class);

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/get/all")
    public List<TodoItem> getAllTodoItems() {
        logger.info("Getting all todo items");
        return todoItemService.getAllTodoItems();
    }

    @PostMapping("/create")
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
        logger.info("Creating todo item: {}", todoItem);
        return todoItemService.createTodoItem(todoItem);
    }

    @PutMapping("/update")
    public TodoItem updateTodoItem(@RequestBody TodoItem todoItem) {
        logger.info("Updating todo item {}:", todoItem);
        return todoItemService.updateTodoItem(todoItem);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteTodoItem(@PathVariable String id) {
        logger.info("Deleting todo item with ID: {}", id);
        return todoItemService.deleteTodoItem(id);
    }

    @PostMapping("cancel/{id}")
    public TodoItem cancelTodoItem(@PathVariable String id) {
        logger.info("Cancel todo item with ID: {}", id);
        return todoItemService.cancelTodoItem(id);
    }
}
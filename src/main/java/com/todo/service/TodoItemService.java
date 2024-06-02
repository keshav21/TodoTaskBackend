package com.todo.service;

import com.todo.models.TodoItem;
import com.todo.models.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    public TodoItem createTodoItem(TodoItem todoItem) {
        todoItem.setId(UUID.randomUUID());
        System.out.println(todoItem);
        return todoItemRepository.save(todoItem);
    }

    public TodoItem updateTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    public boolean deleteTodoItem(String id) {
        if (!todoItemRepository.existsById(UUID.fromString(id))) {
            return false;
        }
        todoItemRepository.deleteById(UUID.fromString(id));
        return true;
    }

    public TodoItem cancelTodoItem(String id) {
        TodoItem todoItem = todoItemRepository.findById(UUID.fromString(id)).orElse(null);
        if (todoItem != null) {
            todoItem.setCanceled(true);
            return todoItemRepository.save(todoItem);
        }
        return null;
    }
}

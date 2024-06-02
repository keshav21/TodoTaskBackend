package com.todo.service;

import com.todo.models.TodoItem;
import com.todo.models.repositories.TodoItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

// Importing necessary Mockito and JUnit extensions

@ExtendWith(MockitoExtension.class)
public class TodoItemServiceTest {

    @Mock
    private TodoItemRepository todoItemRepository;

    @InjectMocks
    private TodoItemService todoItemService;

    // Test method to verify getAllTodoItems() functionality
    @Test
    public void getAllTodoItems() {
        List<TodoItem> todoItems = new ArrayList<>();
        todoItems.add(new TodoItem());
        todoItems.add(new TodoItem());
        when(todoItemRepository.findAll()).thenReturn(todoItems);
        List<TodoItem> result = todoItemService.getAllTodoItems();
        assertEquals(2, result.size());
    }

    // Test method to verify createTodoItem() functionality
    @Test
    public void createTodoItem() {
        TodoItem todoItem = new TodoItem();
        when(todoItemRepository.save(todoItem)).thenReturn(todoItem);
        TodoItem result = todoItemService.createTodoItem(todoItem);
        assertNotNull(result);
        assertEquals(todoItem, result);
    }

    // Test method to verify updateTodoItem() functionality
    @Test
    public void updateTodoItem() {
        UUID id = UUID.randomUUID();
        TodoItem existingTodoItem = new TodoItem();
        existingTodoItem.setId(id);
        when(todoItemRepository.save(existingTodoItem)).thenReturn(existingTodoItem);
        TodoItem result = todoItemService.updateTodoItem(existingTodoItem);
        assertNotNull(result);
    }

    // Test method to verify deleteTodoItem() functionality with valid ID
    @Test
    public void deleteTodoItem_WithValidId() {
        UUID id = UUID.randomUUID();
        when(todoItemRepository.existsById(id)).thenReturn(true);
        boolean result = todoItemService.deleteTodoItem(String.valueOf(id));
        assertTrue(result);
        verify(todoItemRepository, times(1)).deleteById(id);
    }

    // Test method to verify cancelTodoItem() functionality with valid ID
    @Test
    public void cancelTodoItem_WithValidId() {
        UUID id = UUID.randomUUID();
        TodoItem existingTodoItem = new TodoItem();
        existingTodoItem.setId(id);
        when(todoItemRepository.findById(id)).thenReturn(Optional.of(existingTodoItem));
        when(todoItemRepository.save(existingTodoItem)).thenReturn(existingTodoItem);
        TodoItem result = todoItemService.cancelTodoItem(String.valueOf(id));
        assertNotNull(result);
        assertTrue(result.isCanceled());
    }
}

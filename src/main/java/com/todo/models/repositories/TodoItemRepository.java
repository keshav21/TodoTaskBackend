package com.todo.models.repositories;

import com.todo.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

// Interface extending JpaRepository to handle CRUD operations for TodoItem entities
public interface TodoItemRepository extends JpaRepository<TodoItem, UUID> {
}

package com.todo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class TodoItem {

    // Unique identifier for the todo item
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    // Title of the todo item
    private String title;

    // Description of the todo item
    private String description;

    // Due date of the todo item
    private Date dueDate;

    // Priority of the todo item
    private String priority;

    // Status of the todo item (complete/incomplete)
    private String status;

    // Type of recurring task
    private String recurringType;

    // Flag indicating if the todo item is cancelled
    private boolean canceled;

    // Flag indicating if the todo item is recurring
    private boolean recurring;
}

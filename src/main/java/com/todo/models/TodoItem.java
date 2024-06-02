package com.todo.models;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class TodoItem {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String title;
    private String description;
    private Date dueDate;
    private int priority;
    private boolean status; // complete/incomplete
    private boolean canceled;
    private boolean recurring;
}
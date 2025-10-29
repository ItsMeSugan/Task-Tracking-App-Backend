package com.sugan.tasks.doman.dto;

import com.sugan.tasks.doman.entities.TaskPriority;
import com.sugan.tasks.doman.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
    UUID id,
    String title,
    String description,
    LocalDateTime dueDate,
    TaskPriority priority,
    TaskStatus status) {}

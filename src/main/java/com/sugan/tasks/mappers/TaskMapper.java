package com.sugan.tasks.mappers;

import com.sugan.tasks.doman.dto.TaskDto;
import com.sugan.tasks.doman.entities.Task;

public interface TaskMapper {

  Task fromDto(TaskDto taskDto);

  TaskDto toDto(Task task);
}

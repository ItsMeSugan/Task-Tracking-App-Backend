package com.sugan.tasks.mappers;

import com.sugan.tasks.doman.dto.TaskListDto;
import com.sugan.tasks.doman.entities.TaskList;

public interface TaskListMapper {

  TaskList fromDto(TaskListDto taskListDto);

  TaskListDto toDto(TaskList taskList);
}

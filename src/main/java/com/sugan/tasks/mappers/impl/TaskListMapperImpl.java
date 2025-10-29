package com.sugan.tasks.mappers.impl;

import com.sugan.tasks.doman.dto.TaskListDto;
import com.sugan.tasks.doman.entities.Task;
import com.sugan.tasks.doman.entities.TaskList;
import com.sugan.tasks.doman.entities.TaskStatus;
import com.sugan.tasks.mappers.TaskListMapper;
import com.sugan.tasks.mappers.TaskMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TaskListMapperImpl implements TaskListMapper {

  private final TaskMapper taskMapper;

  public TaskListMapperImpl(TaskMapper taskMapper) {
    this.taskMapper = taskMapper;
  }

  @Override
  public TaskList fromDto(TaskListDto taskListDto) {
    return new TaskList(
        taskListDto.id(),
        taskListDto.title(),
        taskListDto.description(),
        Optional.ofNullable(taskListDto.tasks())
            .map(tasks -> tasks.stream().map(taskMapper::fromDto).toList())
            .orElse(null),
        null,
        null);
  }

  @Override
  public TaskListDto toDto(TaskList taskList) {
    return new TaskListDto(
        taskList.getId(),
        taskList.getTitle(),
        taskList.getDescription(),
        Optional.ofNullable(taskList.getTasks()).map(List::size).orElse(0),
        calculateTaskListProgress(taskList.getTasks()),
        Optional.ofNullable(taskList.getTasks())
            .map(tasks -> tasks.stream().map(taskMapper::toDto).toList())
            .orElse(null));
  }

  private Double calculateTaskListProgress(List<Task> tasks) {
    if (null == tasks || tasks.isEmpty()) {
      return 0.0;
    }

    long closedTaskCount =
        tasks.stream().filter(task -> TaskStatus.CLOSED == task.getStatus()).count();
    return (double) closedTaskCount / tasks.size();
  }
}

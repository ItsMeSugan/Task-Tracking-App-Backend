package com.sugan.tasks.service;

import com.sugan.tasks.doman.entities.TaskList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
  List<TaskList> listTaskLists();

  TaskList createTaskList(TaskList taskList);

  Optional<TaskList> getTaskList(UUID id);

  TaskList updateTaskList(UUID taskListId, TaskList taskList);

  void deleteTaskList(UUID taskListId);
}

package com.sugan.tasks.controller;

import com.sugan.tasks.doman.dto.TaskListDto;
import com.sugan.tasks.doman.entities.TaskList;
import com.sugan.tasks.mappers.TaskListMapper;
import com.sugan.tasks.service.TaskListService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController {

  private final TaskListService taskListService;
  private final TaskListMapper taskListMapper;

  public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
    this.taskListService = taskListService;
    this.taskListMapper = taskListMapper;
  }

  @GetMapping
  public List<TaskListDto> listTaskLists() {
    return taskListService.listTaskLists().stream().map(taskListMapper::toDto).toList();
  }

  @PostMapping
  public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
    TaskList createdTaskList = taskListService.createTaskList(taskListMapper.fromDto(taskListDto));

    return taskListMapper.toDto(createdTaskList);
  }

  @GetMapping(path = "/{task_list_id}")
  public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID id) {
    return taskListService.getTaskList(id).map(taskListMapper::toDto);
  }

  @PutMapping(path = "/{task_list_id}")
  public TaskListDto updateTaskList(
      @PathVariable("task_list_id") UUID taskListId, @RequestBody TaskListDto taskListDto) {

    TaskList updatedTaskList =
        taskListService.updateTaskList(taskListId, taskListMapper.fromDto(taskListDto));

    return taskListMapper.toDto(updatedTaskList);
  }

  @DeleteMapping(path = "/{task_list_id}")
  public void deleteTaskList(@PathVariable("task_list_id") UUID taskListId) {
    taskListService.deleteTaskList(taskListId);
  }
}

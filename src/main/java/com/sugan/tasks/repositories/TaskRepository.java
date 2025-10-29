package com.sugan.tasks.repositories;

import com.sugan.tasks.doman.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

  List<Task> findByTaskListId(UUID taskListID);

  Optional<Task> findByTaskListIdAndId(UUID taskListId, UUID id);

  void deleteByTaskListIdAndId(UUID taskListId, UUID id);
}

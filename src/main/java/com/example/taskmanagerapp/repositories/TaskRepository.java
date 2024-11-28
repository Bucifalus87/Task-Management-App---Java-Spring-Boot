package com.example.taskmanagerapp.repositories;

import com.example.taskmanagerapp.entities.Task;
import com.example.taskmanagerapp.entities.TaskState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByState(TaskState state);
    List<Task> findByOwnerId(Long ownerId);
}

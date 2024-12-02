package com.example.taskmanagerapp.controller;

import com.example.taskmanagerapp.dto.TaskDTO;
import com.example.taskmanagerapp.entities.Task;
import com.example.taskmanagerapp.entities.TaskState;
import com.example.taskmanagerapp.services.OwnerService;
import com.example.taskmanagerapp.services.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        // Convert List<Task> to List<TaskDTO>
        return taskService.getAllTasks().stream()
                .map(TaskDTO::new) // Map each Task to a TaskDTO
                .collect(Collectors.toList());
    }
}
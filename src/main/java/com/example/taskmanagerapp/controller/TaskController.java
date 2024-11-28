/*package com.example.taskmanagerapp.controller;

import com.example.taskmanagerapp.entities.Task;
import com.example.taskmanagerapp.entities.TaskState;
import com.example.taskmanagerapp.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/state/{state}")
    public List<Task> getTasksByState(@PathVariable TaskState state) {
        return taskService.getTasksByState(state);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Task> getTasksByOwner(@PathVariable Long ownerId) {
        return taskService.getTasksByOwner(ownerId);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}*/

package com.example.taskmanagerapp.controller;

import com.example.taskmanagerapp.entities.Owner;
import com.example.taskmanagerapp.entities.Task;
import com.example.taskmanagerapp.entities.TaskState;
import com.example.taskmanagerapp.services.OwnerService;
import com.example.taskmanagerapp.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final OwnerService ownerService; // Added OwnerService

    public TaskController(TaskService taskService, OwnerService ownerService) {
        this.taskService = taskService;
        this.ownerService = ownerService;
    }

    // Modified POST endpoint to accept ownerId
    @PostMapping
    public Task createTask(@RequestParam Long ownerId, @RequestBody Task task) {
        Owner owner = ownerService.getOwnerById(ownerId); // Get owner by ID
        task.setOwner(owner); // Associate the task with the owner
        return taskService.createTask(task); // Save the task
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/state/{state}")
    public List<Task> getTasksByState(@PathVariable TaskState state) {
        return taskService.getTasksByState(state);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Task> getTasksByOwner(@PathVariable Long ownerId) {
        return taskService.getTasksByOwner(ownerId);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}

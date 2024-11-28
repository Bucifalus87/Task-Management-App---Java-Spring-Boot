package com.example.taskmanagerapp.services;

import com.example.taskmanagerapp.entities.Task;
import com.example.taskmanagerapp.entities.TaskState;
import com.example.taskmanagerapp.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByState(TaskState state) {
        return taskRepository.findByState(state);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> getTasksByOwner(Long ownerId) {
        return taskRepository.findByOwnerId(ownerId);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTaskById(id);
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setState(updatedTask.getState());
        task.setEstimation(updatedTask.getEstimation());
        task.setRemainingEffort(updatedTask.getRemainingEffort());
        task.setCompletedHours(updatedTask.getCompletedHours());
        return taskRepository.save(task);
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

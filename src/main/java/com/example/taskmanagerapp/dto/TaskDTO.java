package com.example.taskmanagerapp.dto;

import com.example.taskmanagerapp.entities.Task;

public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private String state;
    private Integer estimation;
    private Integer remainingEffort;
    private Integer completedHours;

    // Constructor to initialize DTO from a Task entity
    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.state = task.getState().name();
        this.estimation = task.getEstimation();
        this.remainingEffort = task.getRemainingEffort();
        this.completedHours = task.getCompletedHours();
    }

    // Getters and setters (if needed)
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getState() {
        return state;
    }

    public Integer getEstimation() {
        return estimation;
    }

    public Integer getRemainingEffort() {
        return remainingEffort;
    }

    public Integer getCompletedHours() {
        return completedHours;
    }
}

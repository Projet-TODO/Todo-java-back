package com.takima.backskeleton.DTO;

import java.util.Date;

public class TaskDTO {
    private Long id_task;
    private String title_task;
    private String description_task;
    private int priority_task;
    private Date deadline_task;
    private boolean achieved_task;
    private Long id_project;

    // Getters and Setters
    public Long getId_task() {
        return id_task;
    }

    public void setId_task(Long id_task) {
        this.id_task = id_task;
    }

    public String getTitle_task() {
        return title_task;
    }

    public void setTitle_task(String title_task) {
        this.title_task = title_task;
    }

    public String getDescription_task() {
        return description_task;
    }

    public void setDescription_task(String description_task) {
        this.description_task = description_task;
    }

    public int getpriority_task() {
        return priority_task;
    }

    public void setpriority_task(int priority_task) {
        this.priority_task = priority_task;
    }

    public Date getDeadline_task() {
        return deadline_task;
    }

    public void setDeadline_task(Date deadline_task) {
        this.deadline_task = deadline_task;
    }

    public boolean isAchieved_task() {
        return achieved_task;
    }

    public void setAchieved_task(boolean achieved_task) {
        this.achieved_task = achieved_task;
    }

    public Long getId_project() {
        return id_project;
    }

    public void setId_project(Long id_project) {
        this.id_project = id_project;
    }
}


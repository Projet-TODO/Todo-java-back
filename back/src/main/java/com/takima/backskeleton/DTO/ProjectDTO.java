package com.takima.backskeleton.DTO;

import java.util.Date;

public class ProjectDTO {

    private Long id_project;
    private String name_project;
    private Date date_project;
    private Long id_user;

    // Getters and Setters
    public Long getId_project() {
        return id_project;
    }

    public void setId_project(Long id_project) {
        this.id_project = id_project;
    }

    public String getName_project() {
        return name_project;
    }

    public void setName_project(String name_project) {
        this.name_project = name_project;
    }

    public Date getDate_project() {
        return date_project;
    }

    public void setDate_project(Date date_project) {
        this.date_project = date_project;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
}

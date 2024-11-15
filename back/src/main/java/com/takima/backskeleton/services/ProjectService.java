package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.*;
import com.takima.backskeleton.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectDao projectDao;

    public List<Project> findAll() {
        return projectDao.findAll();
    }

    public Project findById(Long id) {
        return projectDao.findById(id).orElse(null);
    }

    public Project save(Project project) { //both used for creation and update of objects
        return projectDao.save(project);
    }

    public void deleteById(Long id) {
        projectDao.deleteById(id);
    }

    public List<Project> findByUser(Users user) {
        List<Project> projects = projectDao.findAll();
        List<Project> userProjects = new ArrayList<>();
        for (Project project : projects) {
            if (project.getUser().getId_users().equals(user.getId_users())) {
                userProjects.add(project);
            }
        }
        return userProjects;
    }

    public List<Task> getTasks(Project project) {
        List<Task> tasks = project.getTasks();
        return tasks;
    }
    public Task addTask(Project project, Task task) {
        List<Task> tasks = project.getTasks();
        tasks.add(task);
        project.setTasks(tasks);
        projectDao.save(project);
        return task;
    }




}

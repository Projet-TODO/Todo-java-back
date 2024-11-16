package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.*;
import com.takima.backskeleton.models.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
@RequiredArgsConstructor
public class TaskService {
    private final TaskDao taskDao;

    public List<Task> findAll() {
        return taskDao.findAll();
    }

    public Task findById(Long id) {
        return taskDao.findById(id).orElse(null);
    }

    public Task save(Task task) { // both used for creation and update of objects
        return taskDao.save(task);
    }

    public void deleteById(Long id) {
        taskDao.deleteById(id);
    }

    public List<Task> findByProject(Project project) {
        List<Task> tasks = taskDao.findAll();
        List<Task> projectTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getProject().getId_project().equals(project.getId_project())) {
                projectTasks.add(task);
            }
        }
        return projectTasks;
    }

    public Task update(Long id, Task task) {
        Task taskToUpdate = taskDao.findById(id).orElse(null);
        if (taskToUpdate == null) {
            return null;
        }
        taskToUpdate.setTitle_task(task.getTitle_task());
        taskToUpdate.setDescription_task(task.getDescription_task());
        taskToUpdate.setPriority_task(task.getPriority_task());
        taskToUpdate.setDeadline_task(task.getDeadline_task());
        taskToUpdate.setAchieved_task(task.isAchieved_task());
        taskToUpdate.setProject(task.getProject());
        return taskDao.save(taskToUpdate);
    }
}

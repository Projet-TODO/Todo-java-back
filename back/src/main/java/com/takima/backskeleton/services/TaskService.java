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
}
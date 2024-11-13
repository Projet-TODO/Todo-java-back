package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.*;
import com.takima.backskeleton.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("project")
@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("{id}")
    public Project findById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping("")
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        projectService.deleteById(id);
    }

    @GetMapping("user/{id}")
    public List<Project> findByUser(@PathVariable Long id) {
        Users user = new Users();
        user.setId_users(id);
        return projectService.findByUser(user);
    }

    @GetMapping("{id}/tasks")
    public List<Task> getTasks(@PathVariable Long id) {
        Project project = projectService.findById(id);
        return projectService.getTasks(project);
    }

    @PostMapping("{id}/tasks")
    public Task addTask(@PathVariable Long id, @RequestBody Task task) {
        Project project = projectService.findById(id);
        return projectService.addTask(project, task);
    }

}

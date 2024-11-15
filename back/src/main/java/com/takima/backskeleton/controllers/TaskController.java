package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.*;
import com.takima.backskeleton.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RequestMapping("tasks")
@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping("")
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

}

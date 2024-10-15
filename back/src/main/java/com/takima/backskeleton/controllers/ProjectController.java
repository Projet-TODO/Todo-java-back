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


}

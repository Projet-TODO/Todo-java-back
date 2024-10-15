package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.*;
import com.takima.backskeleton.services.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping("")
    public List<Users> findAll() {
        return usersService.findAll();
    }

}
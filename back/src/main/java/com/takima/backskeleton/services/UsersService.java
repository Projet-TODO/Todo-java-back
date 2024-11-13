package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.*;
import com.takima.backskeleton.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersDao usersDao;

    public List<Users> findAll() {
        return usersDao.findAll();
    }

    public Users findById(Long id) {
        return usersDao.findById(id).orElse(null);
    }
    public Users create(Users user) {
        return usersDao.save(user);
    }

}

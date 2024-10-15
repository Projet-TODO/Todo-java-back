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


}

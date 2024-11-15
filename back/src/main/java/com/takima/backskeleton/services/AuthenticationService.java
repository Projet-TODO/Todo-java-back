package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.UsersDao;
import com.takima.backskeleton.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UsersDao userRepository;

public Users authenticate(String email, String password) {
    Optional<Users> user = userRepository.findByEmail(email);
    if (user.isPresent() && user.get().getPassword_users().equals(password)) {
        return user.get();
    }
    return null;
}
}

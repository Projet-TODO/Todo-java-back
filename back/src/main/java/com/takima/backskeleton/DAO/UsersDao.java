package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email_users);
}

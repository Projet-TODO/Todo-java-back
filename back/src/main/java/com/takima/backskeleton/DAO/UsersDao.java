package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {
}
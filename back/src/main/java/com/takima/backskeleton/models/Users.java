package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_users;

    private String last_name_users;
    private String first_name_users;
    private String email_users;
    private String password_users;

    @OneToMany(mappedBy = "user")
    private List<Project> projects;

}
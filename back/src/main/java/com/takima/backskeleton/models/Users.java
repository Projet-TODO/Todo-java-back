package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_users;

    private String last_name_users;
    private String first_name_users;
    @Column(name = "email_users")
    private String email;
    private String password_users;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Project> projects;
@Override
public String toString() {
    return "Users{" +
            "id_users=" + id_users +
            ", last_name_users='" + last_name_users + '\'' +
            ", first_name_users='" + first_name_users + '\'' +
            ", email_users='" + email + '\'' +
            ", password_users='" + password_users + '\'' +
            ", projects=" + projects +
            '}';
}
}

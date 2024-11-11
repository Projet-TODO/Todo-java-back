package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Entity
@Table(name = "task")
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_task;
    private String title_task;
    private String description_task;
    private int priority_task;
    private Date deadline_task;
    private boolean achieved_task;

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    private Project project;

}


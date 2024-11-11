package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "project")
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_project;
    private String name_project;
    private Date date_project;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "id_users")
    @JsonBackReference
    private Users user;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Project createFromJson(String jsonString) {
        Project project = new Project();
        jsonString = jsonString.replace("{", "").replace("}", "").replace("\"", "");
        String[] keyValuePairs = jsonString.split(",");
        for (String pair : keyValuePairs) {
            int separatorIndex = pair.indexOf(":");
            String key = pair.substring(0, separatorIndex).trim();
            String value = pair.substring(separatorIndex + 1).trim();

            switch (key) {
                case "id_project":
                    project.setId_project(Long.parseLong(value));
                    break;
                case "name_project":
                    project.setName_project(value);
                    break;
                case "date_project":
                    System.out.println("date_project value: " + value);
                    try {
                        // Append missing time if necessary
                        if (value.length() == 10) {  // e.g., "2024-11-09"
                            value += "T00:00:00.000Z";
                        } else if (value.length() == 13) { // e.g., "2024-11-09 21"
                            value = value.replace(" ", "T") + ":00:00.000Z";
                        }
                        project.setDate_project(dateFormat.parse(value));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                // Handle other fields here
            }
        }
        return project;}
}

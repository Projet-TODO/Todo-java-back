package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.CourseDao;
import com.takima.backskeleton.models.Course;
import com.takima.backskeleton.models.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectDao projectDao;

    public List<Project> findAll() {
        return projectDao.findAll();
    }

    public Project findById(Long id) {
        return projectDao.findById(id).orElse(null);
    }

    public Project save(Project project) { //both used for creation and update of objects
        return projectDao.save(project);
    }

    public void deleteById(Long id) {
        projectDao.deleteById(id);
    }


}

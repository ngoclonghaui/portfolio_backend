package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Profile;
import com.example.nglongapi.Model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProject {
    public List<Project> getAllProject();
    public Project updateProject(Project project);
    public Project deleteProject(int id);
    public Project addNewProject(Project project);
}

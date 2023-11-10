package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Project;
import com.example.nglongapi.Repository.ProfileRepository;
import com.example.nglongapi.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServices implements IProject {
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Project project) {
        Optional<Project> project1 = projectRepository.findById(project.getId());
        if(project1.isEmpty()){
            return null;
        }
        Project pj = project1.get();
        pj.setId(project.getId());
        pj.setNgayBatDau(project.getNgayBatDau());
        pj.setNgayKetThuc(project.getNgayKetThuc());
        pj.setTenDuAn(project.getTenDuAn());
        projectRepository.save(pj);
        return pj;
    }

    @Override
    public Project deleteProject(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isEmpty()){
            return null;
        }
        projectRepository.delete(project.get());
        return project.get();
    }

    @Override
    public Project addNewProject(Project project) {
//        Optional<Project> project1 = projectRepository.findById(project.getId());
//        if(project1.isEmpty()){
//            return null;
//        }
        projectRepository.save(project);
        return project;
    }
}

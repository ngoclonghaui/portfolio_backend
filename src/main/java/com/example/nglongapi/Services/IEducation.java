package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Education;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEducation {
    public List<Education> getAllEducation();
    public Education updateEducation(Education education);
    public Education deleteEducation(int id);
    public Education addNewEducation(Education education);
}

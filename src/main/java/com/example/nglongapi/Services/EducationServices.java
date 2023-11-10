package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Education;
import com.example.nglongapi.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServices implements IEducation{
    @Autowired
    EducationRepository educationRepository;
    @Override
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    @Override
    public Education updateEducation(Education education) {
        Optional<Education> education1 = educationRepository.findById(education.getId());
        if(education1.isEmpty()){
            return null;
        }
        Education edu = education1.get();
        edu.setId(education.getId());
        edu.setLoaiHocVan(education.getLoaiHocVan());
        edu.setTenHocVan(education.getTenHocVan());
        educationRepository.save(edu);
        return edu;
    }

    @Override
    public Education deleteEducation(int id) {
        Optional<Education> education = educationRepository.findById(id);
        if(education.isEmpty()){
            return null;
        }
        educationRepository.delete(education.get());
        return education.get();
    }

    @Override
    public Education addNewEducation(Education education) {
//        Optional<Education> education1 = educationRepository.findById(education.getId());
//        if(education1.isEmpty()){
//            return null;
//        }
        educationRepository.save(education);
        return education;
    }
}

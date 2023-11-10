package com.example.nglongapi.Controller;

import com.example.nglongapi.Model.Education;
import com.example.nglongapi.Services.EducationServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class EducationController {
    @Autowired
    EducationServices educationServices;
    Gson gson = new Gson();
    @GetMapping(value = "getalleducation")
    private List<Education> layThongTinEducation(){
        return educationServices.getAllEducation();
    }
    @PostMapping(value = "posteducation")
    private Education updateEducation(@RequestBody String education){

        Education edu = gson.fromJson(education,Education.class);
        return educationServices.updateEducation(edu);
    }
    @PostMapping(value="addneweducation")
    private Education themMotHocVan(@RequestBody String education){
        return educationServices.addNewEducation(gson.fromJson(education,Education.class));
    }
}

package com.example.nglongapi.Controller;

import com.example.nglongapi.Model.Skill;
import com.example.nglongapi.Services.SkillServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(allowedHeaders = "*")
@RestController
public class SkillController {
    @Autowired
    SkillServices skillServices;
    Gson gson = new Gson();
    @GetMapping(value = "getallskill")
    private List<Skill> layTatCaSkill(){
        return skillServices.getAllSkill();
    }
    @PutMapping(value = "postskill")
    private Skill updateSkill(@RequestBody String skill){

        return skillServices.updateSkill(gson.fromJson(skill,Skill.class));
    }
    @PostMapping(value="addnewskill")
    private Skill themMotKyNang(@RequestBody String skill){
        return skillServices.addNewSkill(gson.fromJson(skill,Skill.class));
    }
    @CrossOrigin(allowedHeaders = "*")
    @DeleteMapping(value = "deleteskill/{id}")
    private Skill xoaKyNang(@PathVariable int id){
        return skillServices.deleteSkill(id);
    }
}

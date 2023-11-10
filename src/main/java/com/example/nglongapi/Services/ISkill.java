package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISkill {
    public List<Skill> getAllSkill();
    public Skill updateSkill(Skill skill);
    public Skill deleteSkill(int id);
    public Skill addNewSkill(Skill skill);
}

package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Skill;
import com.example.nglongapi.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServices implements ISkill {
    @Autowired
    SkillRepository skillRepository;
    @Override
    public List<Skill> getAllSkill() {
        return skillRepository.findAll();
    }

    @Override
    public Skill updateSkill(Skill skill) {
        Optional<Skill> skill1 = skillRepository.findById(skill.getId());
        if(skill1.isEmpty()){
            return null;
        }
        Skill sk = skill1.get();
        sk.setId(skill.getId());
        sk.setTenKyNang(skill.getTenKyNang());
        sk.setNangLuc(skill.getNangLuc());
        skillRepository.save(sk);
        return sk;
    }

    @Override
    public Skill deleteSkill(int id) {
        Optional<Skill> skill = skillRepository.findById(id);
        if(skill.isEmpty()){
            return null;
        }
        skillRepository.delete(skill.get());
        return skill.get();
    }

    @Override
    public Skill addNewSkill(Skill skill) {
        skillRepository.save(skill);
        return skill;
    }
}

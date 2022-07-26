package com.argprograma.elsportfolio.service;

import com.argprograma.elsportfolio.model.Skills;
import com.argprograma.elsportfolio.repository.SkillsRepository;
import com.argprograma.elsportfolio.servinterface.InterfSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService implements InterfSkillsService {

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public List<Skills> getSkills() {

        List<Skills> listaSkills = skillsRepository.findAll();
        return listaSkills;
    }

    @Override
    public void saveSkill(Skills skill) {

        skillsRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id_skills) {

        skillsRepository.deleteById(id_skills);
    }

    @Override
    public Skills findSkill(Long id_skills) {

        Skills skill = skillsRepository.findById(id_skills).orElse(null);
        return skill;
    }
}

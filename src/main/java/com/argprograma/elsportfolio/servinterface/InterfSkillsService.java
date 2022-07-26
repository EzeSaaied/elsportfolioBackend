package com.argprograma.elsportfolio.servinterface;

import com.argprograma.elsportfolio.model.Skills;

import java.util.List;

public interface InterfSkillsService {

    List<Skills> getSkills();
    void saveSkill (Skills skill);
    void deleteSkill (Long id_skills);
    Skills findSkill (Long id_skills);
}

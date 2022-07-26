package com.argprograma.elsportfolio.controller;

import com.argprograma.elsportfolio.model.Skills;
import com.argprograma.elsportfolio.servinterface.InterfSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillsController {

    @Autowired
    private InterfSkillsService interfSkillsService;

    @GetMapping ("/skills/traer")
    public List<Skills> getSkills() {

        return interfSkillsService.getSkills();
    }

    @PostMapping ("/skills/crear")
    public String createSkills (@RequestBody Skills skill) {

        interfSkillsService.saveSkill(skill);
        return "El skill fue creado correctamente";
    }

    @DeleteMapping ("/skills/borrar/{id_skills}")
    public String deleteSkills (@PathVariable Long id_skills) {

        interfSkillsService.deleteSkill(id_skills);
        return "El skill fue eliminado correctamente";
    }

    @PutMapping ("skills/editar/{id_skills}")
    public Skills editSkills (@PathVariable Long id_skills,
                                 @RequestParam ("skill") String nuevoSkill,
                                 @RequestParam ("tipo") String nuevoTipo,
                                 @RequestParam ("maestria") int nuevaMaestria,
                                 @RequestParam ("logo") String nuevoLogo) {

        Skills skill = interfSkillsService.findSkill(id_skills);

        skill.setSkill(nuevoSkill);
        skill.setTipo(nuevoTipo);
        skill.setMaestria(nuevaMaestria);
        skill.setLogo(nuevoLogo);

        interfSkillsService.saveSkill(skill);

        return skill;
    }
}

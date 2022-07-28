package com.argprograma.elsportfolio.controller;

import com.argprograma.elsportfolio.model.*;
import com.argprograma.elsportfolio.servinterface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/traer")
public class PublicController {

    @Autowired
    private InterfEstudiosService interfEstudiosService;

    @Autowired
    private InterfExperienciaService interfExperienciaService;

    @Autowired
    private InterfInicioService interfInicioService;

    @Autowired
    private InterfProyectosService interfProyectosService;

    @Autowired
    private InterfSkillsService interfSkillsService;

    @GetMapping("/estudios")
    public List<Estudios> getEstudios() {

        return interfEstudiosService.getEstudios();
    }

    @GetMapping ("/experiencia")
    public List<Experiencia> getExperiencia() {

        return interfExperienciaService.getExperiencias();
    }

    @GetMapping ("/inicio")
    public List<Inicio> getInicio() {

        return interfInicioService.getInicios();
    }

    @GetMapping ("/proyectos")
    public List<Proyectos> getProyectos() {

        return interfProyectosService.getProyectos();
    }

    @GetMapping ("/skills")
    public List<Skills> getSkills() {

        return interfSkillsService.getSkills();
    }
}

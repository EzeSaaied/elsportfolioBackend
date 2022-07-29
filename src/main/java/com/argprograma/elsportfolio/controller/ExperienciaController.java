package com.argprograma.elsportfolio.controller;

import com.argprograma.elsportfolio.model.Experiencia;
import com.argprograma.elsportfolio.servinterface.InterfExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaController {

    @Autowired
    private InterfExperienciaService interfExperienciaService;

    @PostMapping ("/crear")
    public String createExperiencia (@RequestBody Experiencia exp) {

        interfExperienciaService.saveExperiencia(exp);
        return "{\"response\":\"La experiencia fue creada correctamente\"}";
    }

    @DeleteMapping ("/borrar/{id_experiencia}")
    public String deleteExperiencia (@PathVariable Long id_experiencia) {

        interfExperienciaService.deleteExperiencia(id_experiencia);
        return "{\"response\":\"La experiencia fue borrada correctamente\"}";
    }

    @PutMapping ("/editar/{id_experiencia}")
    public Experiencia editExperiencia (@PathVariable Long id_experiencia,
                                 @RequestParam ("cargo") String nuevoCargo,
                                 @RequestParam ("empresa") String nuevaEmpresa,
                                 @RequestParam ("logo") String nuevoLogo,
                                 @RequestParam ("aInicio") int nuevoAInicio,
                                 @RequestParam ("aFinal") int nuevoAFinal,
                                 @RequestParam ("descripcion") String nuevaDescripcion) {

        Experiencia exp = interfExperienciaService.findExperiencia(id_experiencia);

        exp.setCargo(nuevoCargo);
        exp.setEmpresa(nuevaEmpresa);
        exp.setLogo(nuevoLogo);
        exp.setAInicio(nuevoAInicio);
        exp.setAFinal(nuevoAFinal);
        exp.setDescripcion(nuevaDescripcion);

        interfExperienciaService.saveExperiencia(exp);

        return exp;
    }
}
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

    @GetMapping ("/traer")
    public List<Experiencia> getExperiencia() {

        return interfExperienciaService.getExperiencias();
    }

    @PostMapping ("/crear")
    public String createExperiencia (@RequestBody Experiencia exp) {

        interfExperienciaService.saveExperiencia(exp);
        return "La experiencia fue creada correctamente";
    }

    @DeleteMapping ("/borrar/{id_experiencia}")
    public String deleteExperiencia (@PathVariable Long id_experiencia) {

        interfExperienciaService.deleteExperiencia(id_experiencia);
        return "La experiencia fue eliminada correctamente";
    }

    @PutMapping ("/editar/{id_experiencia}")
    public Experiencia editExperiencia (@PathVariable Long id_experiencia,
                                 @RequestParam ("cargo") String nuevoCargo,
                                 @RequestParam ("empresa") String nuevaEmpresa,
                                 @RequestParam ("logo") String nuevoLogo,
                                 @RequestParam ("año_inicio") int nuevoAñoInicio,
                                 @RequestParam ("año_final") int nuevoAñoFinal,
                                 @RequestParam ("descripcion") String nuevaDescripcion) {

        Experiencia exp = interfExperienciaService.findExperiencia(id_experiencia);

        exp.setCargo(nuevoCargo);
        exp.setEmpresa(nuevaEmpresa);
        exp.setLogo(nuevoLogo);
        exp.setAño_inicio(nuevoAñoInicio);
        exp.setAño_final(nuevoAñoFinal);
        exp.setDescripcion(nuevaDescripcion);

        interfExperienciaService.saveExperiencia(exp);

        return exp;
    }
}
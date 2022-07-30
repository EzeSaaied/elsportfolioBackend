package com.argprograma.elsportfolio.controller;

import com.argprograma.elsportfolio.model.Proyectos;
import com.argprograma.elsportfolio.servinterface.InterfProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectosController {

    @Autowired
    private InterfProyectosService interfProyectosService;

    @PostMapping ("/crear")
    public String createProyecto (@RequestBody Proyectos proy) {

        interfProyectosService.saveProyecto(proy);
        return "{\"response\":\"El proyecto fue creado correctamente\"}";
    }

    @DeleteMapping ("/borrar/{id_proyectos}")
    public String deleteProyectos (@PathVariable Long id_proyectos) {

        interfProyectosService.deleteProyecto(id_proyectos);
        return "{\"response\":\"El proyecto fue borrado correctamente\"}";
    }

    @PutMapping ("/editar/{id_proyectos}")
    public Proyectos editProyectos (@PathVariable Long id_proyectos,
                                 @RequestParam ("nombre") String nuevoNombre,
                                 @RequestParam ("descripcion") String nuevaDescripcion,
                                 @RequestParam ("a_inicio") int nuevoA_inicio,
                                 @RequestParam ("a_final") int nuevoA_final,
                                 @RequestParam ("url") String nuevoUrl) {

        Proyectos proy = interfProyectosService.findProyecto(id_proyectos);

        proy.setNombre(nuevoNombre);
        proy.setDescripcion(nuevaDescripcion);
        proy.setA_inicio(nuevoA_inicio);
        proy.setA_final(nuevoA_final);
        proy.setUrl(nuevoUrl);

        interfProyectosService.saveProyecto(proy);

        return proy;
    }
}

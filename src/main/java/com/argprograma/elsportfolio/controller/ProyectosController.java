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

    @GetMapping ("/traer")
    public List<Proyectos> getProyectos() {

        return interfProyectosService.getProyectos();
    }

    @PostMapping ("/crear")
    public String createProyecto (@RequestBody Proyectos proy) {

        interfProyectosService.saveProyecto(proy);
        return "El proyecto fue creado correctamente";
    }

    @DeleteMapping ("/borrar/{id_proyectos}")
    public String deleteProyectos (@PathVariable Long id_proyectos) {

        interfProyectosService.deleteProyecto(id_proyectos);
        return "El proyecto fue eliminado correctamente";
    }

    @PutMapping ("/editar/{id_proyectos}")
    public Proyectos editProyectos (@PathVariable Long id_proyectos,
                                 @RequestParam ("nombre") String nuevoNombre,
                                 @RequestParam ("descripcion") String nuevaDescripcion,
                                 @RequestParam ("año_inicio") int nuevoAñoInicio,
                                 @RequestParam ("año_final") int nuevoAñoFinal,
                                 @RequestParam ("url") String nuevoUrl) {

        Proyectos proy = interfProyectosService.findProyecto(id_proyectos);

        proy.setNombre(nuevoNombre);
        proy.setDescripcion(nuevaDescripcion);
        proy.setAño_inicio(nuevoAñoInicio);
        proy.setAño_final(nuevoAñoFinal);
        proy.setUrl(nuevoUrl);

        interfProyectosService.saveProyecto(proy);

        return proy;
    }
}

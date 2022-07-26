package com.argprograma.elsportfolio.controller;

import com.argprograma.elsportfolio.model.Inicio;
import com.argprograma.elsportfolio.servinterface.InterfInicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InicioController {

    @Autowired
    private InterfInicioService interfInicioService;

    @GetMapping ("/inicio/traer")
    public List<Inicio> getInicio() {

        return interfInicioService.getInicios();
    }

    @PostMapping ("/inicio/crear")
    public String createInicio (@RequestBody Inicio ini) {

        interfInicioService.saveInicio(ini);
        return "El inicio fue creado correctamente";
    }

    @DeleteMapping ("/inicio/borrar/{id_inicio}")
    public String deleteInicio (@PathVariable Long id_inicio) {

        interfInicioService.deleteInicio(id_inicio);
        return "El inicio fue eliminado correctamente";
    }

    @PutMapping ("inicio/editar/{id_inicio}")
    public Inicio editInicio (@PathVariable Long id_inicio,
                                 @RequestParam ("profilepic") String nuevoProfilepic,
                                 @RequestParam ("titulo") String nuevoTitulo,
                                 @RequestParam ("aboutme") String nuevoAboutme) {

        Inicio ini = interfInicioService.findInicio(id_inicio);

        ini.setProfilepic(nuevoProfilepic);
        ini.setTitulo(nuevoTitulo);
        ini.setAboutme(nuevoAboutme);

        interfInicioService.saveInicio(ini);

        return ini;
    }
}

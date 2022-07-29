package com.argprograma.elsportfolio.controller;

import com.argprograma.elsportfolio.model.Estudios;
import com.argprograma.elsportfolio.servinterface.InterfEstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudios")
public class EstudiosController {

    @Autowired
    private InterfEstudiosService interfEstudiosService;

    @PostMapping ("/crear")
    public String createEstudio (@RequestBody Estudios est) {

        interfEstudiosService.saveEstudio(est);
        return "{\"response\":\"El estudio fue creado correctamente\"}";
    }

    @DeleteMapping ("/borrar/{id_estudios}")
    public String deleteEstudio (@PathVariable Long id_estudios) {

        interfEstudiosService.deleteEstudio(id_estudios);
        return "{\"response\":\"El estudio fue borrado correctamente\"}";
    }

     @PutMapping ("/editar/{id_estudios}")
    public Estudios editEstudio (@PathVariable Long id_estudios,
                                 @RequestParam ("titulo") String nuevoTitulo,
                                 @RequestParam ("institucion") String nuevaInstitucion,
                                 @RequestParam ("logo") String nuevoLogo,
                                 @RequestParam ("aInicio") int nuevoAInicio,
                                 @RequestParam ("aFinal") int nuevoAFinal,
                                 @RequestParam ("descripcion") String nuevaDescripcion,
                                 @RequestParam ("certificado") String nuevoCertificado) {

        Estudios est = interfEstudiosService.findEstudio(id_estudios);

        est.setTitulo(nuevoTitulo);
        est.setInstitucion(nuevaInstitucion);
        est.setLogo(nuevoLogo);
        est.setAInicio(nuevoAInicio);
        est.setAFinal(nuevoAFinal);
        est.setDescripcion(nuevaDescripcion);
        est.setCertificado(nuevoCertificado);

        interfEstudiosService.saveEstudio(est);

        return est;
     }
}

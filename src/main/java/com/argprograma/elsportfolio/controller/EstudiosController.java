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

    @GetMapping ("/traer")
    public List<Estudios> getEstudios() {

        return interfEstudiosService.getEstudios();
    }

    @PostMapping ("/crear")
    public String createEstudio (@RequestBody Estudios est) {

        interfEstudiosService.saveEstudio(est);
        return "El estudio fue creado correctamente";
    }

    @DeleteMapping ("/borrar/{id_estudios}")
    public String deleteEstudio (@PathVariable Long id_estudios) {

        interfEstudiosService.deleteEstudio(id_estudios);
        return "El estudio fue eliminado correctamente";
    }

     @PutMapping ("/editar/{id_estudios}")
    public Estudios editEstudio (@PathVariable Long id_estudios,
                                 @RequestParam ("titulo") String nuevoTitulo,
                                 @RequestParam ("institucion") String nuevaInstitucion,
                                 @RequestParam ("logo") String nuevoLogo,
                                 @RequestParam ("año_inicio") int nuevoAñoInicio,
                                 @RequestParam ("año_final") int nuevoAñoFinal,
                                 @RequestParam ("descripcion") String nuevaDescripcion,
                                 @RequestParam ("certificado") String nuevoCertificado) {

        Estudios est = interfEstudiosService.findEstudio(id_estudios);

        est.setTitulo(nuevoTitulo);
        est.setInstitucion(nuevaInstitucion);
        est.setLogo(nuevoLogo);
        est.setAño_inicio(nuevoAñoInicio);
        est.setAño_final(nuevoAñoFinal);
        est.setDescripcion(nuevaDescripcion);
        est.setCertificado(nuevoCertificado);

        interfEstudiosService.saveEstudio(est);

        return est;
     }
}

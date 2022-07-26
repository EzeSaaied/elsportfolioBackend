package com.argprograma.elsportfolio.servinterface;

import com.argprograma.elsportfolio.model.Proyectos;

import java.util.List;

public interface InterfProyectosService {

    List<Proyectos> getProyectos();
    void saveProyecto (Proyectos proy);
    void deleteProyecto (Long id_proyecto);
    Proyectos findProyecto (Long id_proyecto);
}

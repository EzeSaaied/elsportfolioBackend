package com.argprograma.elsportfolio.servinterface;

import com.argprograma.elsportfolio.model.Experiencia;

import java.util.List;

public interface InterfExperienciaService {

    List<Experiencia> getExperiencias();
    void saveExperiencia (Experiencia exp);
    void deleteExperiencia (Long id_expriencia);
    Experiencia findExperiencia (Long id_experiencia);
}
package com.argprograma.elsportfolio.servinterface;

import com.argprograma.elsportfolio.model.Inicio;

import java.util.List;

public interface InterfInicioService {

    List<Inicio> getInicios();
    void saveInicio (Inicio ini);
    void deleteInicio (Long id_inicio);
    Inicio findInicio (Long id_inicio);
}
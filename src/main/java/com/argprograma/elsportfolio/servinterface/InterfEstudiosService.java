package com.argprograma.elsportfolio.servinterface;

import com.argprograma.elsportfolio.model.Estudios;

import java.util.List;

public interface InterfEstudiosService {

    List<Estudios> getEstudios();
    void saveEstudio (Estudios est);
    void deleteEstudio (Long id_estudios);
    Estudios findEstudio (Long id_estudios);
}

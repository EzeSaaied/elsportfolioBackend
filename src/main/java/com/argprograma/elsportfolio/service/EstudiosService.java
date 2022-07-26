package com.argprograma.elsportfolio.service;

import com.argprograma.elsportfolio.model.Estudios;
import com.argprograma.elsportfolio.repository.EstudiosRepository;
import com.argprograma.elsportfolio.servinterface.InterfEstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiosService implements InterfEstudiosService {

    @Autowired
    private EstudiosRepository estudiosRepository;

    @Override
    public List<Estudios> getEstudios() {

        List<Estudios> listaEst = estudiosRepository.findAll();
        return listaEst;
    }

    @Override
    public void saveEstudio(Estudios est) {

        estudiosRepository.save(est);
    }

    @Override
    public void deleteEstudio(Long id_estudios) {

        estudiosRepository.deleteById(id_estudios);
    }

    @Override
    public Estudios findEstudio(Long id_estudios) {

        Estudios est = estudiosRepository.findById(id_estudios).orElse(null);
        return est;
    }
}

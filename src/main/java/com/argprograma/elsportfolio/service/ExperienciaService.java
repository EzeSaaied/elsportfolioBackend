package com.argprograma.elsportfolio.service;

import com.argprograma.elsportfolio.model.Experiencia;
import com.argprograma.elsportfolio.repository.ExperienciaRepository;
import com.argprograma.elsportfolio.servinterface.InterfExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements InterfExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Override
    public List<Experiencia> getExperiencias() {

        List<Experiencia> listaExp = experienciaRepository.findAll();
        return listaExp;
    }

    @Override
    public void saveExperiencia(Experiencia exp) {

        experienciaRepository.save(exp);
    }

    @Override
    public void deleteExperiencia(Long id_experiencia) {

        experienciaRepository.deleteById(id_experiencia);
    }

    @Override
    public Experiencia findExperiencia(Long id_experiencia) {

        Experiencia exp = experienciaRepository.findById(id_experiencia).orElse(null);
        return exp;
    }
}

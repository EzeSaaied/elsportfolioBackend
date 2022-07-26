package com.argprograma.elsportfolio.service;

import com.argprograma.elsportfolio.model.Inicio;
import com.argprograma.elsportfolio.repository.InicioRepository;
import com.argprograma.elsportfolio.servinterface.InterfInicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InicioService implements InterfInicioService {

    @Autowired
    private InicioRepository inicioRepository;

    @Override
    public List<Inicio> getInicios() {

        List<Inicio> listaIni = inicioRepository.findAll();
        return listaIni;
    }

    @Override
    public void saveInicio(Inicio ini) {

        inicioRepository.save(ini);
    }

    @Override
    public void deleteInicio(Long id_inicio) {

        inicioRepository.deleteById(id_inicio);
    }

    @Override
    public Inicio findInicio(Long id_inicio) {

        Inicio ini = inicioRepository.findById(id_inicio).orElse(null);
        return ini;
    }
}

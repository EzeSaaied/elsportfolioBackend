package com.argprograma.elsportfolio.service;

import com.argprograma.elsportfolio.model.Proyectos;
import com.argprograma.elsportfolio.repository.ProyectosRepository;
import com.argprograma.elsportfolio.servinterface.InterfProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectosService implements InterfProyectosService {

    @Autowired
    private ProyectosRepository proyectosRepository;

    @Override
    public List<Proyectos> getProyectos() {

        List<Proyectos> listaProy = proyectosRepository.findAll();
        return listaProy;
    }

    @Override
    public void saveProyecto(Proyectos proy) {

        proyectosRepository.save(proy);
    }

    @Override
    public void deleteProyecto(Long id_proyecto) {

        proyectosRepository.deleteById(id_proyecto);
    }

    @Override
    public Proyectos findProyecto(Long id_proyecto) {

        Proyectos proy = proyectosRepository.findById(id_proyecto).orElse(null);
        return proy;
    }
}

package com.argprograma.elsportfolio.repository;

import com.argprograma.elsportfolio.model.Inicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InicioRepository extends JpaRepository<Inicio, Long> {
}

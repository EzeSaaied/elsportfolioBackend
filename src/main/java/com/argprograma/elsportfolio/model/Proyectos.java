package com.argprograma.elsportfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proyectos;
    @NonNull
    private String nombre;
    @NonNull
    @Lob
    private String descripcion;
    @NonNull
    private int a_inicio;
    @NonNull
    private int a_final;
    @NonNull
    private String url;
}

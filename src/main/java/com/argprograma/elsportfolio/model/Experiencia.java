package com.argprograma.elsportfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_experiencia;
    @NonNull
    private String cargo;
    @NonNull
    private String empresa;
    @Nullable
    private String logo;
    @NonNull
    private int a_inicio;
    @NonNull
    private int a_final;
    @NonNull
    @Lob
    private String descripcion;
}

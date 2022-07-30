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
public class Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudios;
    @NonNull
    private String titulo;
    @NonNull
    private String institucion;
    @Nullable
    private String logo;
    @NonNull
    private int a_inicio;
    @NonNull
    private int a_final;
    @NonNull
    @Lob
    private String descripcion;
    @Nullable
    private String certificado;
}

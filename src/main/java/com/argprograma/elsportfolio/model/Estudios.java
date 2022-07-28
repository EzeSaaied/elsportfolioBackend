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
    private int aInicio;
    @NonNull
    private int aFinal;
    @NonNull
    @Lob
    private String descripcion;
    @Nullable
    private String certificado;
}

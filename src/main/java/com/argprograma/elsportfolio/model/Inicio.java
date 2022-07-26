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
public class Inicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inicio;
    @NonNull
    private String profilepic;
    @NonNull
    private String titulo;
    @NonNull
    @Lob
    private String aboutme;
}

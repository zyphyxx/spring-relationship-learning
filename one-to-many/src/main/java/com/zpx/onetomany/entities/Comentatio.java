package com.zpx.onetomany.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comentarios")
@Getter
@Setter
public class Comentatio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String autor;

    private String texto;
}

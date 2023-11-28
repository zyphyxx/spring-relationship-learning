package com.zpx.onetomany.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "postagens")
@Getter
@Setter
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String titulo;

    private String texto;

    @OneToMany
    @JoinColumn(name = "codigo_postagem",referencedColumnName = "codigo")
    private List<Comentatio> comentatios; // criado no One mais essa coluna vai aparecer na tabela no db do many
}

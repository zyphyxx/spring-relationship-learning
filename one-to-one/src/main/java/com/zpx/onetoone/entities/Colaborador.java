package com.zpx.onetoone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "colaboradores")
@Getter
@Setter
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    @OneToOne
    @JoinColumn(name = "cargo", referencedColumnName = "codigo")
    private Cargo cargo;


}

package com.zpx.onetoone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cargos")
@Getter
@Setter
public class Cargo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String cargo;

    private double salario;

}

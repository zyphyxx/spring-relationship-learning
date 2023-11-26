package com.zpx.onetoone.controllers;

import com.zpx.onetoone.entities.Cargo;
import com.zpx.onetoone.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping("/listar")
    public Iterable<Cargo> findAllCargos () {
        return cargoRepository.findAll();
    }

    @PostMapping
    public Cargo createCargos (@RequestBody Cargo obj) {
        return cargoRepository.save(obj);
    }
}

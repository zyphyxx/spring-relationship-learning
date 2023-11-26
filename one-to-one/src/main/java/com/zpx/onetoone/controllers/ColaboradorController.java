package com.zpx.onetoone.controllers;

import com.zpx.onetoone.entities.Colaborador;
import com.zpx.onetoone.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @PostMapping
    public Colaborador createColaborador (@RequestBody Colaborador obj) {
        return colaboradorRepository.save(obj);
    }

    @GetMapping
    public List<Colaborador> findAll () {
        return colaboradorRepository.findAll();
    }
}

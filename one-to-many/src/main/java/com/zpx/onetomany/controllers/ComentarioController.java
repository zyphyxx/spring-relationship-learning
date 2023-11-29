package com.zpx.onetomany.controllers;

import com.zpx.onetomany.entities.Comentario;
import com.zpx.onetomany.repositories.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentariosRepository comentariosRepository;

    @GetMapping
    public List<Comentario> findAll () {
        return comentariosRepository.findAll();
    }

    @PostMapping
    public Comentario createComentario (@RequestBody Comentario obj) {
        return comentariosRepository.save(obj);
    }


}

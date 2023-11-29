package com.zpx.onetomany.controllers;

import com.zpx.onetomany.entities.Postagem;
import com.zpx.onetomany.repositories.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    public List<Postagem> findAll ()  {
        return postagemRepository.findAll();
    }

    @PostMapping
    public Postagem createPostagem (@RequestBody Postagem obj) {
        return postagemRepository.save(obj);
    }
}

package com.pruebatecnica.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.demo.model.Usuario;
import com.pruebatecnica.demo.repository.UsuarioRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/reactive")
public class ReactiveController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public Flux<Usuario> getAllUsuariosReactive() {
        return Flux.fromIterable(usuarioRepository.findAll());
    }
}

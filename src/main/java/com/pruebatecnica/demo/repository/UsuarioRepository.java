package com.pruebatecnica.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.pruebatecnica.demo.model.Usuario;

import reactor.core.publisher.Flux;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {
    Flux<Usuario> findAll();

	Object findByNickname(String username);
}

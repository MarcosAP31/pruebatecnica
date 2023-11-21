package com.pruebatecnica.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.demo.model.Usuario;
import com.pruebatecnica.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RedisService redisService;

    public Usuario obtenerUsuarioPorNickname(String nickname) {
        // Intentar obtener el usuario de Redis
        Usuario usuario = redisService.obtenerUsuarioDeRedis(nickname);

        // Si no está en Redis, buscar en la base de datos y almacenar en Redis
        if (usuario == null) {
            usuario = usuarioRepository.findByNickname(nickname).orElse(null);
            if (usuario != null) {
                redisService.guardarUsuarioEnRedis(usuario);
            }
        }

        return usuario;
    }
}

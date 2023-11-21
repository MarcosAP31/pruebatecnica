package com.pruebatecnica.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.pruebatecnica.demo.model.Usuario;

@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final HashOperations<String, String, Object> hashOperations;

    @Autowired
    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void guardarUsuarioEnRedis(Usuario usuario) {
        hashOperations.put("usuarios", usuario.getNickname(), usuario);
    }

    public Usuario obtenerUsuarioDeRedis(String nickname) {
        return (Usuario) hashOperations.get("usuarios", nickname);
    }
}

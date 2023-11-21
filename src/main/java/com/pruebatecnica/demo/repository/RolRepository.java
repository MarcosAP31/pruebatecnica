package com.pruebatecnica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.demo.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
}

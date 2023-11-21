package com.pruebatecnica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.demo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

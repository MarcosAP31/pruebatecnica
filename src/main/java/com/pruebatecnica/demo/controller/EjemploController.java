package com.pruebatecnica.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.demo.service.KafkaProducer;

@RestController
public class EjemploController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/enviar-mensaje")
    public String enviarMensaje() {
        kafkaProducer.enviarMensaje("Hola desde Kafka!");
        return "Mensaje enviado exitosamente.";
    }
}

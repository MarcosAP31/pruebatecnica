package com.pruebatecnica.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final String TOPIC = "nombre_del_topico"; // Reemplaza con el nombre deseado del tópico

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensaje(String mensaje) {
        kafkaTemplate.send(TOPIC, mensaje);
    }
}

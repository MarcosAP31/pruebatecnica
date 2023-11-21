package com.pruebatecnica.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final String TOPIC = "nombre_del_topico"; // Reemplaza con el nombre del tópico

    @KafkaListener(topics = TOPIC, groupId = "tu_grupo_id")
    public void recibirMensaje(String mensaje) {
        // Agrega el código para procesar el mensaje recibido
        System.out.println("Mensaje recibido: " + mensaje);
    }
}
package com.pruebatecnica.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pruebatecnica.demo.model.Rol;
import com.pruebatecnica.demo.model.Usuario;
import com.pruebatecnica.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventProcessor {

    @Autowired
    private UsuarioRepository usuarioRepository; // Asegúrate de tener el repositorio correcto
    @Autowired
    private S3Service s3Service;
    @KafkaListener(topics = "nombre_del_topico", groupId = "tu_grupo_id")
    public void procesarEvento(String evento) {
        // Operación lógica simple (en este caso, imprimir el evento)
        System.out.println("Evento recibido: " + evento);

        // Ejemplo de persistencia en la base de datos
        Usuario usuario = new Usuario();
        usuario.setNombre("Nombre Ejemplo");
        usuario.setApellido("Apellido Ejemplo");
        usuario.setEdad(30);
        usuario.setDocumentoIdentidad("123456789");
        usuario.setNickname("usuarioejemplo");
        usuario.setContraseña("contraseñaejemplo");
        usuario.setCorreo("usuario@example.com");

        // Simulación de un usuario admin que creó el registro
        Rol rolAdmin = new Rol();
        rolAdmin.setNombre("ROLE_ADMIN");

        Usuario admin = new Usuario();
        admin.setNickname("admin");
        admin.setRol(rolAdmin);

        usuario.setCreador(admin);

        // Guardar en la base de datos
        usuarioRepository.save(usuario);
        
     // Almacenar en S3
        s3Service.almacenarEventoEnS3(evento.getEventId(), evento.getEventType(), evento.getEventData());
    }
}

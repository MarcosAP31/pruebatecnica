package com.pruebatecnica.demo.model;
import com.pruebatecnica.demo.service.JwtUserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int edad;
    private String documentoIdentidad;
    private String nickname;
    private String contraseña;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Usuario creador;

    // Getters y Setters

    // Añadir una relación con JwtUserDetails
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private JwtUserDetails jwtUserDetails;

	public Object getRol() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNickname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContraseña() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNickname(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setRol(Rol rolAdmin) {
		// TODO Auto-generated method stub
		
	}

	public void setCreador(Usuario admin) {
		// TODO Auto-generated method stub
		
	}

	public void setCorreo(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setContraseña(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setDocumentoIdentidad(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setEdad(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setApellido(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setNombre(String string) {
		// TODO Auto-generated method stub
		
	}

}

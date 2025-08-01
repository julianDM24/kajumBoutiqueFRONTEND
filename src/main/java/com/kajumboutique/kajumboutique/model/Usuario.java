package com.kajumboutique.kajumboutique.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	private Long idUsuario;


    private String nombre;
    private String contrasena;
    private LocalDate fecha_creacion;
    private String rol;

    // Getters y Setters

   

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}



    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

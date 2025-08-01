package com.kajumboutique.kajumboutique.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class SalidaMercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_salida;

    private String codigo_prenda;
    private int cantidad_salida;
    private LocalDate fecha_salida;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
	
	
	public int getId_salida() {
		return id_salida;
	}
	public void setId_salida(int id_salida) {
		this.id_salida = id_salida;
	}
	public String getCodigo_prenda() {
		return codigo_prenda;
	}
	public void setCodigo_prenda(String codigo_prenda) {
		this.codigo_prenda = codigo_prenda;
	}
	public int getCantidad_salida() {
		return cantidad_salida;
	}
	public void setCantidad_salida(int cantidad_salida) {
		this.cantidad_salida = cantidad_salida;
	}
	public LocalDate getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(LocalDate fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	
	public Usuario getUsuario() {
	    return usuario;
	}

	public void setUsuario(Usuario usuario) {
	    this.usuario = usuario;
	}

	
	
}

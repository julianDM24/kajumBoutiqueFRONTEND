package com.kajumboutique.kajumboutique.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class EntradaMercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entrada;

    private String codigo_prenda;
    private int cantidad_entrada;
    private LocalDate fecha_entrada;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
	
	
	public int getId_entrada() {
		return id_entrada;
	}
	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
	}
	public String getCodigo_prenda() {
		return codigo_prenda;
	}
	public void setCodigo_prenda(String codigo_prenda) {
		this.codigo_prenda = codigo_prenda;
	}
	public int getCantidad_entrada() {
		return cantidad_entrada;
	}
	public void setCantidad_entrada(int cantidad_entrada) {
		this.cantidad_entrada = cantidad_entrada;
	}
	public LocalDate getFecha_entrada() {
		return fecha_entrada;
	}
	public void setFecha_entrada(LocalDate fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	
	public Usuario getUsuario() {
	    return usuario;
	}

	public void setUsuario(Usuario usuario) {
	    this.usuario = usuario;
	}
	

}

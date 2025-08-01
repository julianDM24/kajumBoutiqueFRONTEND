package com.kajumboutique.kajumboutique.model;

import jakarta.persistence.*;

@Entity
public class Prendas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prenda;
	
	private String codigo_prenda;
	private String nombre;
	private String descripcion;
	private int talla;
	private double precio_por_mayor;
	private double precio_publico;
	private int cantidad_disponible;
	
	
	
	public int getId_prenda() {
		return id_prenda;
	}
	public void setId_prenda(int id_prenda) {
		this.id_prenda = id_prenda;
	}
	public String getCodigo_prenda() {
		return codigo_prenda;
	}
	public void setCodigo_prenda(String codigo_prenda) {
		this.codigo_prenda = codigo_prenda;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getTalla() {
		return talla;
	}
	public void setTalla(int talla) {
		this.talla = talla;
	}
	public double getPrecio_por_mayor() {
		return precio_por_mayor;
	}
	public void setPrecio_por_mayor(double precio_por_mayor) {
		this.precio_por_mayor = precio_por_mayor;
	}
	public double getPrecio_publico() {
		return precio_publico;
	}
	public void setPrecio_publico(double precio_publico) {
		this.precio_publico = precio_publico;
	}
	public int getCantidad_disponible() {
		return cantidad_disponible;
	}
	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}
	
	

}

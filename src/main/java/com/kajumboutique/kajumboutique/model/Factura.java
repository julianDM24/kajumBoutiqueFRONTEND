package com.kajumboutique.kajumboutique.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.kajumboutique.kajumboutique.model.FormaPago;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_factura;
	
	
	private LocalDate fecha_emision;
	
	@Enumerated(EnumType.STRING)
	private FormaPago formaPago;
	
	@ManyToOne
	@JoinColumn(name = "id_venta")
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public LocalDate getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(LocalDate fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setForma_pago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}

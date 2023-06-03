package com.hotel_alura.modelo;


import java.util.Date;

public class Reserva {
	private Integer idreservas;
	private Date fechaEntrada;	
	private Date fechaSalida;
	private Double precio;
	private String formaPago,FechaEn,FechaSali;
	
	//Constructor
	public Reserva(int IdReservas,Date fechaEntrada, Date fechaSalida, Double precio, String formaPago) {
		super();
		
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.precio = precio;
		this.formaPago = formaPago;
	}

	

	public Reserva(Date fechaEnt, Date fechaSali, Double precio, String formaPago) {
		this.fechaEntrada = (Date) fechaEnt;
		this.fechaSalida = (Date) fechaSali;
		this.precio = precio;
		this.formaPago = formaPago;
	}



	public Reserva(String fecha, String fechaSali, Double valor, String formaPa) {
		this.FechaEn= fecha;
		this.FechaSali=fechaSali;
		this.precio= valor;
		this.formaPago=formaPa;
		
	}



	public Integer getIdreservas() {
		return idreservas;
	}

	public void setIdreservas(Integer idreservas) {
		this.idreservas = idreservas;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	@Override
	public String toString() {
		return String.format(
				"{ idreservas: %d, fechaEntrada: %s, fechaSalida: %s, precio: %s, formaPago: %s}",
				this.idreservas, this.fechaEntrada, this.fechaSalida, this.precio, this.formaPago);
	}	
	
	
}

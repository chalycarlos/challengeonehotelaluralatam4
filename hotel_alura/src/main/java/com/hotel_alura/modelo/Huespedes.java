package com.hotel_alura.modelo;

import java.sql.Date;

public class Huespedes {

	private Integer Id;
	private String Nombre;
	private String Apellido;
	private Date FechaNacimiento;
	private String Nacionalidad;
	private String Telefono;
	private Integer IdReservas;
		

	
	
	public Huespedes(int id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono, int idReservas) {
		super();
		Id = id;
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimiento = fechaNacimiento;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		IdReservas = idReservas;
	}

	

	public Huespedes(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono ) {
		super();
		this.Nombre=nombre;
		this.Apellido=apellido;
		this.FechaNacimiento=fechaNacimiento;
		this.Nacionalidad=nacionalidad;
		this.Telefono=telefono;
		
	}



	/*public Huespedes(int id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) {
		super();
		Id = id;
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimiento = fechaNacimiento;
		Nacionalidad = nacionalidad;
		Telefono = telefono;		
	}*/



	public Huespedes(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,
			Integer idReservas) {
		super();		
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimiento = fechaNacimiento;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		IdReservas = idReservas;
	}



	


	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		this.Id = id;
	}



	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public String getApellido() {
		return Apellido;
	}



	public void setApellido(String apellido) {
		Apellido = apellido;
	}



	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}



	public String getNacionalidad() {
		return Nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.Nacionalidad = nacionalidad;
	}



	public String getTelefono() {
		return Telefono;
	}



	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}



	public Integer getIdReservas() {
		return IdReservas;
	}



	public void setIdReservas(Integer idReservas) {
		this.IdReservas = idReservas;
	}



	@Override
	public String toString() {
		return "Huespedes [Id=" + Id + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", FechaNacimiento="
				+ FechaNacimiento + ", Nacionalidad=" + Nacionalidad + ", Telefono=" + Telefono + ", IdReserva="
				+ IdReservas + "]";
	}	



}

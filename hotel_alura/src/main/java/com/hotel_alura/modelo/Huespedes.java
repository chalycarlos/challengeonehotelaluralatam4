package com.hotel_alura.modelo;

import java.sql.Date;

public class Huespedes {
	
	private Integer Id;
	private String Nombre;
	private String Apellido;
	private Date FechaNacimiento;
	private String Nacionalidad;
	private String Telefono;
	private Integer IdReserva;	
	

	

	public Huespedes(String nombre, String apellido,  Date fechanacimiento, String nacionalidad, String telefono) {
			
		super();
		Nombre = nombre;
		Apellido = apellido;
		FechaNacimiento = fechanacimiento;
		Nacionalidad = nacionalidad;
		Telefono = telefono;
		
	}




	public Huespedes(int id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) {
		this.Id= id;
		this.Nombre= nombre;
		this.Apellido = apellido;
		this.FechaNacimiento= fechaNacimiento;
		this.Nacionalidad= nacionalidad;
		
	}




	public String getNombre() {
		return Nombre;
	}




	public String getApellido() {
		return Apellido;
	}




	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}




	public String getNacionalidad() {
		return Nacionalidad;
	}




	public String getTelefono() {
		return Telefono;
	}




	public Integer getIdReserva() {
		return IdReserva;
	}




	public Integer getId() {
		return Id;
	}




	public void setId(int id) {
		this.Id = id;
		
	}




	@Override
	public String toString() {
		return "Huespedes [Id=" + Id + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", FechaNacimiento="
				+ FechaNacimiento + ", Nacionalidad=" + Nacionalidad + ", Telefono=" + Telefono + ", IdReserva="
				+ IdReserva + "]";
	}	
	
		

}

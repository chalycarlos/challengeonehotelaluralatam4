package com.hotel_alura.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotel_alura.coneccion.ConeccionBD;

public class Usuarios {
	
	private String nombre;
	private String contraseña;
	
	public Usuarios(String nombre, String contraseña) {
		this.nombre= nombre;
		this.contraseña= contraseña;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public static boolean validarUsuario(String nombre, String contraseña) {
		ConeccionBD con= new ConeccionBD();
		Connection coneccion= null;
		PreparedStatement statement= null;
		ResultSet result= null;
		
		try {
			coneccion = con.recuperaConexion();
			statement = coneccion.prepareStatement("SELECT * FROM usuarios WHERE nombre=? AND contraseña=?");
			
			statement.setString(1, nombre);
			statement.setString(2, contraseña);
			result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if (result != null) 
					result.close();
				if (statement != null)
					statement.close();
				if (coneccion != null)
					coneccion.close();
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}

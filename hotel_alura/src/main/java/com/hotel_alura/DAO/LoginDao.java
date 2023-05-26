package com.hotel_alura.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel_alura.coneccion.ConeccionBD;
import com.hotel_alura.modelo.Usuarios;


public class LoginDao {
	private Connection con;
	
	public LoginDao(Connection con) {
		this.con = new ConeccionBD().recuperaConexion();
	}
	
	
	
	public List<Usuarios> getList(){
		List<Usuarios> logins= new ArrayList<>();
		String sql= "SELECT * FROM usuarios;";
		
		try {
			PreparedStatement statement= con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			 while (result.next()) {
	                Usuarios usuarios = new Usuarios();
	                usuarios.setId(result.getInt("id"));
	                usuarios.setNombre("nombre");
	                usuarios.setContraseña("contraseña");

	                logins.add(usuarios);
	            }
			 
			 statement.close();
			 result.close();
			 con.close();
			 
			 return logins;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en la Lista.");
			return null;
		}
	}

}

package com.hotel_alura.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.hotel_alura.coneccion.ConeccionBD;

public class ReservasController {
	
	public ReservasController() throws SQLException {
		Connection connection = new ConeccionBD().recuperaConexion();
		
	}

}

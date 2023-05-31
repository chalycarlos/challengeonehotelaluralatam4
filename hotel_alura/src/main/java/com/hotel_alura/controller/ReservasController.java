package com.hotel_alura.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.hotel_alura.DAO.HuespedesDAO;
import com.hotel_alura.DAO.ReservaDAO;
import com.hotel_alura.coneccion.ConeccionBD;
import com.hotel_alura.modelo.Reserva;

public class ReservasController {
	public ReservaDAO reservasDAO;
	
	public ReservasController()  {
		this.reservasDAO =  new ReservaDAO(new ConeccionBD().recuperaConexion());
	}	

	public void Agregar(Reserva reservas) {
		reservasDAO.Agregar(reservas);
		
	}

}

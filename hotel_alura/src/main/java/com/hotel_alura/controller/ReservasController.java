package com.hotel_alura.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

import com.hotel_alura.DAO.HuespedesDAO;
import com.hotel_alura.DAO.ReservaDAO;
import com.hotel_alura.coneccion.ConeccionBD;
import com.hotel_alura.modelo.Reserva;
import com.hotel_alura.views.ReservasView;

public class ReservasController {
	
	private ReservasView view;
	final private Connection con;
	public ReservaDAO reservaDAO;
	
	public ReservasController(ReservasView view, Connection con)  {
		this.reservaDAO= new ReservaDAO(new ConeccionBD().recuperaConexion(), view);
		this.con= con;
		this.view =view;
	}	

	
	public void Agregar(Reserva reserva) {
		
		reservaDAO.GuardarReservacion(reserva);
		//Reserva reserva= new Reserva(fechaEntrada, fechaSalida, precio, forPago);
		//boolean success= GuardarReservacion(reserva);
		
		/*if (success) {
			view.mostrarSuceso();
		}else {
			view.mostrarGuardarFalla();
		}*/
		
	}


	
}

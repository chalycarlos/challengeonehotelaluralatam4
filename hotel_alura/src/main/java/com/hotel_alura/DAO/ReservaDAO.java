package com.hotel_alura.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotel_alura.modelo.Reserva;
import com.hotel_alura.coneccion.ConeccionBD;


public class ReservaDAO {

	private Connection connection;

	//Constructor
	public ReservaDAO(Connection con) {		
		Connection connection = new ConeccionBD().recuperaConexion();
	}

	public void Agregar(Reserva reserva) {

		try {

			PreparedStatement statement;

			statement= connection.prepareStatement("INSERT INTO reservas " 
					+ "(fechaEntrada, fechaSalida, precior, formaPago)" + " VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			try(statement) {
				
				statement.setDate(1, reserva.getFechaEntrada());
				statement.setDate(2, reserva.getFechaSalida());
				statement.setDouble(3, reserva.getPrecio());
				statement.setString(4, reserva.getFormaPago());				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet){
					while (resultSet.next()) {
						reserva.setIdreservas(resultSet.getInt(1));						
					}					
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

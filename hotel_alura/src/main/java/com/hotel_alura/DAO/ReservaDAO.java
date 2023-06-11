package com.hotel_alura.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.hotel_alura.modelo.Reserva;
import com.hotel_alura.views.ReservasView;
import com.hotel_alura.coneccion.ConeccionBD;


public class ReservaDAO {
	
	private Connection con;
	private ReservasView view;
	

	//Constructor
	public ReservaDAO(Connection con,ReservasView view) {		
		this.con= con;	
		this.view= view;
		
	}	
	
	public void GuardarReservacion(Reserva reserva) {
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			PreparedStatement statement;

			statement= con.prepareStatement("INSERT INTO reservas"
					+ "(fechaEntrada, fechaSalida, precio, formaPago)"
					+ "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);		
					
			try(statement){		
				statement.setString(1, dateFormat.format(reserva.getFechaEntrada()));
				statement.setString(2,  dateFormat.format(reserva.getFechaSalida()));
				statement.setDouble(3, reserva.getPrecio());
				statement.setString(4, reserva.getFormaPago());	
				
				statement.execute();
				 
				final ResultSet resultSet = statement.getGeneratedKeys();

				try(resultSet) {
						while (resultSet.next()) {
							reserva.setIdreservas(resultSet.getInt(1));
							
							//System.out.println(String.format("Fue insertado el producto %s", reserva));
							mostrarSuceso();
						}
				}
				
			}	
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		

	}
	
	public void mostrarSuceso() {
		JOptionPane.showMessageDialog(null, "Reserva guardada exitosamente");

	}
	
	public List<Reserva> listar(){
		List<Reserva> lista= new ArrayList<>();
		Reserva reserva = null;
		
		try {
			final PreparedStatement statement= con
					.prepareStatement("SELECT idreservas,fechaEntrada, fechaSalida, precio,formaPago FROM RESERVAS");
			try(statement) {
				statement.execute();
				final ResultSet resultSet= statement.getResultSet();
				
				try (resultSet){
					
					while (resultSet.next()){
						int id= resultSet.getInt("idreservas");
						Date fechaEntrada= resultSet.getDate("fechaEntrada");
						Date fechaSalida= resultSet.getDate("fechaSalida");
						Double precio= resultSet.getDouble("precio");
						String formaPago= resultSet.getString("formaPago");
						
						reserva= new Reserva(id,fechaEntrada,fechaSalida,precio,formaPago);
						lista.add(reserva);
						
					}
					
				}
			}		
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}


}

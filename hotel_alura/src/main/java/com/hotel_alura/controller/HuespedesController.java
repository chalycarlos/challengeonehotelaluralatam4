package com.hotel_alura.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hotel_alura.coneccion.ConeccionBD;
import com.hotel_alura.modelo.Huespedes;
import com.hotel_alura.modelo.Reserva;
import com.hotel_alura.DAO.*;

public class HuespedesController {
	
	public HuespedesDAO huespedesDAO;
	
	
	public HuespedesController() {
		this.huespedesDAO =  new HuespedesDAO(new ConeccionBD().recuperaConexion()); 
	}

	public List<Huespedes> listar()  {
		
		return huespedesDAO.listar();			
	}
	
	

	public void Agregar(Huespedes huesped, Integer IdReservas) {		
		huesped.setIdReservas(IdReservas);
		huespedesDAO.Agregar(huesped); 
	}

	
	public int eliminar(Integer id) {
        return huespedesDAO.eliminar(id);
    }
	

	public int modificar(String nombre, String apellido, Date fechaNac, String nacionalidad, String telefono,Integer id) {
			
		return huespedesDAO.modificar(nombre,apellido,fechaNac,nacionalidad,telefono,id);
    }

	

}

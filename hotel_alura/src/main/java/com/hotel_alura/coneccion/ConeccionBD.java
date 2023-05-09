package com.hotel_alura.coneccion;

import java.sql.Connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConeccionBD {
	
	private DataSource dataSource;
	
	public ConeccionBD() {
		var comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("wi79364775li");
		comboPooledDataSource.setMaxPoolSize(10);
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection recuperaConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}

}

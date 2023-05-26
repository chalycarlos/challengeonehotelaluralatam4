package com.hotel_alura.controller;

import java.awt.Button;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.hotel_alura.modelo.Usuarios;
import com.hotel_alura.views.Login;
import com.hotel_alura.views.ReservasView;
import com.hotel_alura.DAO.LoginDao;
import com.hotel_alura.coneccion.ConeccionBD;

public class UsuariosController  {

	
	private Login vista;
	public LoginDao loginDao;
	private Connection con;
	private Login login;

	public UsuariosController() {			
		
		this.loginDao = new LoginDao(new ConeccionBD().recuperaConexion());
		this.con = new ConeccionBD().recuperaConexion();
		
		
	}

	public void Loguear(String nombre, String contraseña) {

		Usuarios user= new Usuarios(nombre,contraseña);
		
		if (LoguearUsuario(user)) {	
			
			ReservasView reserva= new ReservasView();			
			reserva.setVisible(true);			
			
			
		}else {
			
			JOptionPane.showMessageDialog(login,"Error, Inicio de sesion fallido.");
			Login limpiar= new Login();
			limpiar.LimpiarFormulario();
		}
				
	}	
	

	public boolean LoguearUsuario(Usuarios user) {
		
		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT nombre, contraseña FROM usuarios WHERE nombre = ? AND contraseña = ?");
			
				statement.setString(1, user.getNombre());
				statement.setString(2, user.getContraseña());				
				
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					
					return true;
				}
			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		return false;
		
		
		
	

	/*@Override
	public void actionPerformed(ActionEvent e) {

		String nombre = vista.getNombre();
		String contraseña = vista.getContraseña();

		if (Usuarios.validarUsuario(nombre, contraseña)) {
			MenuUsuario menu = new MenuUsuario();
			menu.setVisible(true);
			vista.dispose();
		}else {
			JOptionPane.showConfirmDialog(vista, "Usuario o Contraseña no validos.");
		}
	}*/

}}


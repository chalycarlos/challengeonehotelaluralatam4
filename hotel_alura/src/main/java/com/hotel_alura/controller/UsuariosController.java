package com.hotel_alura.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.hotel_alura.modelo.Usuarios;
import com.hotel_alura.views.Login;
import com.hotel_alura.views.MenuUsuario;

public class UsuariosController implements ActionListener {
	
	private Login vista;
	
	public UsuariosController(Login vista) {
		this.vista = vista;
	}
	
	@Override
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
	}
}

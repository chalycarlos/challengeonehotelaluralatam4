package com.hotel_alura.views;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Login extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel userLabel;
	private JLabel passwordLabel;
	private JTextField userText;
	private JPasswordField passwordText;
	private JButton loginButton;
	
	public Login() {
		super("Inicio de sesión");

		// Configurar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setLayout(new GridLayout(3, 2));

		// Crear componentes
		userLabel = new JLabel("Usuario:");
		passwordLabel = new JLabel("Contraseña:");
		userText = new JTextField();
		passwordText = new JPasswordField();
		loginButton = new JButton("Iniciar sesión");

		// Agregar componentes a la ventana
		add(userLabel);
		add(userText);
		add(passwordLabel);
		add(passwordText);
		add(new JLabel());
		add(loginButton);

		// Agregar ActionListener al botón de inicio de sesión
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = userText.getText();
				String contrasena = new String(passwordText.getPassword());

				if (usuario.equals("usuario") && contrasena.equals("contraseña")) {
					JOptionPane.showMessageDialog(Login.this, "Bienvenido, " + usuario + "!");
					dispose(); // Cierra la ventana de inicio de sesión
				} else {
					JOptionPane.showMessageDialog(Login.this, "Nombre de usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Mostrar la ventana
		setVisible(true);

	}

}

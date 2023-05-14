package com.hotel_alura.views;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Login extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel userLabel;
	private JLabel passwordLabel;
	private JLabel TituloLabel;
	private JTextField userText;
	private JPasswordField passwordText;
	private JButton loginButton;
	private JPanel panel;
	
	public Login() {
		super("Inicio de sesión");

		// Configurar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450, 357);
		setResizable(false);
		Container container = getContentPane();
		getContentPane().setLayout(null);
		
		
		

		// Crear componentes
		//LABELS
		TituloLabel = new JLabel("INICIAR SESION");
		TituloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TituloLabel.setForeground(new Color(100, 149, 237));
		TituloLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		TituloLabel.setBounds(10, 11, 152, 26);
		container.add(TituloLabel);
		
		userLabel = new JLabel("Usuario:");
		userLabel.setBounds(10, 54, 136, 36);
		userLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		passwordLabel = new JLabel("Contraseña:");
		passwordLabel.setBounds(10, 154, 222, 36);
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//TEXT
		userText = new JTextField();
		userText.setBounds(9, 101, 234, 42);
		loginButton = new JButton("INICIAR");
		loginButton.setBounds(10, 271, 100, 36);

		// Agregar componentes a la ventana
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userText);
		container.add(loginButton);
		
		panel= new JPanel();
		panel.setBounds(253, 0, 181, 318);
		panel.setBackground(new Color(135, 206, 235));
		container.add(panel);
		panel.setLayout(null);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(10, 201, 233, 36);
		container.add(passwordText);
		
		

		// Agregar ActionListener al botón de inicio de sesión(INICIAR)
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

	public String getNombre() {
		return userText.getText();
		
	}

	public String getContraseña() {
		// TODO Auto-generated method stub
		return new String(passwordText.getPassword());
	}	

	
		
}

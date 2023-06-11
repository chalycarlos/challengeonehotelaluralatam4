package com.hotel_alura.views;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import com.hotel_alura.controller.UsuariosController;
import com.hotel_alura.modelo.Usuarios;


public class Login extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel userLabel;
	private JLabel passwordLabel;
	private JLabel TituloLabel;
	private JTextField userText;
	private JPasswordField passwordText;
	private JButton loginButton;
	private JPanel panel;
	private UsuariosController controller;
	
	JFrame loginFrame = new JFrame();
	
	public Login() {
		super("Inicio de sesión");
		
		this.controller= new UsuariosController();
		// Configurar la ventana
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,450, 357);
		setResizable(false);
		Container container = getContentPane();
		getContentPane().setLayout(null);


		configurarCamposDelFormulario(container);
		configurarAccionesLogin();	
				

	}	

	private void configurarAccionesLogin() {
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Loguear();
			}
		});
	}

	private void configurarCamposDelFormulario(Container container) {
		// Crear componentes
		//LABELS
		TituloLabel = new JLabel("INICIAR SESION");
		TituloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TituloLabel.setForeground(new Color(100, 149, 237));
		TituloLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		TituloLabel.setBounds(10, 11, 152, 26);


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
		container.add(TituloLabel);
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
		
		// Mostrar la ventana
		setVisible(true);
		
	
	// Agregar evento al botón de inicio de sesión
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = userText.getText();
            String contraseña = new String(passwordText.getPassword());

            controller.Loguear(nombre, contraseña);
        }
    });
}	

	
	public void LimpiarFormulario() {
		this.userText.setText("");
		this.passwordText.setText("");
	}
	
	public void cerrarVentana() {
		loginFrame.dispose();
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContraseña() {
		// TODO Auto-generated method stub
		return null;
	}

	public void showAutenticarFalla() {
		JOptionPane.showConfirmDialog(this,"choose one", "Inicio de sesión fallido",JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void showAuthenticationSuccess() {
		JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
		
	}


}

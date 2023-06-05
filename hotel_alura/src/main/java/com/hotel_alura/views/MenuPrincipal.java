package com.hotel_alura.views;

import java.awt.Color;
import java.awt.Container;



import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuPrincipal extends JFrame{	
	private JPanel contentPane;
	
	
	
	public MenuPrincipal() {
		super("Menu Principal");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,600, 429);
		setResizable(false);
		Container container = getContentPane();
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(319, 0, 265, 390);
		container.add(panel);
		
		JLabel lblTitle = new JLabel("MENU PRINCIPAL");
		lblTitle.setForeground(new Color(100, 149, 237));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(58, 11, 193, 25);
		container.add(lblTitle);
		
		JButton btnReservas = new JButton("RESERVAS");
		btnReservas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReservasView reserva= new ReservasView();
				reserva.setVisible(true);
				//dispose();
			}
		});
		btnReservas.setForeground(new Color(100, 149, 237));
		btnReservas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReservas.setBounds(98, 59, 114, 23);
		container.add(btnReservas);
		
		JButton btnHuespedes = new JButton("HUESPEDES");
		btnHuespedes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HuespedesFrame huespedes= new HuespedesFrame();
				huespedes.setVisible(true);
				dispose();
			}
		});
		btnHuespedes.setForeground(new Color(100, 149, 237));
		btnHuespedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuespedes.setBounds(99, 103, 113, 23);
		container.add(btnHuespedes);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioView usuarioView = new UsuarioView();
				usuarioView.setVisible(true);
				dispose();
			}
		});
		btnUsuarios.setForeground(new Color(100, 149, 237));
		btnUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUsuarios.setBounds(99, 150, 113, 23);
		container.add(btnUsuarios);
		
		
	}
}

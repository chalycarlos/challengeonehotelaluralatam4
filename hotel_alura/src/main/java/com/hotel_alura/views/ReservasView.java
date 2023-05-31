package com.hotel_alura.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import java.awt.EventQueue;

import com.hotel_alura.controller.ReservasController;
import com.hotel_alura.modelo.Huespedes;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.hotel_alura.modelo.Reserva;






public class ReservasView extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static JTextField txtValor;
	public static JComboBox<String> txtFormaPago;
	int xMouse, yMouse;
	private JLabel lblTitulo,lblfechaEntrada,lblfechaSalida,lblPrecio ;
	private JLabel lblExit,lblAtras,lblSiguiente;
	private JPanel panel_1;
	private JButton btnAtras;
	private JButton btnGuardar;
	public static JDateChooser txtFechaSalida;
	public static JDateChooser txtFechaEntrada;
	private JComboBox formaPago;

	private ReservasController reservasController;
	
	
	
	
	public ReservasView() {
		super("Reserva");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		
		Container container = getContentPane();
		getContentPane().setLayout(null);
		
		configurarCamposDelFormulario(container);
		accionesDelFormulario();

		setVisible(true);
	}
				
		
		private void accionesDelFormulario() {
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Guardar();
					
				}				
				
			});	
		
	}


		private void configurarCamposDelFormulario(Container container) {
			//Crear codigo Interfaz
			
			//LABELS
			lblTitulo = new JLabel("FORMULARIO RESERVAS");
			lblTitulo.setBounds(77, 60, 251, 42);
			lblTitulo.setForeground(new Color(0, 0, 205));
			lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
			container.add(lblTitulo);
			
			lblfechaEntrada = new JLabel("FECHA DE CHECK IN");
			lblfechaEntrada.setForeground(SystemColor.textInactiveText);
			lblfechaEntrada.setBounds(68, 136, 169, 14);
			lblfechaEntrada.setFont(new Font("Dialog", Font.PLAIN, 17));
			container.add(lblfechaEntrada);
			
			lblfechaSalida = new JLabel("FECHA DE CHECK OUT");
			lblfechaSalida.setForeground(SystemColor.textInactiveText);
			lblfechaSalida.setBounds(68, 221, 187, 14);
			lblfechaSalida.setFont(new Font("Dialog", Font.PLAIN, 17));
			container.add(lblfechaSalida);
			
			JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
			lblFormaPago.setForeground(SystemColor.textInactiveText);
			lblFormaPago.setBounds(68, 383, 187, 24);
			lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			container.add(lblFormaPago);
			
			lblPrecio = new JLabel("PRECIO DE LA RESERVA");
			lblPrecio.setForeground(SystemColor.textInactiveText);
			lblPrecio.setBounds(68, 303, 200, 14);
			lblPrecio.setFont(new Font("Dialog", Font.PLAIN, 17));
			container.add(lblPrecio);
			
			lblExit = new JLabel("X");
			lblExit.setForeground(Color.WHITE);
			lblExit.setBounds(0, 0, 53, 36);
			//btnexit.add(lblExit);
			lblExit.setHorizontalAlignment(SwingConstants.CENTER);
			lblExit.setFont(new Font("Roboto", Font.PLAIN, 18));
			
			
			lblAtras = new JLabel("<");
			lblAtras.setBounds(0, 0, 53, 36);
			//btnAtras.add(lblAtras);
			lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
			lblAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
			
			lblSiguiente = new JLabel("SIGUIENTE");
			lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
			lblSiguiente.setForeground(Color.WHITE);
			lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
			lblSiguiente.setBounds(0, 0, 122, 35);
			
			
			panel_1 = new JPanel();
			panel_1.setBounds(429, 0, 481, 521);
			panel_1.setBackground(new Color(238, 232, 170));
			container.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblBienvenido = new JLabel("BIENVENIDO");
			lblBienvenido.setForeground(new Color(0, 0, 255));
			lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblBienvenido.setBounds(160, 11, 140, 30);
			panel_1.add(lblBienvenido);
			
			JPanel header = new JPanel();
			header.setBounds(0, 0, 430, 36);
			header.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					headerMouseDragged(e);
				     
				}
			});
			header.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					headerMousePressed(e);
				}
			});
			header.setLayout(null);
			header.setBackground(Color.WHITE);
			container.add(header);
			
			JPanel btnAtras = new JPanel();
			btnAtras.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuUsuario usuario = new MenuUsuario();
					usuario.setVisible(true);
					dispose();				
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					btnAtras.setBackground(new Color(12, 138, 199));
					lblAtras.setForeground(Color.white);
				}			
				@Override
				public void mouseExited(MouseEvent e) {
					 btnAtras.setBackground(Color.white);
					 lblAtras.setForeground(Color.black);
				}
			});
			
			btnAtras.setLayout(null);
			btnAtras.setBackground(Color.WHITE);
			btnAtras.setBounds(0, 0, 53, 36);
			header.add(btnAtras);
			
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnGuardar.setBounds(155, 477, 113, 33);
			container.add(btnGuardar);
			
			JDateChooser txtFechaSalida = new JDateChooser();
			txtFechaSalida.setBounds(68, 253, 284, 39);
			txtFechaSalida.setDateFormatString("yyyy-MM-dd");
			container.add(txtFechaSalida);
			
			txtFechaEntrada = new JDateChooser();
			txtFechaEntrada.setBounds(68, 161, 284, 36);
			txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
			container.add(txtFechaEntrada);
			
			txtValor = new JTextField();
			txtValor.setBackground(Color.WHITE);
			txtValor.setHorizontalAlignment(SwingConstants.LEFT);
			txtValor.setForeground(Color.BLACK);
			txtValor.setBounds(68, 328, 197, 33);
			//txtValor.setEditable(false);
			txtValor.setFont(new Font("Dialog", Font.BOLD, 16));
			txtValor.setBorder(new LineBorder(Color.LIGHT_GRAY));
			container.add(txtValor);
			txtValor.setColumns(10);


			txtFormaPago = new JComboBox();
			txtFormaPago.setBounds(68, 417, 289, 38);
			txtFormaPago.setBackground(SystemColor.text);
			txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
			txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
			container.add(txtFormaPago);

		}
		
		private void Guardar() {			
			
			
			var reservas= new Reserva(txtFechaEntrada.getDate(), 
					txtFechaSalida.getDate(), Double.valueOf(txtValor.getText()),txtFormaPago.getSelectedItem().toString()); 
			
			
			this.reservasController.Agregar(reservas);
			JOptionPane.showMessageDialog(this, "Registrado con éxito!");
			
		}
		
		private void headerMousePressed(java.awt.event.MouseEvent e) {
	        xMouse = e.getX();
	        yMouse = e.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent e) {
	        int x = e.getXOnScreen();
	        int y = e.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);

	    }
}
			
			
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		

		
		
		


	
		
	


		


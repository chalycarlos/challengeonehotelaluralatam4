package com.hotel_alura.views;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.hotel_alura.DAO.ReservaDAO;
import com.hotel_alura.controller.ReservasController;

public class MostrarReservasView extends JFrame {
	private JTable tableReservas;
	private JFrame ventana;
	private DefaultTableModel modelo;
	private ReservaDAO reservaDAO;
	private ReservasController reservaController;
	private TableModel datos;
	private TableColumnModel cabecera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarReservasView frame = new MostrarReservasView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public MostrarReservasView() {
		
		super("Reservas");
		
		this.reservaController = new ReservasController(null, null);
		this.reservaDAO = new ReservaDAO(null, null);
		setBounds(100, 100, 634, 291);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);	
		getContentPane().setBackground(new Color(211, 211, 211));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(25, 21, 583, 193);
		getContentPane().add(scrollPane);
		
		
		tableReservas = new JTable();
		scrollPane.setViewportView(tableReservas);
		
		tableReservas.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				
			}
		));
		
		modelo= (DefaultTableModel) tableReservas.getModel();
		
		modelo.addColumn("idreservas");
		modelo.addColumn("FechaEntrada");
		modelo.addColumn("FechaSalida");
		modelo.addColumn("Precio");
		modelo.addColumn("TipoPago");
		
		//modelo= (DefaultTableModel) tableReservas.getModel();
		
		
		
		cargarTabla();

	}

	public void cargarTabla() {
		var reservas= this.reservaController.listar();
		
		reservas.forEach(reserva -> modelo.addRow(
				new Object[] {
						reserva.getIdreservas(),
						reserva.getFechaEntrada(),
						reserva.getFechaSalida(),
						reserva.getPrecio(),
						reserva.getFormaPago(),
				}));		
				
		
	}

}

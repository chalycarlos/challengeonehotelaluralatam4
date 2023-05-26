package com.hotel_alura.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hotel_alura.controller.HuespedesController;
import com.hotel_alura.controller.ReservasController;
import com.hotel_alura.modelo.Huespedes;
import com.toedter.calendar.JDateChooser;

import com.hotel_alura.DAO.HuespedesDAO;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class HuespedesFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo,lblNombre, lblApellido, lblFechaNac, lblNacionalidad,lblTelefono;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtFechaNac;
	private JTextField txtNacionalidad;
	private JTextField txtTelefono;
	private JButton btnAgregar, btnModificar, btnLimpiar, btnEliminar, btnReporte;
	private JTable tabla;
	private DefaultTableModel modelo;
	private HuespedesController huespedesController;
	private ReservasController reservasController;



	public HuespedesFrame() {

		super("huespedes");
		getContentPane().setBackground(new Color(211, 211, 211));

		this.huespedesController = new HuespedesController();
		//this.reservasController = new ReservasController();
		
		Container container = getContentPane();
		getContentPane().setLayout(null);

		configurarTablaDeContenido(container);		
		configurarCamposDelFormulario(container);
		configurarAccionesDelFormulario();

		setVisible(true);

	}

	private void configurarAccionesDelFormulario() {
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar();
				limpiarTabla();
				cargarTabla();
			}	
	
		});	
		
		btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminar();
                limpiarTabla();
                cargarTabla();
            }
        });
		
		btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	modificar();
                limpiarTabla();
                cargarTabla();
            }

		 });
		
		btnReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirReporte();
            }
        });
	}
	

	private void modificar() {
		if (tieneFilaElegida()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
                    String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
                    String apellido = (String) modelo.getValueAt(tabla.getSelectedRow(), 2);
                    Date fechaNacimiento = Date.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
                    String nacionalidad = (String) modelo.getValueAt(tabla.getSelectedRow(), 4);
                    String telefono = (String)modelo.getValueAt(tabla.getSelectedRow(), 5);
                    
                    var filasModificadas = this.huespedesController.modificar(nombre, apellido, fechaNacimiento,nacionalidad,telefono, id);

                   
                    
                    JOptionPane.showMessageDialog(this, String.format("%d item modificado con éxito!", filasModificadas));
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
		
	}

	private void configurarCamposDelFormulario(Container container) {

		//LABELS
		lblTitulo = new JLabel("Registro Huespedes");			
		lblNombre = new JLabel("Nombre:");
		lblApellido = new JLabel("Apellido:");
		lblFechaNac = new JLabel("Fecha Nacimiento:");
		lblNacionalidad = new JLabel("Nacionalidad:");
		lblTelefono = new JLabel("Telefono:");

		lblTitulo.setBounds(273, 10, 240, 20);
		lblNombre.setBounds(10, 69, 240, 15);
		lblApellido.setBounds(10, 109, 240, 15);
		lblFechaNac.setBounds(10, 149, 240, 15);
		lblNacionalidad.setBounds(10, 193, 240, 15);
		lblTelefono.setBounds(10, 236, 94, 14);

		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setForeground(Color.BLACK);
		lblApellido.setForeground(Color.BLACK);
		lblFechaNac.setForeground(Color.BLACK);
		lblNacionalidad.setForeground(Color.BLACK);
		lblTelefono.setForeground(Color.BLACK);

		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtFechaNac = new JTextField();
		txtNacionalidad = new JTextField();
		txtTelefono = new JTextField();

		// TODO
		//var categorias = this.categoriaController.listar();
		// categorias.forEach(categoria -> comboCategoria.addItem(categoria));

		txtNombre.setBounds(10, 84, 265, 20);
		txtApellido.setBounds(10, 124, 265, 20);
		txtFechaNac.setBounds(10, 164, 265, 20);
		txtNacionalidad.setBounds(10, 207, 265, 20);
		txtTelefono.setBounds(10, 249, 265, 20);

		btnAgregar = new JButton("Agregar");
		btnLimpiar = new JButton("Limpiar");
		btnAgregar.setBounds(10, 284, 80, 20);
		btnLimpiar.setBounds(100, 284, 80, 20);

		container.add(lblTitulo);
		container.add(lblNombre);
		container.add(lblApellido);
		container.add(lblFechaNac);
		container.add(lblNacionalidad);
		container.add(lblTelefono);

		container.add(txtNombre);
		container.add(txtApellido);
		container.add(txtFechaNac);
		container.add(txtNacionalidad);
		container.add(txtTelefono);
		container.add(btnAgregar);
		container.add(btnLimpiar);	        


	}

	private void configurarTablaDeContenido(Container container) {
		tabla = new JTable();			


		modelo = (DefaultTableModel) tabla.getModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Fecha Nacimiento");
		modelo.addColumn("Nacionalidad");
		modelo.addColumn("Telefono");

		cargarTabla();

		tabla.setBounds(10, 340, 779, 233);
		tabla.setBorder(null);

		//BUTTONS			
		btnModificar = new JButton("Modificar");
		btnEliminar = new JButton("Eliminar");
		btnReporte = new JButton("Mostrar");
		btnModificar.setBounds(10, 609, 80, 20);
		btnEliminar.setBounds(100, 609, 80, 20);
		btnReporte.setBounds(190, 609, 80, 20);

		container.add(tabla);			
		container.add(btnModificar);
		container.add(btnEliminar);
		container.add(btnReporte);

		setSize(830, 750);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	private void cargarTabla() {			
		var huespedes = this.huespedesController.listar();		

		huespedes.forEach(huesped -> modelo.addRow(
				new Object[] {
						huesped.getId(),
						huesped.getNombre(),
						huesped.getApellido(),
						huesped.getFechaNacimiento(),
						huesped.getNacionalidad(),
						huesped.getTelefono()}));

	}

	private void Agregar() {
		if (txtNombre.getText().isBlank() || txtApellido.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Los Campos Nombre y Apellido son requeridos.");
			return;
		}

		String telefono;

		try {
			telefono = txtTelefono.getText();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, String
					.format("El campo Telefono debe ser numérico dentro del rango %d y %d.",0, Integer.MAX_VALUE));
			return;
		}

		var huesped= new Huespedes(txtNombre.getText(),
				txtApellido.getText(),Date.valueOf(txtFechaNac.getText()), txtNacionalidad.getText(),telefono);
		
		this.huespedesController.Agregar(huesped);
		JOptionPane.showMessageDialog(this, "Registrado con éxito!");

		this.limpiarFormulario();
	}
	
	private void eliminar() {
        if (tieneFilaElegida()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());                  
                    
                    var filasModificadas = this.huespedesController.eliminar(id);                    

                    modelo.removeRow(tabla.getSelectedRow());

                    JOptionPane.showMessageDialog(this, String.format("%d item eliminado con éxito!", filasModificadas));
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    }

	private void limpiarFormulario() {
		this.txtNombre.setText("");
		this.txtApellido.setText("");
		this.txtFechaNac.setText("");
		this.txtNacionalidad.setText("");
		this.txtTelefono.setText("");        
	}
	
	private void limpiarTabla() {
        modelo.getDataVector().clear();
    }
	
	private boolean tieneFilaElegida() {
        return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
    }
	
	private void abrirReporte() {
        new ReporteFrame(this);
    }
	
}



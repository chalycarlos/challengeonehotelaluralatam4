package com.hotel_alura.views;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.hotel_alura.controller.HuespedesController;

import javax.swing.JFrame;

public class ReporteFrame extends JFrame {

	private static final long serialVersionUID = 1L;

    private JTable tablaReporte;
    private DefaultTableModel modelo;

    private HuespedesController huespedesController;

    public ReporteFrame(HuespedesFrame huespedesFrame) {
        super("Reporte de Huespedes Hote Alura");

        this.huespedesController = new HuespedesController();

        Container container = getContentPane();
        setLayout(null);

        tablaReporte = new JTable();
        tablaReporte.setBounds(0, 0, 600, 400);
        container.add(tablaReporte);

        modelo = (DefaultTableModel) tablaReporte.getModel();
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");

        cargaReporte();

        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(huespedesFrame);
    }

    private void cargaReporte() {
        var contenido = huespedesController.cargaReporte();
        
        // TODO
        //contenido.forEach(fila -> modelo
               // .addRow(new Object[] {}));
    }
}

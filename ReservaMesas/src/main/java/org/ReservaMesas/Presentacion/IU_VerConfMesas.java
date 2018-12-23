/**
 * Paquete que contiene las clases de presentación del módulo ReservaMesas.
 **/
package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.ReservaMesas.Dominio.Mesa;
/**
 * Clase IU_P_VerConMesas. Interfaz que permite ver la configuración
 * de las mesas.
 *
 * @author in4mates
 * @version 1.0
 */
public class IU_VerConfMesas extends JPanel {
	/**
	 * ScrollPane.
	 **/
	private JScrollPane scrollPane;
	/**
	 * Table tabla de mesas.
	 **/
	private JTable tableMesas;
	/**
	 * Objeto del tipo mesa.
	 **/
	private Mesa mesa;
	/**
	 * Se suprimen los warnings de tipo serial.
	 **/
	@SuppressWarnings("serial")
	/**
	 * Constructor de la interfaz VerConMesas con todos
	 * sus campos y características.
	 **/
	public IU_VerConfMesas() {
		/**
		 * número cien.
		 **/
		final int cien = 100;
		/**
		 * número noventaYSeis.
		 **/
		final int noventaYSeis = 96;
		setBorder(new TitledBorder(null, "Configuraci\u00F3n mesas",
				TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setForeground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		{
			scrollPane = new JScrollPane();
			scrollPane.setName("");
			add(scrollPane, BorderLayout.CENTER);
			{
				tableMesas = new JTable();
				tableMesas.setName(
						"IdMesas\nComensales\nEstado");
				tableMesas.setModel(
						new DefaultTableModel(
							new Object[][] {},
						new String[] {"IdMesas",
							"Comensales",
							"Estado",
							"Hora ultimo"
							+ " estado" }) {
					boolean[] columnEditables =
							new boolean[] {
								false, false,
							false, false };

					public boolean isCellEditable(
							int row, int column) {
						return columnEditables[column];
					}
				});
				tableMesas.getColumnModel().getColumn(0)
						.setPreferredWidth(cien);
				tableMesas.getColumnModel()
				.getColumn(1)
				.setPreferredWidth(noventaYSeis);
				scrollPane.setViewportView(tableMesas);
			}
		}
		cargarMesas();
	}
	/**
	 * método CargarMesas que lee y carga todas las mesas en las tablas.
	 **/
	public void cargarMesas() {
		mesa = new Mesa();
		mesa.leerTodo();

		if (tableMesas.getRowCount() > 0) {

			DefaultTableModel modelo =
					(DefaultTableModel) tableMesas
					.getModel();
			int Limite = tableMesas.getRowCount() - 1;

			for (int i = Limite; i >= 0; i--) {
				modelo.removeRow(i);
			}

		}

		for (int i = 0; i < mesa.getGestorMesa()
				.getListaMesas().size(); i++) {
			Mesa aux = mesa.getGestorMesa().getListaMesas().get(i);
			DefaultTableModel modelo =
					(DefaultTableModel) tableMesas
					.getModel();
			Object filaNueva[] =
				{aux.getIdMesa(), aux.getComensales(),
					aux.getEstado().toString(),
					aux.getHoraEstado() };
			modelo.addRow(filaNueva);
		}

	}

}

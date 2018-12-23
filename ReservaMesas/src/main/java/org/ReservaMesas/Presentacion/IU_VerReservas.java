/**
 * Paquete que contiene las clases de presentación del módulo ReservaMesas.
 **/
package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;
import org.ReservaMesas.Dominio.Reserva;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase IU_P_VerReservas. Interfaz que permite ver las reservas
 * de las mesas.
 *
 * @author in4mates
 * @version 1.0
 */
public class IU_VerReservas extends JPanel {
	/**
	 * Panel que contiene los distintos botones.
	 **/
	private JPanel panelBotones;
	/**
	 * Boton de cancelar.
	 **/
	private JButton btnCancelar;
	/**
	 * ScrollPane.
	 **/
	private JScrollPane scrollPane;
	/**
	 * Tabla que contiene las reservas.
	 **/
	private JTable tableReservas;
	/**
	 * Objeto del tipo reserva.
	 **/
	private Reserva reserva;
	/**
	 * Boolean que indica si la reserva esta seleccionada.
	 **/
	private boolean selectedReserva;

	/**
	 * SIndica el formato que debe de tener la fecha y la hora.
	 **/
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yy HH:mm:ss");
	/**
	 * Constructor de la interfaz VerReservas con todos
	 * sus campos y características.
	 **/
	public IU_VerReservas() {
		selectedReserva = false;
		setBorder(new TitledBorder(
				null, "Reservas", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		{
			panelBotones = new JPanel();
			add(panelBotones, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(
					new BtnCancelarActionListener());
				panelBotones.add(btnCancelar);
			}
		}
		{
			scrollPane = new JScrollPane();

			add(scrollPane, BorderLayout.CENTER);
			{
				tableReservas = new JTable();
				tableReservas.addMouseListener(
					new TableReservasMouseListener());

				tableReservas.setModel(new DefaultTableModel(
						new Object[][] {},
						new String[] {"ID reserva",
								"NombreCliente",
								"Comensales",
								"Turno comida"
								+ "/cena",
								"Turno",
								"ID Mesa", }

				) {
					boolean[] columnEditables =
							new boolean[] {
							false, false,
							false, false,
							false, false };

					public boolean isCellEditable(
							int row, int column) {
						return columnEditables[column];
					}
				});
				scrollPane.setViewportView(tableReservas);
			}
		}
		recargarReservas();
	}
	/**
	 * Método que recarga las reservas en la tabla de reservas.
	 **/
	public void recargarReservas() {
		Reserva reserva1 = new Reserva();
		try {
			if (tableReservas.getRowCount() > 0) {

				DefaultTableModel modelo =
						(DefaultTableModel)
						tableReservas
						.getModel();
				int Limite = tableReservas.getRowCount() - 1;

				for (int i = Limite; i >= 0; i--) {
					modelo.removeRow(i);
				}

			}
			reserva1.leerTodo();
			for (int i = 0; i < reserva1
					.getGestorReserva().getListaReserva()
					.size(); i++) {

				Reserva aux =
						reserva1.getGestorReserva()
						.getListaReserva()
						.get(i);

				DefaultTableModel modelo =
						(DefaultTableModel)
						tableReservas
						.getModel();
				Object filaNueva[] = {aux.getIdReserva(),
						aux.getNombreCliente(),
						aux.getComensales(),
						aux.getTurnoComCen(),
						aux.getTurno(),
						aux.getMesa().getIdMesa() };
				modelo.addRow(filaNueva);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	/**
	 * Método que indica si la reserva esta seleccionada.
	 * @return selectedReserva .
	 **/
	public boolean isSelectedReserva() {
		return this.selectedReserva;

	}
	/**
	 * Método que asigna el valor de la reserva seleccionada.
	 * @param b .
	 **/
	public void setSelectedReserva(boolean b) {
		this.selectedReserva = b;
	}
	/**
	 * Clase TableReservasMouseListener.
	 *
	 * @author in4mates
	 * @version 1.0
	 */
	private class TableReservasMouseListener extends MouseAdapter {
		@Override
		/**
		 * Método mouseClicked.
		 * @param e .
		 **/
		public void mouseClicked(MouseEvent e) {
			try {
				reserva = new Reserva();
				int filaReserva =
						tableReservas.getSelectedRow();
				int idReserva = Integer.parseInt(
						tableReservas.getValueAt(
							filaReserva, 0)
								.toString());
				reserva.setIdReserva(idReserva);
				reserva.leer();
				setSelectedReserva(true);
			} catch (Exception arg0) {
				System.out.println(arg0.getMessage());
			}
		}
	}
	/**
	 * Clase BtnCancelarActionListener.
	 *
	 * @author in4mates
	 * @version 1.0
	 */
	private class BtnCancelarActionListener implements ActionListener {
		/**
		 * Método actionPerformed.
		 * @param e .
		 **/
		public void actionPerformed(ActionEvent e) {
			if (isSelectedReserva()) {
				try {
					Mesa mesa = reserva.getMesa();
					mesa.setEstado(Estados.LIBRE);
					Timestamp timestamp = new Timestamp(
							System
							.currentTimeMillis());
					mesa.setHoraEstado(
							sdf.format(timestamp));
					mesa.modificar();
					reserva.eliminar();

					setSelectedReserva(false);
					recargarReservas();
					JOptionPane.showMessageDialog(null,
							"Reserva eliminada"
							+ " correctamente",
							"Reserva eliminada",
							JOptionPane
							.INFORMATION_MESSAGE);
				} catch (Exception arg0) {
					System.out.println(arg0.getMessage());
				}
			} else {

				JOptionPane.showMessageDialog(null,
						"No ha selecionado "
						+ "ninguna reserva",
						"Error al cancelar reserva",
						JOptionPane.ERROR_MESSAGE);

			}
		}
	}
}

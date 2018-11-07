package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import org.ReservaMesas.Dominio.Reserva;

public class IU_VerReservas extends JPanel {
	private JPanel panelBotones;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTable tableReservas;
	private Reserva reserva;

	/**
	 * Create the panel.
	 */
	public IU_VerReservas() {
		setBorder(new TitledBorder(null, "Reservas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		{
			panelBotones = new JPanel();
			add(panelBotones, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cancelar");
				panelBotones.add(btnCancelar);
			}
		}
		{
			scrollPane = new JScrollPane();
			add(scrollPane, BorderLayout.CENTER);
			{
				tableReservas = new JTable();
				tableReservas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID reserva","NombreCliente", "Comensales", "Turno comida/cena", "Turno", "ID Mesa",
					}
				));
				scrollPane.setViewportView(tableReservas);
			}
		}
		RecargarReservas();
	}

	public void RecargarReservas() {
		reserva=new Reserva();
		reserva.leerTodo();
		
		for(int i=0;i<reserva.getGestorReserva().getListaReserva().size();i++) {
			
			Reserva aux=reserva.getGestorReserva().getListaReserva().get(i);
			
			DefaultTableModel modelo = (DefaultTableModel) tableReservas.getModel();
			Object filaNueva[] = {aux.getIdReserva(),aux.getNombreCliente(),aux.getComensales(),aux.getTurnoComCen(),aux.getTurno(),aux.getMesa().getIdMesa()};
			modelo.addRow(filaNueva);
		}
		
	}
	
	
}

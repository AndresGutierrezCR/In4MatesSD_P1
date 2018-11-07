package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.ReservaMesas.Dominio.Reserva;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_VerReservas extends JPanel {
	private JPanel panelBotones;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTable tableReservas;
	private Reserva reserva;
	private boolean selectedReserva;

	/**
	 * Create the panel.
	 */
	public IU_VerReservas() {
		selectedReserva=false;
		setBorder(new TitledBorder(null, "Reservas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		{
			panelBotones = new JPanel();
			add(panelBotones, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new BtnCancelarActionListener());
				panelBotones.add(btnCancelar);
			}
		}
		{
			scrollPane = new JScrollPane();
			
			add(scrollPane, BorderLayout.CENTER);
			{
				tableReservas = new JTable();
				tableReservas.addMouseListener(new TableReservasMouseListener());
		
				tableReservas.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID reserva",
						"NombreCliente", "Comensales", "Turno comida/cena", "Turno", "ID Mesa", }

				) {
					boolean[] columnEditables = new boolean[] { false, false, false,false,false,false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				scrollPane.setViewportView(tableReservas);
			}
		}
		RecargarReservas();
	}

	public void RecargarReservas() {
		reserva = new Reserva();
		reserva.leerTodo();
		tableReservas.removeAll();
		for (int i = 0; i < reserva.getGestorReserva().getListaReserva().size(); i++) {

			Reserva aux = reserva.getGestorReserva().getListaReserva().get(i);

			DefaultTableModel modelo = (DefaultTableModel) tableReservas.getModel();
			Object filaNueva[] = { aux.getIdReserva(), aux.getNombreCliente(), aux.getComensales(),
					aux.getTurnoComCen(), aux.getTurno(), aux.getMesa().getIdMesa() };
			modelo.addRow(filaNueva);
		}
	}
		public boolean isSelectedReserva() {
			return this.selectedReserva;
		
	}
		public void setSelectedReserva(boolean b) {
		 this.selectedReserva=b;
		}
		
	private class TableReservasMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(tableReservas.getSelectedRow());
			reserva = new Reserva();
			int filaReserva = tableReservas.getSelectedRow();
			int idReserva=Integer.parseInt(tableReservas.getValueAt(filaReserva, 0).toString());
			reserva.setIdReserva(idReserva);
			reserva.leer();
			setSelectedReserva(true);
			
		}
	}
	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(isSelectedReserva()) {
				reserva.eliminar();
				setSelectedReserva(false);
				
				RecargarReservas();
			}
			else {
				System.out.println("No ha seleccionado ninguna reserva");
			}
		}
	}
}

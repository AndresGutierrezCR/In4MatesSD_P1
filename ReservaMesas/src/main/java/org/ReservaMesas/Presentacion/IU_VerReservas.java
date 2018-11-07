package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class IU_VerReservas extends JPanel {
	private JPanel panelBotones;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTable table;

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
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID reserva","NombreCliente", "Comensales", "Turno comida/cena", "Turno", "ID Mesa",
					}
				));
				scrollPane.setViewportView(table);
			}
		}

	}

	public void RecargarReservas() {
		
	}
	
}

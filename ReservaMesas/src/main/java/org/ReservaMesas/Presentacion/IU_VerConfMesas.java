package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IU_VerConfMesas extends JPanel {
	private JScrollPane scrollPane;
	private JTable tableMesas;

	/**
	 * Create the panel.
	 */
	public IU_VerConfMesas() {
		setBorder(new TitledBorder(null, "Configuraci\u00F3n mesas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setForeground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		{
			scrollPane = new JScrollPane();
			add(scrollPane, BorderLayout.CENTER);
			{
				tableMesas = new JTable();
				scrollPane.setViewportView(tableMesas);
			}
		}

	}

}

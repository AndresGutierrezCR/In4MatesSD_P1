package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.ReservaMesas.Dominio.Mesa;

public class IU_VerConfMesas extends JPanel {
	private JScrollPane scrollPane;
	private JTable tableMesas;
	private Mesa mesa;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	
	public IU_VerConfMesas() {
		setBorder(new TitledBorder(null, "Configuraci\u00F3n mesas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setForeground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		{
			scrollPane = new JScrollPane();
			scrollPane.setName("");
			add(scrollPane, BorderLayout.CENTER);
			{
				tableMesas = new JTable();
				tableMesas.setName("IdMesas\nComensales\nEstado");
				tableMesas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"IdMesas", "Comensales", "Estado"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				scrollPane.setViewportView(tableMesas);
			}
		}
		cargarMesas();
	}
	
	public void cargarMesas() {
		mesa=new Mesa();
		mesa.leerTodo();
		
		for(int i=0;i<mesa.getGestorMesa().getListaMesas().size();i++) {
			Mesa aux=mesa.getGestorMesa().getListaMesas().get(i);
			DefaultTableModel modelo = (DefaultTableModel) tableMesas.getModel();
			Object filaNueva[] = {aux.getIdMesa(),aux.getComensales(),aux.getEstado().toString()};
			modelo.addRow(filaNueva);
		}
		
	}

}

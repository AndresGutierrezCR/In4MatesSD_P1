package org.ReservaMesas.Presentacion;

import org.Autenticacion.Presentacion.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana_Principal {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel tabReservaMesas;
	private JPanel tabEstados;
	private IU_EstadosMesas panelEstados;
	private IU_VerConfMesas panel_VerConfMesas;
	private IU_VerReservas panel_VerReservas;
	private IU_AsigMesa panel_HacerReservas;
	private JPanel tabAutenticacion;


	private JPanel panel_Autenticacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Principal window = new Ventana_Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana_Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(200, 200, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addMouseListener(new TabbedPaneMouseListener());
			frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				tabAutenticacion = new JPanel();
				tabbedPane.addTab("Autenticacion", null, tabAutenticacion, null);
				tabAutenticacion.setLayout(new BorderLayout(0, 0));
				{
					panel_Autenticacion = new IU_Autenticacion();
					tabAutenticacion.add(panel_Autenticacion, BorderLayout.CENTER);
				}
				
			}
			{
				tabReservaMesas = new JPanel();
				tabbedPane.addTab("Reserva", null, tabReservaMesas, null);
				tabbedPane.setEnabledAt(1, false);
				GridBagLayout gbl_tabReservaMesas = new GridBagLayout();
				gbl_tabReservaMesas.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
				gbl_tabReservaMesas.rowHeights = new int[]{0, 0, 0, 0, 0};
				gbl_tabReservaMesas.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_tabReservaMesas.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
				tabReservaMesas.setLayout(gbl_tabReservaMesas);
				
				{
					panel_VerConfMesas = new IU_VerConfMesas();
					GridBagConstraints gbc_panel_VerConfMesas = new GridBagConstraints();
					gbc_panel_VerConfMesas.gridwidth = 2;
					gbc_panel_VerConfMesas.insets = new Insets(0, 0, 5, 0);
					gbc_panel_VerConfMesas.fill = GridBagConstraints.BOTH;
					gbc_panel_VerConfMesas.gridx = 3;
					gbc_panel_VerConfMesas.gridy = 1;
					tabReservaMesas.add(panel_VerConfMesas, gbc_panel_VerConfMesas);
				}
				{
					panel_VerReservas = new IU_VerReservas();
					GridBagConstraints gbc_panel_VerReservas = new GridBagConstraints();
					gbc_panel_VerReservas.gridwidth = 4;
					gbc_panel_VerReservas.fill = GridBagConstraints.BOTH;
					gbc_panel_VerReservas.gridx = 1;
					gbc_panel_VerReservas.gridy = 3;
					tabReservaMesas.add(panel_VerReservas, gbc_panel_VerReservas);
				}
				{
					panel_HacerReservas = new IU_AsigMesa(panel_VerReservas);
					GridBagConstraints gbc_panel_HacerReservas = new GridBagConstraints();
					gbc_panel_HacerReservas.insets = new Insets(0, 0, 5, 5);
					gbc_panel_HacerReservas.fill = GridBagConstraints.BOTH;
					gbc_panel_HacerReservas.gridx = 1;
					gbc_panel_HacerReservas.gridy = 1;
					tabReservaMesas.add(panel_HacerReservas, gbc_panel_HacerReservas);
				}
			}
			{
				tabEstados = new JPanel();
				tabbedPane.addTab("Estados", null, tabEstados, null);
				tabbedPane.setEnabledAt(2, false);
				tabEstados.setLayout(new BorderLayout(0, 0));
				{
					panelEstados = new IU_EstadosMesas();
					tabEstados.add(panelEstados, BorderLayout.CENTER);
				}
			}
		}
	}

	
	private class TabbedPaneMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if (tabbedPane.getSelectedIndex() == 0){
				panel_VerConfMesas.cargarMesas();
			}else{
				panelEstados.recargar();
			}
		}
	
		
	}
}

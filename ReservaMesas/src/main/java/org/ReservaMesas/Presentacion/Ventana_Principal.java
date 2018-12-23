/**
 * Paquete que contiene las clases de presentación del módulo ReservaMesas.
 **/
package org.ReservaMesas.Presentacion;

import org.Autenticacion.Presentacion.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase Ventana_Principal. Interfaz que permite el resto de los paneles.
 *
 * @author in4mates
 * @version 1.0
 */
public class Ventana_Principal {
	/**
	 * Frame.
	 **/
	private JFrame frame;
	/**
	 * TabbedPane.
	 **/
	private JTabbedPane tabbedPane;
	/**
	 * tab de reserva mesas.
	 **/
	private JPanel tabReservaMesas;
	/**
	 * tab de estados.
	 **/
	private JPanel tabEstados;
	/**
	 * panel de estados.
	 **/
	private IU_EstadosMesas panelEstados;
	/**
	 * Panel para ver configuración de las mesas.
	 **/
	private IU_VerConfMesas panel_VerConfMesas;
	/**
	 * Panel para ver las reservas.
	 **/
	private IU_VerReservas panel_VerReservas;
	/**
	 * Panel para hacer las reservas.
	 **/
	private IU_AsigMesa panel_HacerReservas;
	/**
	 * tab de autenticación.
	 **/
	private JPanel tabAutenticacion;
	/**
	 * panel de autenticación.
	 **/
	private IU_Autenticacion panel_Autenticacion;
	/**
	 * Boton de entrar.
	 **/
	private JButton btnEntrar;

	/**
	 * Main.
	 * @param args .
	 **/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			/**
			 * Método run.
			 **/
			public void run() {
				try {
					Ventana_Principal window =
							new Ventana_Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la ventana principal de la aplicación.
	 **/
	public Ventana_Principal() {
		initialize();
	}

	/**
	 * Método initialize.
	 **/
	private void initialize() {
		/**
		 * número cinco.
		 **/
		final int cinco = 5;
		/**
		 * número tres.
		 **/
		final int tres = 3;
		/**
		 * número dosCientos.
		 **/
		final int dosCientos = 200;
		/**
		 * número milDosCientos.
		 **/
		final int milDosCientos = 1200;
		/**
		 * número seteCientos.
		 **/
		final int seteCientos = 700;
		/**
		 * número CuatroCientosOnce.
		 **/
		final int CuatroCientosOnce = 411;
		/**
		 * número CuatroCientosCinco.
		 **/
		final int CuatroCientosCinco = 405;
		/**
		 * número ochentaYTres.
		 **/
		final int ochentaYTres = 83;
		/**
		 * número cuatro.
		 **/
		final int cuatro = 4;
		frame = new JFrame();

		frame.setBounds(dosCientos,
				dosCientos,
				milDosCientos,
				seteCientos);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addMouseListener(
					new TabbedPaneMouseListener());
			frame.getContentPane().add(tabbedPane,
					BorderLayout.CENTER);
			{
				tabAutenticacion = new JPanel();
				tabbedPane.addTab("Autenticacion",
						null, tabAutenticacion,
						null);
				GridBagLayout gbl_tabAutenticacion =
						new GridBagLayout();
				gbl_tabAutenticacion.columnWidths =
						new int[] {CuatroCientosOnce,
								CuatroCientosCinco,
								0,
						0 };
				gbl_tabAutenticacion.rowHeights =
						new int[] {ochentaYTres,
								0, 0, 0 };
				gbl_tabAutenticacion.columnWeights =
						new double[] {0.0, 0.0,
						0.0, Double.MIN_VALUE };
				gbl_tabAutenticacion.rowWeights =
						new double[] {0.0, 0.0, 0.0,
						Double.MIN_VALUE };
				tabAutenticacion.setLayout(
						gbl_tabAutenticacion);
				{
					panel_Autenticacion =
						new IU_Autenticacion();
					GridBagConstraints gbc_panel =
						new GridBagConstraints();
					gbc_panel.insets =
						new Insets(0, 0, cinco, cinco);
					gbc_panel.fill =
							GridBagConstraints.BOTH;
					gbc_panel.gridx = 1;
					gbc_panel.gridy = 1;
					tabAutenticacion.add(
						panel_Autenticacion, gbc_panel);
				}
				{
					btnEntrar = new JButton("Entrar");
					btnEntrar.addActionListener(
						new BtnEntrarActionListener());
					GridBagConstraints gbc_btnEntrar =
						new GridBagConstraints();
					gbc_btnEntrar.insets =
						new Insets(0, 0, 0,
								cinco);
					gbc_btnEntrar.gridx = 1;
					gbc_btnEntrar.gridy = 2;
					tabAutenticacion.add(btnEntrar,
							gbc_btnEntrar);
				}

			}
			{
				tabReservaMesas = new JPanel();
				tabbedPane.addTab("Reserva", null,
						tabReservaMesas, null);
				tabbedPane.setEnabledAt(1, false);
				GridBagLayout gbl_tabReservaMesas =
						new GridBagLayout();
				gbl_tabReservaMesas.columnWidths =
						new int[] {0, 0, 0, 0, 0,
						0 };
				gbl_tabReservaMesas.rowHeights =
						new int[] {0, 0, 0, 0, 0 };
				gbl_tabReservaMesas.columnWeights =
						new double[] {0.0, 0.0,
						0.0, 0.0, 1.0,
						Double.MIN_VALUE };
				gbl_tabReservaMesas.rowWeights =
						new double[] {0.0, 1.0, 0.0,
						1.0, Double.MIN_VALUE };
				tabReservaMesas.setLayout(gbl_tabReservaMesas);

				{
					panel_VerConfMesas =
						new IU_VerConfMesas();
					GridBagConstraints gbc_panel_VerConfMesas =
						new GridBagConstraints();
					gbc_panel_VerConfMesas.gridwidth = 2;
					gbc_panel_VerConfMesas.insets =
						new Insets(0, 0, cinco, 0);
					gbc_panel_VerConfMesas.fill =
							GridBagConstraints.BOTH;
					gbc_panel_VerConfMesas.gridx = tres;
					gbc_panel_VerConfMesas.gridy = 1;
					tabReservaMesas.add(panel_VerConfMesas,
							gbc_panel_VerConfMesas);
				}
				{
					panel_VerReservas =
						new IU_VerReservas();
					GridBagConstraints gbc_panel_VerReservas =
						new GridBagConstraints();
					gbc_panel_VerReservas.gridwidth =
							cuatro;
					gbc_panel_VerReservas.fill =
							GridBagConstraints.BOTH;
					gbc_panel_VerReservas.gridx = 1;
					gbc_panel_VerReservas.gridy = tres;
					tabReservaMesas.add(panel_VerReservas,
							gbc_panel_VerReservas);
				}
				{
					panel_HacerReservas =
						new IU_AsigMesa(
							panel_VerReservas);
					GridBagConstraints gbc_panel_HacerReservas =
						new GridBagConstraints();
					gbc_panel_HacerReservas.insets =
						new Insets(0, 0, cinco, cinco);
					gbc_panel_HacerReservas.fill =
							GridBagConstraints.BOTH;
					gbc_panel_HacerReservas.gridx = 1;
					gbc_panel_HacerReservas.gridy = 1;
					tabReservaMesas.add(panel_HacerReservas,
						gbc_panel_HacerReservas);
				}
			}
			{
				tabEstados = new JPanel();
				tabbedPane.addTab("Estados",
						null, tabEstados, null);
				tabbedPane.setEnabledAt(2, false);
				tabEstados.setLayout(new BorderLayout(0, 0));
				{
					panelEstados = new IU_EstadosMesas();
					tabEstados.add(panelEstados,
							BorderLayout.CENTER);
				}
			}
		}
	}
	/**
	 * Clase TabbedPaneMouseListener.
	 *
	 * @author in4mates
	 * @version 1.0
	 */
	private class TabbedPaneMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {

			if (tabbedPane.getSelectedIndex() == 1) {
				panel_VerConfMesas.cargarMesas();
			} else if (tabbedPane.getSelectedIndex() == 2) {
				panelEstados.recargar();
			}

		}

	}
	/**
	 * Clase BtnEntrarActionListener.
	 *
	 * @author in4mates
	 * @version 1.0
	 */
	private class BtnEntrarActionListener implements ActionListener {
		/**
		 * Método actionPerformed.
		 * @param e .
		 **/
		public void actionPerformed(ActionEvent e) {
			if (panel_Autenticacion.aceptar()) {
				tabbedPane.setEnabledAt(2, true);
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setEnabledAt(0, false);
				Component[] componentes =
					panel_Autenticacion.getComponents();
				for (int i = 0; i < componentes.length; i++) {
					componentes[i].setEnabled(false);
				}
				panel_Autenticacion.setEnabled(false);
				btnEntrar.setEnabled(false);

			}
		}
	}
}

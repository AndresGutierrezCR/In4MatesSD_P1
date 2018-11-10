package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_P_estadoMesa extends JPanel {
	private JButton btnLibre;
	private JButton btnReservada;
	private JButton btnOcupada;
	private JButton btnPidiendo;
	private JButton btnEsperaDeComida;
	private JButton btnServidos;
	private JButton btnEsperaCuenta;
	private JButton btnPagando;
	private JButton btnPreparacion;
	
	private int idMesa;

	/**
	 * Create the panel.
	 */
	public IU_P_estadoMesa() {
		setBorder(new TitledBorder(null, "Estados mesa X", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{69, 105, 94, 94, 154, 93, 131, 94, 116, 0};
		gridBagLayout.rowHeights = new int[]{0, 25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			btnLibre = new JButton("Libre");
			GridBagConstraints gbc_btnLibre = new GridBagConstraints();
			gbc_btnLibre.anchor = GridBagConstraints.WEST;
			gbc_btnLibre.insets = new Insets(0, 0, 5, 5);
			gbc_btnLibre.gridx = 0;
			gbc_btnLibre.gridy = 1;
			add(btnLibre, gbc_btnLibre);
		}
		{
			btnReservada = new JButton("Reservada");
			GridBagConstraints gbc_btnReservada = new GridBagConstraints();
			gbc_btnReservada.anchor = GridBagConstraints.WEST;
			gbc_btnReservada.insets = new Insets(0, 0, 5, 5);
			gbc_btnReservada.gridx = 1;
			gbc_btnReservada.gridy = 1;
			add(btnReservada, gbc_btnReservada);
		}
		{
			btnOcupada = new JButton("Ocupada");
			GridBagConstraints gbc_btnOcupada = new GridBagConstraints();
			gbc_btnOcupada.anchor = GridBagConstraints.WEST;
			gbc_btnOcupada.insets = new Insets(0, 0, 5, 5);
			gbc_btnOcupada.gridx = 2;
			gbc_btnOcupada.gridy = 1;
			add(btnOcupada, gbc_btnOcupada);
		}
		{
			btnPidiendo = new JButton("Pidiendo");
			GridBagConstraints gbc_btnPidiendo = new GridBagConstraints();
			gbc_btnPidiendo.anchor = GridBagConstraints.WEST;
			gbc_btnPidiendo.insets = new Insets(0, 0, 5, 5);
			gbc_btnPidiendo.gridx = 3;
			gbc_btnPidiendo.gridy = 1;
			add(btnPidiendo, gbc_btnPidiendo);
		}
		{
			btnEsperaDeComida = new JButton("Espera de comida");
			GridBagConstraints gbc_btnEsperaDeComida = new GridBagConstraints();
			gbc_btnEsperaDeComida.anchor = GridBagConstraints.WEST;
			gbc_btnEsperaDeComida.insets = new Insets(0, 0, 5, 5);
			gbc_btnEsperaDeComida.gridx = 4;
			gbc_btnEsperaDeComida.gridy = 1;
			add(btnEsperaDeComida, gbc_btnEsperaDeComida);
		}
		{
			btnServidos = new JButton("Servidos");
			GridBagConstraints gbc_btnServidos = new GridBagConstraints();
			gbc_btnServidos.anchor = GridBagConstraints.WEST;
			gbc_btnServidos.insets = new Insets(0, 0, 5, 5);
			gbc_btnServidos.gridx = 5;
			gbc_btnServidos.gridy = 1;
			add(btnServidos, gbc_btnServidos);
		}
		{
			btnEsperaCuenta = new JButton("Espera cuenta");
			GridBagConstraints gbc_btnEsperaCuenta = new GridBagConstraints();
			gbc_btnEsperaCuenta.anchor = GridBagConstraints.WEST;
			gbc_btnEsperaCuenta.insets = new Insets(0, 0, 5, 5);
			gbc_btnEsperaCuenta.gridx = 6;
			gbc_btnEsperaCuenta.gridy = 1;
			add(btnEsperaCuenta, gbc_btnEsperaCuenta);
		}
		{
			btnPagando = new JButton("Pagando");
			GridBagConstraints gbc_btnPagando = new GridBagConstraints();
			gbc_btnPagando.anchor = GridBagConstraints.WEST;
			gbc_btnPagando.insets = new Insets(0, 0, 5, 5);
			gbc_btnPagando.gridx = 7;
			gbc_btnPagando.gridy = 1;
			add(btnPagando, gbc_btnPagando);
		}
		{
			btnPreparacion = new JButton("Preparación");
			GridBagConstraints gbc_btnPreparacion = new GridBagConstraints();
			gbc_btnPreparacion.insets = new Insets(0, 0, 5, 0);
			gbc_btnPreparacion.anchor = GridBagConstraints.WEST;
			gbc_btnPreparacion.gridx = 8;
			gbc_btnPreparacion.gridy = 1;
			add(btnPreparacion, gbc_btnPreparacion);
		}

	}
	
	public void setIdMesa(int idMesa) {
		this.idMesa=idMesa;
	}

	private class BtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
}

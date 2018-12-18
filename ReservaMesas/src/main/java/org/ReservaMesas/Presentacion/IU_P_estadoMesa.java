package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;

import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;

import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

	private Color colorSelecionado = new Color(200, 200, 250);
	private Color colorDefecto;
	private Estados estadoUltimo;

	private int idMesa;
	private Mesa mesa;

	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yy HH:mm:ss");

	/**
	 * Create the panel.
	 */
	public IU_P_estadoMesa(int idMesa) throws Exception {

		if (idMesa < 1) {
			throw new Exception("Id de mesa no posible");
		}
		this.idMesa=idMesa;
		setBorder(new TitledBorder(null, "Estados mesa X", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 69, 105, 94, 94, 154, 93, 131,
				94, 116, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 25, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		{
			btnLibre = new JButton("Libre");
			btnLibre.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnLibre = new GridBagConstraints();
			gbc_btnLibre.anchor = GridBagConstraints.WEST;
			gbc_btnLibre.insets = new Insets(0, 0, 5, 5);
			gbc_btnLibre.gridx = 0;
			gbc_btnLibre.gridy = 1;
			add(btnLibre, gbc_btnLibre);
			colorDefecto = btnLibre.getBackground();
		}
		{
			btnReservada = new JButton("Reservada");
			btnReservada.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnReservada = new GridBagConstraints();
			gbc_btnReservada.anchor = GridBagConstraints.WEST;
			gbc_btnReservada.insets = new Insets(0, 0, 5, 5);
			gbc_btnReservada.gridx = 1;
			gbc_btnReservada.gridy = 1;
			add(btnReservada, gbc_btnReservada);
		}
		{
			btnOcupada = new JButton("Ocupada");
			btnOcupada.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnOcupada = new GridBagConstraints();
			gbc_btnOcupada.anchor = GridBagConstraints.WEST;
			gbc_btnOcupada.insets = new Insets(0, 0, 5, 5);
			gbc_btnOcupada.gridx = 2;
			gbc_btnOcupada.gridy = 1;
			add(btnOcupada, gbc_btnOcupada);
		}
		{
			btnPidiendo = new JButton("Pidiendo");
			btnPidiendo.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnPidiendo = new GridBagConstraints();
			gbc_btnPidiendo.anchor = GridBagConstraints.WEST;
			gbc_btnPidiendo.insets = new Insets(0, 0, 5, 5);
			gbc_btnPidiendo.gridx = 3;
			gbc_btnPidiendo.gridy = 1;
			add(btnPidiendo, gbc_btnPidiendo);
		}
		{
			btnEsperaDeComida = new JButton("Espera de comida");
			btnEsperaDeComida.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnEsperaDeComida = new GridBagConstraints();
			gbc_btnEsperaDeComida.anchor = GridBagConstraints.WEST;
			gbc_btnEsperaDeComida.insets = new Insets(0, 0, 5, 5);
			gbc_btnEsperaDeComida.gridx = 4;
			gbc_btnEsperaDeComida.gridy = 1;
			add(btnEsperaDeComida, gbc_btnEsperaDeComida);
		}
		{
			btnServidos = new JButton("Servidos");
			btnServidos.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnServidos = new GridBagConstraints();
			gbc_btnServidos.anchor = GridBagConstraints.WEST;
			gbc_btnServidos.insets = new Insets(0, 0, 5, 5);
			gbc_btnServidos.gridx = 5;
			gbc_btnServidos.gridy = 1;
			add(btnServidos, gbc_btnServidos);
		}
		{
			btnEsperaCuenta = new JButton("Espera cuenta");
			btnEsperaCuenta.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnEsperaCuenta = new GridBagConstraints();
			gbc_btnEsperaCuenta.anchor = GridBagConstraints.WEST;
			gbc_btnEsperaCuenta.insets = new Insets(0, 0, 5, 5);
			gbc_btnEsperaCuenta.gridx = 6;
			gbc_btnEsperaCuenta.gridy = 1;
			add(btnEsperaCuenta, gbc_btnEsperaCuenta);
		}
		{
			btnPagando = new JButton("Pagando");
			btnPagando.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnPagando = new GridBagConstraints();
			gbc_btnPagando.anchor = GridBagConstraints.WEST;
			gbc_btnPagando.insets = new Insets(0, 0, 5, 5);
			gbc_btnPagando.gridx = 7;
			gbc_btnPagando.gridy = 1;
			add(btnPagando, gbc_btnPagando);
		}
		{
			btnPreparacion = new JButton("Preparación");
			btnPreparacion.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnPreparacion = new GridBagConstraints();
			gbc_btnPreparacion.insets = new Insets(0, 0, 5, 0);
			gbc_btnPreparacion.anchor = GridBagConstraints.WEST;
			gbc_btnPreparacion.gridx = 8;
			gbc_btnPreparacion.gridy = 1;
			add(btnPreparacion, gbc_btnPreparacion);
		}
		try {
			mesa = new Mesa();
			mesa.setIdMesa(idMesa);
			mesa.leer();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void estadoInicial() {

		Estados estado;
		estado = mesa.getEstado();
		estadoBotones(estado);
	}

	public void estadoBotones(Estados estado) {

		switch (estado) {

		case LIBRE:
			btnLibre.setBackground(colorSelecionado);
			btnLibre.setSelected(true);
			btnLibre.setForeground(Color.white);
			break;
		case RESERVADA:
			btnReservada.setBackground(colorSelecionado);
			btnReservada.setSelected(true);
			btnReservada.setForeground(Color.white);
			break;
		case OCUPADA:
			btnOcupada.setBackground(colorSelecionado);
			btnOcupada.setSelected(true);
			btnOcupada.setForeground(Color.white);
			break;
		case PIDIENDO:
			btnPidiendo.setBackground(colorSelecionado);
			btnPidiendo.setSelected(true);
			btnPidiendo.setForeground(Color.white);
			break;
		case ESPERA_COMIDA:
			btnEsperaDeComida.setBackground(colorSelecionado);
			btnEsperaDeComida.setSelected(true);
			btnEsperaDeComida.setForeground(Color.white);

			break;
		case SERVIDOS:
			btnServidos.setBackground(colorSelecionado);
			btnServidos.setSelected(true);
			btnServidos.setForeground(Color.white);
			break;
		case ESPERA_CUENTA:
			btnEsperaCuenta.setBackground(colorSelecionado);
			btnEsperaCuenta.setSelected(true);
			btnEsperaCuenta.setForeground(Color.white);
			break;
		case PAGANDO:
			btnPagando.setBackground(colorSelecionado);
			btnPagando.setSelected(true);
			btnPagando.setForeground(Color.white);
			break;
		case PREPARACION:
			btnPreparacion.setBackground(colorSelecionado);
			btnPreparacion.setSelected(true);
			btnPreparacion.setForeground(Color.white);
			break;
		}
		estadoUltimo = estado;
	}

	public Estados getEstadoUltimo() {
		return this.estadoUltimo;
	}

	public void volverColorInicial() {

		switch (estadoUltimo) {
		case LIBRE:
			btnLibre.setBackground(colorDefecto);
			btnLibre.setSelected(false);
			btnLibre.setForeground(Color.black);
			break;
		case RESERVADA:
			btnReservada.setBackground(colorDefecto);
			btnReservada.setSelected(false);
			btnReservada.setForeground(Color.black);
			break;
		case OCUPADA:
			btnOcupada.setBackground(colorDefecto);
			btnOcupada.setSelected(false);
			btnOcupada.setForeground(Color.black);
			break;
		case PIDIENDO:
			btnPidiendo.setBackground(colorDefecto);
			btnPidiendo.setSelected(false);
			btnPidiendo.setForeground(Color.black);
			break;
		case ESPERA_COMIDA:
			btnEsperaDeComida.setBackground(colorDefecto);
			btnEsperaDeComida.setSelected(false);
			btnEsperaDeComida.setForeground(Color.black);
			break;
		case SERVIDOS:
			btnServidos.setBackground(colorDefecto);
			btnServidos.setSelected(false);
			btnServidos.setForeground(Color.black);
			break;
		case ESPERA_CUENTA:
			btnEsperaCuenta.setBackground(colorDefecto);
			btnEsperaCuenta.setSelected(false);
			btnEsperaCuenta.setForeground(Color.black);
			break;
		case PAGANDO:
			btnPagando.setBackground(colorDefecto);
			btnPagando.setSelected(false);
			btnPagando.setForeground(Color.black);
			break;
		case PREPARACION:
			btnPreparacion.setBackground(colorDefecto);
			btnPreparacion.setSelected(false);
			btnPreparacion.setForeground(Color.black);
			break;
		}
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	
	public int getIDmesa() {
		return this.idMesa;
	}

	private class BtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String boton = e.getActionCommand().toString();
			Estados estado;
			estado = Estados.LIBRE;

			if (boton.equals("Libre")) {
				estado = Estados.LIBRE;
			} else if (boton.equals("Reservada")) {
				estado = Estados.RESERVADA;
			} else if (boton.equals("Ocupada")) {
				estado = Estados.OCUPADA;
			} else if (boton.equals("Pidiendo")) {
				estado = Estados.PIDIENDO;
			} else if (boton.equals("Espera de comida")) {
				estado = Estados.ESPERA_COMIDA;
			} else if (boton.equals("Servidos")) {
				estado = Estados.SERVIDOS;
			} else if (boton.equals("Espera cuenta")) {
				estado = Estados.ESPERA_CUENTA;
			} else if (boton.equals("Pagando")) {
				estado = Estados.PAGANDO;
			} else if (boton.equals("Preparación")) {
				estado = Estados.PREPARACION;
			}
			try {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				mesa.setHoraEstado(sdf.format(timestamp));

				mesa.setEstado(estado);
				mesa.modificar();
				volverColorInicial();
				estadoBotones(estado);

			} catch (Exception arg0) {
				System.out.println(arg0.getMessage());
			}

		}
	}

}

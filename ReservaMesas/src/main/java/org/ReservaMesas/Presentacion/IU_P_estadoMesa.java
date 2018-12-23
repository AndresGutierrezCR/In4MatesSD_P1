/**
 * Paquete que contiene las clases de presentación del módulo ReservaMesas.
 **/
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
/**
 * Clase IU_P_estadoMesa. Panel que contiene los distintos estados en los
 * que puede estar una mesa y poder modificar los mismos.
 *
 * @author in4mates
 * @version 1.0
 */
public class IU_P_estadoMesa extends JPanel {
	/**
	 * Botón del estado libre.
	 **/
	private JButton btnLibre;
	/**
	 * Botón del estado reservada.
	 **/
	private JButton btnReservada;
	/**
	 * Botón del estado ocupada.
	 **/
	private JButton btnOcupada;
	/**
	 * Botón del estado pidiendo.
	 **/
	private JButton btnPidiendo;
	/**
	 * Botón del estado esperando comida.
	 **/
	private JButton btnEsperaDeComida;
	/**
	 * Botón del estado mesa servida.
	 **/
	private JButton btnServidos;
	/**
	 * Botón del estado a la espera de la cuenta.
	 **/
	private JButton btnEsperaCuenta;
	/**
	 * Botón del estado pagando.
	 **/
	private JButton btnPagando;
	/**
	 * Botón del estado preparación.
	 **/
	private JButton btnPreparacion;
	/**
	 * número dosCientos.
	 **/
	final int dosCientos = 200;
	/**
	 * número dosCientosCincuenta.
	 **/
	final int dosCientosCincuenta = 250;
	/**
	 * Color que define la selección de algo.
	 **/
	private Color colorSelecionado =
			new Color(dosCientos,
					dosCientos,
					dosCientosCincuenta);
	/**
	 * Color por defecto.
	 **/
	private Color colorDefecto;
	/**
	 * Almacena el último estado.
	 **/
	private Estados estadoUltimo;
	/**
	 * Almacena el id de la mesa.
	 **/
	private int idMesa;
	/**
	 * Objeto del tipo mesa.
	 **/
	private Mesa mesa;
	/**
	 * Define el formato de la fecha y la hora.
	 **/
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yy HH:mm:ss");

	/**
	 * Constructor del panel estado mesa con todos
	 * sus campos y características.
	 * @param idMesa .
	 * @throws Exception .
	 **/
	public IU_P_estadoMesa(int idMesa) throws Exception {
		/**
		 * número cinco.
		 **/
		final int cinco = 5;
		/**
		 * número siete.
		 **/
		final int siete = 7;
		/**
		 * número ocho.
		 **/
		final int ocho = 8;
		/**
		 * número seis.
		 **/
		final int seis = 6;
		/**
		 * número tres.
		 **/
		final int tres = 3;
		/**
		 * número cuatro.
		 **/
		final int cuatro = 4;
		/**
		 * número noventaYCuatro.
		 **/
		final int noventaYCuatro = 94;
		/**
		 * número noventaYTres.
		 **/
		final int noventaYTres = 93;
		/**
		 * número sesentaYNueve.
		 **/
		final int sesentaYNueve = 69;
		/**
		 * número cientoCinco.
		 **/
		final int cientoCinco = 105;
		/**
		 * número cientoCincuentaYCuatro.
		 **/
		final int cientoCincuentaYCuatro = 154;
		/**
		 * número cientoTreintaYUno.
		 **/
		final int cientoTreintaYUno = 131;
		/**
		 * número cientoDiezYSeis.
		 **/
		final int cientoDiezYSeis = 116;
		/**
		 * número veintiCinco.
		 **/
		final int veintiCinco = 25;
		if (idMesa < 1) {
			throw new Exception("Id de mesa no posible");
		}
		this.idMesa = idMesa;
		setBorder(new TitledBorder(null, "Estados mesa X",
				TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout =
				new GridBagLayout();
		gridBagLayout.columnWidths =
				new int[] {sesentaYNueve,
						cientoCinco,
						noventaYCuatro,
						noventaYCuatro,
						cientoCincuentaYCuatro,
						noventaYTres,
						cientoTreintaYUno,
						noventaYCuatro,
						cientoDiezYSeis,
						0 };
		gridBagLayout.rowHeights = new int[] {0, veintiCinco, 0, 0 };
		gridBagLayout.columnWeights =
				new double[] {0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		{
			btnLibre = new JButton("Libre");
			btnLibre.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnLibre =
					new GridBagConstraints();
			gbc_btnLibre.anchor = GridBagConstraints.WEST;
			gbc_btnLibre.insets = new Insets(0, 0, cinco, cinco);
			gbc_btnLibre.gridx = 0;
			gbc_btnLibre.gridy = 1;
			add(btnLibre, gbc_btnLibre);
			colorDefecto = btnLibre.getBackground();
		}
		{
			btnReservada = new JButton("Reservada");
			btnReservada.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnReservada =
					new GridBagConstraints();
			gbc_btnReservada.anchor = GridBagConstraints.WEST;
			gbc_btnReservada.insets =
					new Insets(0, 0, cinco, cinco);
			gbc_btnReservada.gridx = 1;
			gbc_btnReservada.gridy = 1;
			add(btnReservada, gbc_btnReservada);
		}
		{
			btnOcupada = new JButton("Ocupada");
			btnOcupada.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnOcupada =
					new GridBagConstraints();
			gbc_btnOcupada.anchor = GridBagConstraints.WEST;
			gbc_btnOcupada.insets = new Insets(0, 0, cinco, cinco);
			gbc_btnOcupada.gridx = 2;
			gbc_btnOcupada.gridy = 1;
			add(btnOcupada, gbc_btnOcupada);
		}
		{
			btnPidiendo = new JButton("Pidiendo");
			btnPidiendo.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnPidiendo =
					new GridBagConstraints();
			gbc_btnPidiendo.anchor = GridBagConstraints.WEST;
			gbc_btnPidiendo.insets = new Insets(0, 0, cinco, cinco);
			gbc_btnPidiendo.gridx = tres;
			gbc_btnPidiendo.gridy = 1;
			add(btnPidiendo, gbc_btnPidiendo);
		}
		{
			btnEsperaDeComida = new JButton("Espera de comida");
			btnEsperaDeComida.addActionListener(
					new BtnActionListener());
			GridBagConstraints gbc_btnEsperaDeComida =
					new GridBagConstraints();
			gbc_btnEsperaDeComida.anchor = GridBagConstraints.WEST;
			gbc_btnEsperaDeComida.insets =
					new Insets(0, 0, cinco, cinco);
			gbc_btnEsperaDeComida.gridx = cuatro;
			gbc_btnEsperaDeComida.gridy = 1;
			add(btnEsperaDeComida, gbc_btnEsperaDeComida);
		}
		{
			btnServidos = new JButton("Servidos");
			btnServidos.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnServidos =
					new GridBagConstraints();
			gbc_btnServidos.anchor = GridBagConstraints.WEST;
			gbc_btnServidos.insets = new Insets(0, 0, cinco, cinco);
			gbc_btnServidos.gridx = cinco;
			gbc_btnServidos.gridy = 1;
			add(btnServidos, gbc_btnServidos);
		}
		{
			btnEsperaCuenta = new JButton("Espera cuenta");
			btnEsperaCuenta.addActionListener(
					new BtnActionListener());
			GridBagConstraints gbc_btnEsperaCuenta =
					new GridBagConstraints();
			gbc_btnEsperaCuenta.anchor = GridBagConstraints.WEST;
			gbc_btnEsperaCuenta.insets =
					new Insets(0, 0, cinco, cinco);
			gbc_btnEsperaCuenta.gridx = seis;
			gbc_btnEsperaCuenta.gridy = 1;
			add(btnEsperaCuenta, gbc_btnEsperaCuenta);
		}
		{
			btnPagando = new JButton("Pagando");
			btnPagando.addActionListener(new BtnActionListener());
			GridBagConstraints gbc_btnPagando =
					new GridBagConstraints();
			gbc_btnPagando.anchor = GridBagConstraints.WEST;
			gbc_btnPagando.insets = new Insets(0, 0, cinco, cinco);
			gbc_btnPagando.gridx = siete;
			gbc_btnPagando.gridy = 1;
			add(btnPagando, gbc_btnPagando);
		}
		{
			btnPreparacion = new JButton("Preparación");
			btnPreparacion.addActionListener(
					new BtnActionListener());
			GridBagConstraints gbc_btnPreparacion =
					new GridBagConstraints();
			gbc_btnPreparacion.insets = new Insets(0, 0, cinco, 0);
			gbc_btnPreparacion.anchor = GridBagConstraints.WEST;
			gbc_btnPreparacion.gridx = ocho;
			gbc_btnPreparacion.gridy = 1;
			add(btnPreparacion, gbc_btnPreparacion);
		}
		try {
			mesa = new Mesa();
			mesa.setIdMesa(idMesa);
			mesa.leer();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e
					.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	/**
	 * método estadoInicial que recoge el estado inicial de la mesa..
	 **/
	public void estadoInicial() {

		Estados estado;
		estado = mesa.getEstado();
		estadoBotones(estado);
	}
	/**
	 * método estadoBotones que cambia el formato de los botones en
	 * función del estado en el que se encuentra la mesa.
	 *
	 * @param estado .
	 **/
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
	/**
	 * método getEstadoUltimo que devuelve el ultimo estado de una mesa.
	 *
	 * @return estadoUltimo ultimo estado en el que ha estado una mesa.
	 **/
	public Estados getEstadoUltimo() {
		return this.estadoUltimo;
	}
	/**
	 * método volverColorInicial que cambia el color de los botones
	 * al original.
	 **/
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
	/**
	 * método setIdMesa que asigna el id a una mesa.
	 *
	 * @param idMesa id a asignar a una mesa.
	 **/
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	/**
	 * método getIDmesa que devuelve el id de una mesa.
	 *
	 * @return idMesa.
	 **/
	public int getIDmesa() {
		return this.idMesa;
	}
	/**
	 * Clase BtnActionListener.
	 *
	 * @author in4mates
	 * @version 1.0
	 */
	private class BtnActionListener implements ActionListener {
		/**
		 * método actionPerformed.
		 *
		 * @param e .
		 **/
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
				Timestamp timestamp = new Timestamp(
						System.currentTimeMillis());
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

/**
 * Paquete que contiene las clases de presentación del módulo ReservaMesas.
 **/
package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;
import org.ReservaMesas.Dominio.Reserva;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase IU_AsigMesa. Contiene la interfaz que permite la asignación de las
 * mesas a un cliente que ha solicitado su reserva.
 *
 * @author in4mates
 * @version 1.0
 */
public class IU_AsigMesa extends JPanel {
	/**
	 * label que indica donde colocar el nombre.
	 **/
	private JLabel lblNombreCliente;
	/**
	 * TextField donde colocar el nombre del cliente.
	 **/
	private JTextField txtNombreCliente;
	/**
	 * label que indica donde seleccionar la mesa.
	 **/
	private JLabel lblMesa;
	/**
	 * ComboBox donde seleccionar la mesa.
	 **/
	private JComboBox cmbMesas;
	/**
	 * label que indica donde seleccionar el turno de comida/cena.
	 **/
	private JLabel lblTurnoComCen;
	/**
	 * Button donde seleccionar el turno comida.
	 **/
	private JRadioButton rdbtnComida;
	/**
	 * Button donde seleccionar el turno cena.
	 **/
	private JRadioButton rdbtnCena;
	/**
	 * Crea un buttonGroup de los botones comida/cena para seleccionar
	 * unicamente uno de ellos.
	 **/
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * label que indica donde seleccionar el turno.
	 **/
	private JLabel lblTurno;
	/**
	 * ComboBox para seleccionar el turno.
	 **/
	private JComboBox cmbTurnos;
	/**
	 * Button para realizar la asignación.
	 **/
	private JButton btnAsignar;
	/**
	 * label que indica donde colocar el número de comensales.
	 **/
	private JLabel lblComensales;
	/**
	 * Seleccionas el número de comensales.
	 **/
	private JSpinner spnComensales;
	/**
	 * Abre la interfaz que muestra las reservas registradas.
	 **/
	private IU_VerReservas reservas;
	/**
	 * Declara el color original de la aplicación.
	 **/
	private Color colorOriginal;
	/**
	 * Declara el formato de fecha y hora.
	 **/
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yy HH:mm:ss");
	/**
	 * Constructor de la interfaz de asignación de mesas con todos
	 * sus campos y características.
	 **/
	public IU_AsigMesa(IU_VerReservas reservas) {
		this.reservas = reservas;
		setBorder(new TitledBorder(
				null, "Asignar mesa", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths =
				new int[] {0, 0, 156, 101, 0, 0 };
		gridBagLayout.rowHeights =
				new int[] {0, 34, 35, 33, 34, 36, 0, 0,
				0 };
		gridBagLayout.columnWeights =
				new double[] {0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights =
				new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		{
			lblNombreCliente = new JLabel("Nombre Cliente");
			GridBagConstraints gbc_lblNombreCliente =
					new GridBagConstraints();
			gbc_lblNombreCliente.anchor = GridBagConstraints.WEST;
			gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombreCliente.gridx = 1;
			gbc_lblNombreCliente.gridy = 1;
			add(lblNombreCliente, gbc_lblNombreCliente);
		}
		{
			txtNombreCliente = new JTextField();
			txtNombreCliente.addFocusListener(
					new ColorKeyListener());

			GridBagConstraints gbc_textField =
					new GridBagConstraints();
			gbc_textField.gridwidth = 2;
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			add(txtNombreCliente, gbc_textField);
			txtNombreCliente.setColumns(10);
		}
		{
			lblMesa = new JLabel("Mesa");
			GridBagConstraints gbc_lblMesa =
					new GridBagConstraints();
			gbc_lblMesa.anchor = GridBagConstraints.WEST;
			gbc_lblMesa.insets = new Insets(0, 0, 5, 5);
			gbc_lblMesa.gridx = 1;
			gbc_lblMesa.gridy = 2;
			add(lblMesa, gbc_lblMesa);
		}
		{
			cmbMesas = new JComboBox();
			cmbMesas.addFocusListener(new ColorKeyListener());
			Mesa m = new Mesa();
			m.leerTodo();
			ArrayList<String> listaIdMesas =
					new ArrayList<String>();

			for (int i = 0; i < m.getGestorMesa().getListaMesas()
					.size(); i++) {
				String id = Integer.toString(
						m.getGestorMesa()
						.getListaMesas()
						.get(i).getIdMesa());
				listaIdMesas.add(id);
			}

			cmbMesas.setModel(
					new DefaultComboBoxModel(
						listaIdMesas.toArray()));
			GridBagConstraints gbc_comboBox =
					new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 2;
			add(cmbMesas, gbc_comboBox);
		}
		{
			lblComensales = new JLabel("Comensales");
			GridBagConstraints gbc_lblComensales =
					new GridBagConstraints();
			gbc_lblComensales.anchor = GridBagConstraints.WEST;
			gbc_lblComensales.insets = new Insets(0, 0, 5, 5);
			gbc_lblComensales.gridx = 1;
			gbc_lblComensales.gridy = 3;
			add(lblComensales, gbc_lblComensales);
		}
		{
			spnComensales = new JSpinner();
			spnComensales.addFocusListener(new ColorKeyListener());
			spnComensales.setModel(
					new SpinnerNumberModel(1, 1, 6, 1));
			GridBagConstraints gbc_spinner =
					new GridBagConstraints();
			gbc_spinner.anchor = GridBagConstraints.WEST;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 2;
			gbc_spinner.gridy = 3;
			add(spnComensales, gbc_spinner);
		}
		{
			lblTurnoComCen = new JLabel("Turno Co/Ce");
			GridBagConstraints gbc_lblTurnoComCen =
					new GridBagConstraints();
			gbc_lblTurnoComCen.anchor = GridBagConstraints.WEST;
			gbc_lblTurnoComCen.insets = new Insets(0, 0, 5, 5);
			gbc_lblTurnoComCen.gridx = 1;
			gbc_lblTurnoComCen.gridy = 4;
			add(lblTurnoComCen, gbc_lblTurnoComCen);
		}
		{
			rdbtnComida = new JRadioButton("Comida");
			rdbtnComida.addFocusListener(new ColorKeyListener());
			buttonGroup.add(rdbtnComida);
			GridBagConstraints gbc_rdbtnComida =
					new GridBagConstraints();
			gbc_rdbtnComida.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnComida.gridx = 2;
			gbc_rdbtnComida.gridy = 4;
			add(rdbtnComida, gbc_rdbtnComida);
		}
		{
			rdbtnCena = new JRadioButton("Cena");
			rdbtnCena.addFocusListener(new ColorKeyListener());
			buttonGroup.add(rdbtnCena);
			GridBagConstraints gbc_rdbtnCena =
					new GridBagConstraints();
			gbc_rdbtnCena.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnCena.gridx = 3;
			gbc_rdbtnCena.gridy = 4;
			add(rdbtnCena, gbc_rdbtnCena);
		}
		{
			lblTurno = new JLabel("Turno ");
			GridBagConstraints gbc_lblTurno =
					new GridBagConstraints();
			gbc_lblTurno.anchor = GridBagConstraints.EAST;
			gbc_lblTurno.insets = new Insets(0, 0, 5, 5);
			gbc_lblTurno.gridx = 1;
			gbc_lblTurno.gridy = 5;
			add(lblTurno, gbc_lblTurno);
		}
		{
			cmbTurnos = new JComboBox();
			cmbTurnos.addFocusListener(new ColorKeyListener());
			cmbTurnos.setModel(
					new DefaultComboBoxModel(
					new String[] {"1", "2", "3" }));
			GridBagConstraints gbc_comboBox_1 =
					new GridBagConstraints();
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.gridx = 2;
			gbc_comboBox_1.gridy = 5;
			add(cmbTurnos, gbc_comboBox_1);
		}
		{
			btnAsignar = new JButton("Asignar");
			btnAsignar.addActionListener(
					new BtnAsignarActionListener());
			GridBagConstraints gbc_btnAsignar =
					new GridBagConstraints();
			gbc_btnAsignar.insets = new Insets(0, 0, 0, 5);
			gbc_btnAsignar.gridx = 2;
			gbc_btnAsignar.gridy = 7;
			add(btnAsignar, gbc_btnAsignar);
		}

	}
	/**
	 * Clase ColorKeyListener
	 *
	 * @author in4mates
	 * @version 1.0
	 */
	private class ColorKeyListener extends FocusAdapter {
		@Override
		/**
		 * método FocusGained que cambia el color del backgroud al de
		 * selección.
		 *
		 * @param e.
		 **/
		public void focusGained(FocusEvent e) {
			colorOriginal = e.getComponent().getBackground();
			e.getComponent()
			.setBackground(new Color(250,
					250, 210));
		}

		@Override
		/**
		 * Método focusLosto que cambia el color del background
		 * al original.
		 *
		 * @param e.
		 **/
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(colorOriginal);
		}
	}
	/**
	 * Clase BtnAsignarActionListener
	 *
	 * @author in4mates
	 * @version 1.0
	 */
	private class BtnAsignarActionListener implements ActionListener {
		/**
		 * Método actionPerformed.
		 *
		 * @param e .
		 **/
		public void actionPerformed(ActionEvent e) {

			Reserva res = new Reserva();
			res.asignarIDUltimo();
			try {
				Mesa m = new Mesa();
				m.setIdMesa(Integer
						.parseInt(cmbMesas
						.getSelectedItem().toString()));
				m.leer();
				res.setMesa(m);
				res.setNombreCliente(txtNombreCliente
						.getText());
				res.setComensales(
						Integer.parseInt(spnComensales
						.getValue().toString()));
				res.setTurnoComCen(rdbtnComida.isSelected() ? "comida" : "cena");
				res.setTurno(Integer
						.parseInt(cmbTurnos
						.getSelectedItem()
						.toString()));
				m.setEstado(Estados.RESERVADA);
				Timestamp timestamp = new Timestamp(
						System.currentTimeMillis());
				m.setHoraEstado(sdf.format(timestamp));
				if (!res.insertar()) {
					throw new Exception("Error "
						+ "al insertar la reserva");
				}

				if (!m.modificar()) {
					throw new Exception(
						"Error al modificar "
						+ "el estado de la mesa");
				}
				reservas.recargarReservas();

			} catch (Exception arg0) {
				JOptionPane.showMessageDialog(null,
						arg0.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}
}

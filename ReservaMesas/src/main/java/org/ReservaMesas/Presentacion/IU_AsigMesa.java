package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_AsigMesa extends JPanel {
	private JLabel lblNombreCliente;
	private JTextField txtNombreCliente;
	private JLabel lblMesa;
	private JComboBox cmbMesas;
	private JLabel lblTurnoComCen;
	private JRadioButton rdbtnComida;
	private JRadioButton rdbtnCena;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblTurno;
	private JComboBox cmbTurnos;
	private JButton btnAsignar;
	private JLabel lblComensales;
	private JSpinner spnComensales;

	private IU_VerReservas reservas;
	
	private Color colorOriginal;
	/**
	 * Create the panel.
	 */
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	
	public IU_AsigMesa(IU_VerReservas reservas) {
		this.reservas=reservas;
		setBorder(new TitledBorder(null, "Asignar mesa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 156, 101, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 34, 35, 33, 34, 36, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			lblNombreCliente = new JLabel("Nombre Cliente");
			GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
			gbc_lblNombreCliente.anchor = GridBagConstraints.WEST;
			gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombreCliente.gridx = 1;
			gbc_lblNombreCliente.gridy = 1;
			add(lblNombreCliente, gbc_lblNombreCliente);
		}
		{
			txtNombreCliente = new JTextField();
			txtNombreCliente.addFocusListener(new ColorKeyListener());
			
			GridBagConstraints gbc_textField = new GridBagConstraints();
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
			GridBagConstraints gbc_lblMesa = new GridBagConstraints();
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
			ArrayList<String> listaIdMesas=new ArrayList<String>();
			
			for(int i=0;i<m.getGestorMesa().getListaMesas().size();i++) {
				String id = Integer.toString(m.getGestorMesa().getListaMesas().get(i).getIdMesa());
				listaIdMesas.add(id);
			}
			
			
			cmbMesas.setModel(new DefaultComboBoxModel(listaIdMesas.toArray()));
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 2;
			add(cmbMesas, gbc_comboBox);
		}
		{
			lblComensales = new JLabel("Comensales");
			GridBagConstraints gbc_lblComensales = new GridBagConstraints();
			gbc_lblComensales.anchor = GridBagConstraints.WEST;
			gbc_lblComensales.insets = new Insets(0, 0, 5, 5);
			gbc_lblComensales.gridx = 1;
			gbc_lblComensales.gridy = 3;
			add(lblComensales, gbc_lblComensales);
		}
		{
			spnComensales = new JSpinner();
			spnComensales.addFocusListener(new ColorKeyListener());
			spnComensales.setModel(new SpinnerNumberModel(1, 1, 6, 1));
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.anchor = GridBagConstraints.WEST;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 2;
			gbc_spinner.gridy = 3;
			add(spnComensales, gbc_spinner);
		}
		{
			lblTurnoComCen = new JLabel("Turno Co/Ce");
			GridBagConstraints gbc_lblTurnoComCen = new GridBagConstraints();
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
			GridBagConstraints gbc_rdbtnComida = new GridBagConstraints();
			gbc_rdbtnComida.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnComida.gridx = 2;
			gbc_rdbtnComida.gridy = 4;
			add(rdbtnComida, gbc_rdbtnComida);
		}
		{
			rdbtnCena = new JRadioButton("Cena");
			rdbtnCena.addFocusListener(new ColorKeyListener());
			buttonGroup.add(rdbtnCena);
			GridBagConstraints gbc_rdbtnCena = new GridBagConstraints();
			gbc_rdbtnCena.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnCena.gridx = 3;
			gbc_rdbtnCena.gridy = 4;
			add(rdbtnCena, gbc_rdbtnCena);
		}
		{
			lblTurno = new JLabel("Turno ");
			GridBagConstraints gbc_lblTurno = new GridBagConstraints();
			gbc_lblTurno.anchor = GridBagConstraints.EAST;
			gbc_lblTurno.insets = new Insets(0, 0, 5, 5);
			gbc_lblTurno.gridx = 1;
			gbc_lblTurno.gridy = 5;
			add(lblTurno, gbc_lblTurno);
		}
		{
			cmbTurnos = new JComboBox();
			cmbTurnos.addFocusListener(new ColorKeyListener());
			cmbTurnos.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.gridx = 2;
			gbc_comboBox_1.gridy = 5;
			add(cmbTurnos, gbc_comboBox_1);
		}
		{
			btnAsignar = new JButton("Asignar");
			btnAsignar.addActionListener(new BtnAsignarActionListener());
			GridBagConstraints gbc_btnAsignar = new GridBagConstraints();
			gbc_btnAsignar.insets = new Insets(0, 0, 0, 5);
			gbc_btnAsignar.gridx = 2;
			gbc_btnAsignar.gridy = 7;
			add(btnAsignar, gbc_btnAsignar);
		}

	}

	
	private class ColorKeyListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			colorOriginal=e.getComponent().getBackground();
			e.getComponent().setBackground(new Color(250,250,210));
		}
		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(colorOriginal);
		}
	}
	private class BtnAsignarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Reserva res = new Reserva();
			res.asignarIDUltimo();
			try {
				res.setNombreCliente(txtNombreCliente.getText());
				res.setComensales(Integer.parseInt(spnComensales.getValue().toString()));
				res.setTurnoComCen(rdbtnComida.isSelected() ? "comida":"cena");
				res.setTurno(Integer.parseInt(cmbTurnos.getSelectedItem().toString()));
				Mesa m = new Mesa();
				m.setIdMesa(Integer.parseInt(cmbMesas.getSelectedItem().toString()));
				m.leer();
				m.setEstado(Estados.RESERVADA);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				m.setHoraEstado(sdf.format(timestamp));
				m.modificar();
				res.setMesa(m);
				res.insertar();
				reservas.RecargarReservas();
				
			}catch (Exception arg0) {
				System.out.println(arg0.getStackTrace());
			}
			
		}
	}
}

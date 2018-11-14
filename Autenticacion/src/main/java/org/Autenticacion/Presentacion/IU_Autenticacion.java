package org.Autenticacion.Presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class IU_Autenticacion extends JPanel{

	private JFrame frame;
	private JPanel panelAutenticacion;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JButton btnEntrar;
	
	private Color colorOriginal;
	private Color colorSeleccion = new Color(250,250,200);

	
	/**
	 * Create the application.
	 */
	public IU_Autenticacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 267);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			panelAutenticacion = new JPanel();
			panelAutenticacion.setBorder(new TitledBorder(null, "Autenticacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			frame.getContentPane().add(panelAutenticacion, BorderLayout.CENTER);
			GridBagLayout gbl_panelAutenticacion = new GridBagLayout();
			gbl_panelAutenticacion.columnWidths = new int[]{0, 0, 0, 19, 0, 0, 0};
			gbl_panelAutenticacion.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panelAutenticacion.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelAutenticacion.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelAutenticacion.setLayout(gbl_panelAutenticacion);
			{
				lblNombreDeUsuario = new JLabel("Nombre de usuario:");
				GridBagConstraints gbc_lblNombreDeUsuario = new GridBagConstraints();
				gbc_lblNombreDeUsuario.anchor = GridBagConstraints.EAST;
				gbc_lblNombreDeUsuario.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombreDeUsuario.gridx = 2;
				gbc_lblNombreDeUsuario.gridy = 2;
				panelAutenticacion.add(lblNombreDeUsuario, gbc_lblNombreDeUsuario);
			}
			{
				txtUsuario = new JTextField();
				txtUsuario.addFocusListener(new TxtFocusListener());
				GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
				gbc_txtUsuario.anchor = GridBagConstraints.NORTH;
				gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
				gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtUsuario.gridx = 4;
				gbc_txtUsuario.gridy = 2;
				panelAutenticacion.add(txtUsuario, gbc_txtUsuario);
				txtUsuario.setColumns(10);
			}
			colorOriginal = txtUsuario.getBackground();
			{
				lblContrasea = new JLabel("Contraseña");
				GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
				gbc_lblContrasea.anchor = GridBagConstraints.EAST;
				gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
				gbc_lblContrasea.gridx = 2;
				gbc_lblContrasea.gridy = 3;
				panelAutenticacion.add(lblContrasea, gbc_lblContrasea);
			}
			{
				passwordField = new JPasswordField();
				passwordField.addFocusListener(new TxtFocusListener());
				GridBagConstraints gbc_passwordField = new GridBagConstraints();
				gbc_passwordField.insets = new Insets(0, 0, 5, 5);
				gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
				gbc_passwordField.gridx = 4;
				gbc_passwordField.gridy = 3;
				panelAutenticacion.add(passwordField, gbc_passwordField);
			}
			{
				btnEntrar = new JButton("Entrar");
				GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
				gbc_btnEntrar.insets = new Insets(0, 0, 0, 5);
				gbc_btnEntrar.gridx = 4;
				gbc_btnEntrar.gridy = 5;
				panelAutenticacion.add(btnEntrar, gbc_btnEntrar);
			}
		}
	}

	private class TxtFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(colorSeleccion);
		}
		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(colorOriginal);
		}
	}
}

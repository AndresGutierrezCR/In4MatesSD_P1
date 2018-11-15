package org.Autenticacion.Presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.Autenticacion.Dominio.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Autenticacion extends JPanel {
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasea;
	private JTextField txtNombre;
	private JPasswordField passwordField;
	private JButton btnEntrar;
	
	private boolean autenticado = false;

	private Color colorOriginal;
	private Color colorSeleccion=new Color(250,250,200);
	
	private JFrame frame;
	
	/**
	 * Create the panel.
	 */
	public IU_Autenticacion() {
		setBorder(new TitledBorder(null, "Autenticacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 198, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			lblNombreDeUsuario = new JLabel("Nombre de usuario:");
			GridBagConstraints gbc_lblNombreDeUsuario = new GridBagConstraints();
			gbc_lblNombreDeUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombreDeUsuario.gridx = 1;
			gbc_lblNombreDeUsuario.gridy = 2;
			add(lblNombreDeUsuario, gbc_lblNombreDeUsuario);
		}
		{
			txtNombre = new JTextField();
			txtNombre.addFocusListener(new TxtFocusListener());
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 3;
			gbc_txtNombre.gridy = 2;
			add(txtNombre, gbc_txtNombre);
			txtNombre.setColumns(10);
		}
		colorOriginal=txtNombre.getBackground();
		{
			lblContrasea = new JLabel("Contraseña");
			GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
			gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
			gbc_lblContrasea.gridx = 1;
			gbc_lblContrasea.gridy = 3;
			add(lblContrasea, gbc_lblContrasea);
		}
		{
			passwordField = new JPasswordField();
			passwordField.addFocusListener(new TxtFocusListener());
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.insets = new Insets(0, 0, 5, 5);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 3;
			gbc_passwordField.gridy = 3;
			add(passwordField, gbc_passwordField);
		}
		{
			btnEntrar = new JButton("Entrar");
			btnEntrar.setVisible(false);
			btnEntrar.addActionListener(new BtnEntrarActionListener());
			GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
			gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
			gbc_btnEntrar.gridx = 3;
			gbc_btnEntrar.gridy = 5;
			add(btnEntrar, gbc_btnEntrar);
		}

	}
	
	public void setFrame(JFrame frame) {
		this.frame=frame;
	}
	
	public boolean getAutenticado() {
		return autenticado;
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
	public boolean aceptar() {
		boolean autenticado=false;
		try {
			if(txtNombre.getText().equals("") && passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "No ha introducido usuario y contraseña", "Autenticación",JOptionPane.WARNING_MESSAGE);
			}
			else {
				String nombre=txtNombre.getText();
				String pass = passwordField.getText();
				Usuario usuario = new Usuario();
				usuario.setNombre(nombre);
				usuario.setPassword(pass);
				
				if(!usuario.leer()) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Autenticación",JOptionPane.WARNING_MESSAGE);
				}
				else {
					autenticado=true;
					
					JOptionPane.showMessageDialog(null, "Autenticacion correcta", "Autenticación",JOptionPane.DEFAULT_OPTION);
					
				}
			}
		}catch(Exception arg0){
			autenticado=false;
		}
		return autenticado;
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			aceptar();
		}
	}
}

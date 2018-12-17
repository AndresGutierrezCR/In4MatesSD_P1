/**
 * Paquete que contiene las clases de presentación del módulo autenticarse.
 **/
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
/**
 * Clase IU_Autenticacion. Contiene la interfaz de autenticación que será utilizada por los usuarios
 * para identificarse en la aplicación y poder hacer uso de ella.
 *
 * @author in4mates
 * @version 1.0
 */
public class IU_Autenticacion extends JPanel {
	/**
	 * label que indica donde colocar el nombre.
	 **/
	private JLabel lblNombreDeUsuario;
	/**
	 * label que indica donde colocar la contrase�a.
	 **/
	private JLabel lblContrasea;
	/**
	 * Contenedor de texto donde se escribirá el nombre de usuario.
	 **/
	private JTextField txtNombre;
	/**
	 * Contenedor de texto donde se escribirá la contraseña de usuario.
	 **/
	private JPasswordField passwordField;
	/**
	 * Botón para realizar el login con los datos insertados.
	 **/
	private JButton btnEntrar;
	/**
	 * Boolean que indica si el proceso de autenticación se ha realizado de manera correcta o incorrecta.
	 **/
	private boolean autenticado = false;
	/**
	 * Variable que almacena el color original.
	 **/
	private Color colorOriginal;
	/**
	 * Variable que almacena el color que se coloca cuando se hace una selección.
	 **/
	private Color colorSeleccion=new Color(250,250,200);
	/**
	 * Jframe.
	 **/
	private JFrame frame;
	
	/**
	 * Genera la interfaz de autenticación con todos sus campos y características.
	 **/
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
	/**
	 * Setter del frame.
	 *
	 * @param frame.
	 */
	public void setFrame(JFrame frame) {
		this.frame=frame;
	}
	/**
	 * Getter autenticado.
	 *
	 * @return autenticado (valor booleano de si la autenticación es correcta o no).
	 */
	public boolean getAutenticado() {
		return autenticado;
	}
	/**
	 * Clase TxtFocusListener
	 *
	 * @author in4mates
	 * @version 1.0
	 */
	private class TxtFocusListener extends FocusAdapter {
		@Override
		/**
		 * método FocusGained que cambia el color del backgroud al de selección.
		 * @param e.
		 **/
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(colorSeleccion);
		}
		@Override
		/**
		 * Método focusLosto que cambia el color del background al original.
		 * @param e.
		 **/
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(colorOriginal);
		}
	}
	/**
	 * Setter setTxtNombre que inserta en el campo de texto del nombre una cadena con el nombre.
	 *
	 * @param nombre (nombre de usuario a poner en el campo de texto de nombre).
	 */
	public void setTxtNombre(String nombre) {
		txtNombre.setText(nombre);
	}
	/**
	 * Setter setTxtPassword que inserta en el campo de texto del password una cadena con la contraseña.
	 *
	 * @param pass (contraseña de usuario a poner en el campo de texto de password).
	 */
	public void setPassword(String pass) {
		passwordField.setText(pass);
	}
	/**
	 * Método que realiza la comprobación de si el usuario existe y se corresponde con uno valido de la base de datos.
	 * @return Valor a true o a false en función de si los datos introducidos pertenecen a un usuario almacenado en la base de datos.
	 */
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
				
				if(!usuario.autenticarse()) {
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
	/**
	 * Clase BtnEntrarActionListener
	 *
	 * @author in4mates
	 * @version 1.0
	 */
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			aceptar();
		}
	}
}

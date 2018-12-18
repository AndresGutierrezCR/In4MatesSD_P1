/**
 * Paquete que contiene las clases de persistencia del módulo autenticarse.
 **/
package org.Autenticacion.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.Autenticacion.Dominio.Usuario;

/**
 * Clase GestorUsuario. Utilizada como intermediario entre el usuario de la
 * aplicación y el agente que se conecta a la base de datos para realizar las
 * distintas operaciones. Es la encargada de realizar todas las consultas SQL de
 * lectura, eliminación, modificación y adición.
 *
 * @author in4mates
 * @version 1.0
 */

public class GestorUsuario {

	/**
	 * Array list que contendrá a los distintos usuarios que se lean de
	 * la base de datos.
	 **/
	private ArrayList<Usuario> listaUsuarios;

	/**
	 * Constructor por defecto. Realiza la creacion de la lista vacía de
	 * usuarios.
	 */
	public GestorUsuario() {
		this.listaUsuarios = new ArrayList<Usuario>();
	}

	/**
	 * Método que obtiene la lista de usuarios.
	 * @return Lista de los distintos usuarios que se cargaron en la
	 * lista con anterioridad.
	 */
	public ArrayList<Usuario> getListaUsuarios() {
		return this.listaUsuarios;
	}

	/**
	 * Método que envía la consula SQL de eliminación al agente, si este
	 * realiza la operación de manera correcta se obtendrá un valor de
	 * true como resultado de la ejecución del método.
	 * @param usuario (Usuario que se va a eliminar de la base de datos).
	 * @return Valor a true o a false en función de si la consulta se ha
	 * ejecutado de manera correcta o no.
	 */
	public boolean delete(Usuario usuario) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("DELETE FROM usuarios "
					+ "WHERE nombre = '"
					+ usuario.getNombre() + "'");
			correcto = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			correcto = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			correcto = false;
		}
		return correcto;
	}

	/**
	 * Método que envía la consula SQL de modificación al agente, si este
	 * realiza la operación de manera correcta se obtendrá un valor
	 * de true como resultado de la ejecución del método.
	 * @param usuario (Usuario que se va a modificar en la base de datos).
	 * @return Valor a true o a false en función de si la consulta se ha
	 * ejecutado de manera correcta o no.
	 */
	public boolean update(Usuario usuario) {
		boolean correcto = false;
		try {
			String SQL = "UPDATE usuarios SET nombre='" 
					+ usuario.getNombre() + "', " 
					+ "pass='" + usuario.getPassword() 
					+ "',tipo='" + usuario.getTipo() + "'" 
					+ " WHERE nombre = '"
					+ usuario.getNombre() + "' AND pass='"
					+ usuario.getPassword() + "'";
			Agente.getAgente().modificar(SQL);
			correcto = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			correcto = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			correcto = false;
		}
		return correcto;
	}

	/**
	 * Método que envía la consula SQL de creación de usuario al agente,
	 * si este realiza la operación de manera correcta se obtendrá un
	 * valor de true como resultado de la ejecución del metodo.
	 * @param usuario (Usuario que se va a añadir a la base de datos).
	 * @return Valor a true o a false en función de si la consulta se ha
	 * ejecutado de manera correcta o no.
	 */
	public boolean insert(Usuario usuario) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("INSERT INTO usuarios VALUES ('"
					+ usuario.getNombre() + "'," + "'" 
					+ usuario.getPassword()
					+ "','" + usuario.getTipo() + "')");
			correcto = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			correcto = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			correcto = false;
		}
		return correcto;
	}

	/**
	 * Método que envía la consula SQL de lectura al agente para comprobar
	 * de la existencia un usuario según los datos introducidos, si este
	 * realiza la operación de manera correcta se obtendrá un valor de true
	 * como resultado de la ejecución del método.
	 * @param usuario (Usuario sobre el cual se quieren comprobar sus datos
	 * para realizar el login).
	 * @return Valor a true o a false en funcion de si la consulta se ha
	 *         ejecutado de manera correcta o no.
	 */
	public boolean login(Usuario usuario) {
		ResultSet resultado;
		boolean existe = false;
		try {
			resultado = Agente.getAgente()
					.leer("SELECT * FROM usuarios WHERE nombre='"
							+ usuario.getNombre() + "'" + " AND pass='"
							+ usuario.getPassword() + "'");

			while (resultado.next()) {
				existe = true;
				usuario.setNombre(resultado.getString(1));
				usuario.setPassword(resultado.getString(2));
				usuario.setTipo(resultado.getString(3));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			existe = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			existe = false;
		}
		return existe;
	}

	/**
	 * Método que envía la consula SQL de lectura al agente para obtener los
	 * datos referentes a todos los usuarios, una vez se tengan los datos se
	 * iran creando usuarios y estos se añadiran a la lista.
	 * @return Valor a true o a false en funcion de si la consulta se ha
	 *         ejecutado de manera correcta o no.
	 */
	public boolean readAll() {
		ResultSet resultado;
		boolean correcto = false;
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM usuarios");
			Usuario usuario;

			while (resultado.next()) {
				correcto = true;
				usuario = new Usuario(resultado.getString(1),
						resultado.getString(2), resultado.getString(3));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			correcto = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			correcto = false;
		}
		return correcto;
	}

}

/**
 * org.Autenticacion.Dominio Paquete que contiene las clases de dominio del
 * modulo autenticarse.
 **/
package org.Autenticacion.Dominio;

import org.Autenticacion.Persistencia.GestorUsuario;

/**
 * Clase Usuario. Utilizada para representar a un usuario que se autentica en el
 * sistema. Cada usuario queda determinado por un nombre de usuario, una
 * contraseña y un tipo (función que desempeña dentro del restaurante)
 *
 * @author in4mates
 * @version 1.0
 */

public class Usuario {
	/**
	 * nombre de usuario.
	 **/
	private String nombre;
	/**
	 * contraseña para ese usuario.
	 **/
	private String password;
	/**
	 * tipo de usuario (camarero, jefe de salas, cocina).
	 **/
	private String tipo;
	/**
	 * Objeto de acceso a bbdd.
	 **/
	private GestorUsuario gestorUsuario;

	/**
	 * Constructor por defecto. Crea un usuario vacío.
	 */
	public Usuario() {
		this.gestorUsuario = new GestorUsuario();
	}
	/**
	 * Constructor con 3 parametros. Crea un usuario a partir
	 * de un nombre de usuario, contraseña y tipo.
	 *
	 * @param nombre   nombre de usuario
	 * @param password contraseña para ese usuario
	 * @param tipo     tipo de usuario (camarero, jefe de sala)
	 * @throws Exception si el nombre de usuario es una cadena vacia
	 */
	public Usuario(String nombre, String password, String tipo)
			throws Exception {
		if (nombre.length() < 1) {
			throw new Exception("El nombre no puede ser vacio");
		}
		if (password.length() < 1) {
			throw new Exception("La password no puede ser vacia");
		}
		if (tipo.length() < 1) {
			throw new Exception("El tipo no puede ser vacio");
		}
		this.gestorUsuario = new GestorUsuario();
		this.nombre = nombre;
		this.password = password;
		this.tipo = tipo;
	}

	/**
	 * Getter.
	 *
	 * @return nombre de usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter.
	 *
	 * @param nombre de usuario
	 * @throws Exception si el nombre es una cadena vacia
	 */
	public void setNombre(String nombre) throws Exception {
		if (nombre.length() < 1) {
			throw new Exception("El usuario no puede ser vacio");
		}
		this.nombre = nombre;
	}

	/**
	 * Getter.
	 *
	 * @return contraseña del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter.
	 *
	 * @param password nueva contraseña
	 * @throws Exception si el pass está vacío
	 */
	public void setPassword(String password) throws Exception {
		if (password.length() < 1) {
			throw new Exception("La password no puede ser vacia");
		}
		this.password = password;
	}

	/**
	 * Getter.
	 *
	 * @return tipo de usuario
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Setter.
	 *
	 * @param tipo (camarero,jefe de salas)
	 * @throws Exception si el tipo es una cadena vacía
	 */
	public void setTipo(String tipo) throws Exception {
		if (tipo.length() < 1) {
			throw new Exception("El tipo no puede ser vacio");
		}
		this.tipo = tipo;
	}

	/**
	 * Getter.
	 *
	 * @return GestorUsuario gestor de acceso a bbdd
	 */
	public GestorUsuario getGestorUsuario() {
		return gestorUsuario;
	}

	/**
	 * Eliminar un usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean eliminar() {
		return gestorUsuario.delete(this);
	}

	/**
	 * Iniciar sesión en el sistema.
	 *
	 * @return true si el inicio de sesión se completó
	 */
	public boolean autenticarse() {
		return gestorUsuario.login(this);
	}

	/**
	 * Leer todos los usuarios registrados.
	 *
	 * @return true si la lectura se completó correctamente
	 */
	public boolean leerTodo() {
		return gestorUsuario.readAll();
	}

	/**
	 * Modificar un usuario de la bbdd.
	 *
	 * @return true si la modificación se completó correctamente
	 */
	public boolean modificar() {
		return gestorUsuario.update(this);
	}

	/**
	 * Insertar un nuevo usuario en la bbdd.
	 *
	 * @return true si la inserción se completó correctamente
	 */
	public boolean insertar() {
		return gestorUsuario.insert(this);
	}

}

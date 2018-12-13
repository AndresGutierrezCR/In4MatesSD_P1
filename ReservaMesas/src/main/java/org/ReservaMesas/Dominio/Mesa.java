package org.ReservaMesas.Dominio;
/**
 * Info about this package.
 **/
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.ReservaMesas.Persistencia.GestorMesa;
/**
 * Clase Usuario. Utilizada para representar a un usuario que se autentica en el
 * sistema. Cada usuario queda determinado por un nombre de usuario, una
 * contraseña y un tipo (función que desempeña dentro del restaurante)
 *
 * @author in4mates
 * @version 1.0
 */

public class Mesa {
	/**
	 * Comenta variable
	 **/
	private int idMesa;
	/**
	 * Comenta variable
	 **/
	private int comensales;
	/**
	 * Comenta variable
	 **/
	private Estados estado;
	/**
	 * Comenta variable
	 **/
	private String horaEstado;
	/**
	 * Comenta variable
	 **/
	private GestorMesa gestorMesa;
	
	/**
	 * Constructor por defecto. Crea un usuario vacío.
	 */
	public Mesa() {
		this.gestorMesa = new GestorMesa();
	}
	
	/**
	 * Constructor con 3 parametros. Crea un usuario a partir de un nombre de
	 * usuario, contraseña y tipo.
	 *
	 * @param idMesa   ID de la mesa
	 * @param comensales contraseña para ese usuario
	 * @param estado     tipo de usuario (camarero, jefe de sala)
	 * @param horaEstado Fechad el estado en formato dd/MM/yy hh:mm:ss
	 * @throws Exception explicar
	 */
	public Mesa(int idMesa, int comensales, Estados estado, 
			String horaEstado) throws Exception {
		
		if (idMesa < 1) {
			throw new Exception("El id mesa debe ser positivo");
		}
		if (comensales < 1) {
			throw new Exception("Los comensales deben ser positivos");
		}

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		formatoFecha.setLenient(false);
		formatoFecha.parse(horaEstado);
		
		this.idMesa = idMesa;
		this.comensales = comensales;
		this.estado = estado;
		this.horaEstado = horaEstado;
		this.gestorMesa = new GestorMesa();
	}
	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public String getHoraEstado() {
		return horaEstado;
	}

	public void setHoraEstado(String horaEstado) throws ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		formatoFecha.setLenient(false);
		formatoFecha.parse(horaEstado);
		this.horaEstado = horaEstado;
	}

	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public int getIdMesa() {
		return idMesa;
	}
	
	/**
	 * Setter.
	 *
	 * @param idMesa comenta
	 * @throws Exception comenta
	 */
	public void setIdMesa(int idMesa)throws Exception {
		if (idMesa < 1) {
			throw new Exception("El id mesa debe ser positivo");
		}
		this.idMesa = idMesa;
	}

	/**
	 * @return El numero de comensales de la mesa (int).
	 **/
	public int getComensales() {
		return comensales;
	}
	
	/**
	 * Setter.
	 *
	 * @param comensales comenta
	 * @throws Exception comenta
	 */
	public void setComensales(int comensales)throws Exception {
		if (comensales < 1) {
			throw new Exception("Los comensales deben ser positivos");
		}
		this.comensales = comensales;
	}
	
	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public Estados getEstado() {
		return estado;
	}
	
	/**
	 * Setter.
	 *
	 * @param estado comenta
	 */
	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public GestorMesa getGestorMesa() {
		return gestorMesa;
	}

	/**
	 * Eliminar un usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean eliminar() {
		return gestorMesa.delete(this);
	}

	/**
	 * Modificar un usuario de la bbdd.
	 *
	 * @return comenta
	 */
	public boolean modificar() {
		return gestorMesa.update(this);
	}

	/**
	 * Insertar un usuario de la bbdd.
	 *
	 * @return comenta
	 */
	public boolean insertar() {
		return gestorMesa.insert(this);
	}

	/**
	 * Leer un usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean leer() {
		return gestorMesa.read(this);
	}

	/**
	 * Leer todos los usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean leerTodo() {
		return gestorMesa.readAll();
	}

}

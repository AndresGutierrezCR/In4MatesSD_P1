package org.ReservaMesas.Dominio;

/**
 * Paquete de Dominio dentro de ReservaMesas.
 **/
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.ReservaMesas.Persistencia.GestorMesa;

/**
 * Clase Mesa. Utilizada para representar el tipo de objeto Mesa, que puede ser
 * reservada por usuarios que usen el sistema. Cada mesa queda determinada por
 * un identificador de mesa, un numero de comensales, un estado (fase en la que
 * se encuentra la mesa en el sistema), una hora para el último cambio de
 * estado. Cuenta además con un gestor para mesas (en Persistencia).
 *
 * @author in4mates
 * @version 1.0
 */

public class Mesa {
	/**
	 * Variable identificadora para cada una de las mesas en el sistema.
	 **/
	private int idMesa;
	/**
	 * Numero de comensales que tendrán cada una de las mesas.
	 **/
	private int comensales;
	/**
	 * Fase en la que se encuentran cada una de las mesas.
	 **/
	private Estados estado;
	/**
	 * Última fecha y hora en la que se ha variado el estado de la mesa.
	 **/
	private String horaEstado;
	/**
	 * Objeto para la gestión de las mesas.
	 **/
	private GestorMesa gestorMesa;

	/**
	 * Constructor por defecto de Mesa. Crea una Mesa vacía.
	 */
	public Mesa() {
		this.gestorMesa = new GestorMesa();
	}

	/**
	 * Constructor con 4 parametros. Crea una mesa a partir de un identificador 
	 * unos comensales, un estado y una hora de estado.
	 *
	 * @param idMesa     ID de la mesa.
	 * @param comensales numero de comensales.
	 * @param estado    estado de la mesa (LIBRE, RESERVADA, OCUPADA, PIDIENDO,
	 *                  ESPERA_COMIDA, SERVIDOS, ESPERA_CUENTA, PAGANDO,
	 *                  PREPARACION).
	 * @param horaEstado Fecha del estado en formato dd/MM/yy hh:mm:ss .
	 * @throws Exception si el id de la mesa es menor que 1.
	 * @throws Exception si el número de comensales es menor que 1.
	 */
	public Mesa(int idMesa, int comensales, Estados estado, String horaEstado)
			throws Exception {

		if (idMesa < 1) {
			throw new Exception("El id mesa debe ser positivo");
		}
		if (comensales < 1) {
			throw new Exception("Los comensales deben ser positivos");
		}

		SimpleDateFormat formatoFecha = new SimpleDateFormat(
				"dd/MM/yy HH:mm:ss");
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
	 * @return hora y fecha exactas en las que el estado de la mesa ha sido
	 *         modificado (String).
	 */
	public String getHoraEstado() {
		return horaEstado;
	}

	/**
	 * Setter.
	 *
	 * @param horaEstado establece la hora y fecha del cambio de estado.
	 * @throws ParseException si no es una hora correcta.
	 */
	public void setHoraEstado(String horaEstado) throws ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat(
				"dd/MM/yy HH:mm:ss");
		formatoFecha.setLenient(false);
		formatoFecha.parse(horaEstado);
		this.horaEstado = horaEstado;
	}

	/**
	 * Getter.
	 *
	 * @return identificador de la mesa dentro de la base de datos (int).
	 */
	public int getIdMesa() {
		return idMesa;
	}

	/**
	 * Setter.
	 *
	 * @param idMesa establece el identificador de la mesa 
	 * y solo puede ser mayor que 1).
	 * @throws Exception lanza cualquier excepción que pueda surgir.
	 */
	public void setIdMesa(int idMesa) throws Exception {
		if (idMesa < 1) {
			throw new Exception("El id mesa debe ser positivo");
		}
		this.idMesa = idMesa;
	}

	/**
	 * Getter.
	 * 
	 * @return El numero de comensales de la mesa (int).
	 **/
	public int getComensales() {
		return comensales;
	}

	/**
	 * Setter.
	 *
	 * @param comensales establece el numero de comensales por cada mesa 
	 * (siempre mayor a 1).
	 * @throws Exception lanza cualquier excepción que pueda surgir.
	 */
	public void setComensales(int comensales) throws Exception {
		if (comensales < 1) {
			throw new Exception("Los comensales deben ser positivos");
		}
		this.comensales = comensales;
	}

	/**
	 * Getter.
	 *
	 * @return estado en el que se encuentra la mesa (Estados).
	 */
	public Estados getEstado() {
		return estado;
	}

	/**
	 * Setter.
	 *
	 * @param estado establece un estado para una mesa.
	 */
	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	/**
	 * Getter.
	 *
	 * @return objeto gestor de la mesa (GestorMesa).
	 */
	public GestorMesa getGestorMesa() {
		return gestorMesa;
	}

	/**
	 * Eliminar una mesa de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario.
	 */
	public boolean eliminar() {
		return gestorMesa.delete(this);
	}

	/**
	 * Modificar una mesa de la bbdd.
	 *
	 * @return true si se logró modificar, false en caso contrario.
	 */
	public boolean modificar() {
		return gestorMesa.update(this);
	}

	/**
	 * Insertar una mesa en la bbdd.
	 *
	 * @return true si se insertó con exito, false en caso contrario.
	 */
	public boolean insertar() {
		return gestorMesa.insert(this);
	}

	/**
	 * Leer una mesa de la bbdd.
	 *
	 * @return true si se realizó la lectura, false en caso contrario.
	 */
	public boolean leer() {
		return gestorMesa.read(this);
	}

	/**
	 * Leer todos las mesas de la bbdd.
	 *
	 * @return true si la lectura se completó, false en caso contrario.
	 */
	public boolean leerTodo() {
		return gestorMesa.readAll();
	}

}

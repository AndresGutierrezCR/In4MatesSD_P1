package org.ReservaMesas.Dominio;
/**
 * Enumerado Estados. Utilizado para secuenciar los estados de una mesa.
 *
 * @author in4mates
 * @version 1.0
 */
public enum Estados {
	/**
	 * Indica que el estado de la mesa es libre.
	 **/
	LIBRE,
	/**
	 * Indica que el estado de la mesa es reservada.
	 **/
	RESERVADA,
	/**
	 * Indica que el estado de la mesa es ocupada.
	 **/
	OCUPADA,
	/**
	 * Indica que el estado de la mesa es pidiendo.
	 **/
	PIDIENDO,
	/**
	 * Indica que el estado de la mesa es en espera de comida.
	 **/
	ESPERA_COMIDA,
	/**
	 * Indica que el estado de la mesa es servida.
	 **/
	SERVIDOS,
	/**
	 * Indica que el estado de la mesa es en espera de la cuenta.
	 **/
	ESPERA_CUENTA,
	/**
	 * Indica que el estado de la mesa es pagada.
	 **/
	PAGANDO,
	/**
	 * Indica que el estado de la mesa es preaparacion.
	 **/
	PREPARACION

}

package org.ReservaMesas.Dominio;
/**
 * Enumerado Estados. Utilizado para secuenciar los estados de una mesa.
 *
 * @author in4mates
 * @version 1.0
 */
public enum Estados {
	
	LIBRE, 
	RESERVADA,
	OCUPADA,
	PIDIENDO,
	ESPERA_COMIDA,
	SERVIDOS,
	ESPERA_CUENTA,
	PAGANDO,
	PREPARACION

}

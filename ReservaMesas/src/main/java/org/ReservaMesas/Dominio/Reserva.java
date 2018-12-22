package org.ReservaMesas.Dominio;

/**
 * Paquete de Dominio dentro de ReservaMesas.
 **/
import org.ReservaMesas.Persistencia.GestorReserva;

/**
 * Clase ReservaMesas. Utilizada para representar la reserva de cada una de las
 * mesas dentro del sistema. Cada reserva queda determinada por un identificador
 * de reserva, un nombre de cliente (el cual hace la reserva), el numero de
 * comensales a reservar, el turno de comida o cena, la mesa que se va a
 * reservar, y el número del turno en el que se reservará.
 *
 * @author in4mates
 * @version 1.0
 */
public class Reserva {
	/**
	 * Variable identificadora de la reserva de mesas en el sistema.
	 **/
	private int idReserva;
	/**
	 * Nombre del cliente (no usuario) que figura en la reserva.
	 **/
	private String nombreCliente;
	/**
	 * Número de comesales que atenderán a la mesa.
	 **/
	private int comensales;
	/**
	 * Turno del servicio (comida o cena).
	 **/
	private String turnoComCen;
	/**
	 * Número del turno dentro de los turnos principales (1, 2 o 3).
	 **/
	private int turno;
	/**
	 * Objeto de tipo mesa que representa la mesa a reservar.
	 **/
	private Mesa mesa;
	/**
	 * Objeto para la gestión de las reservas.
	 **/
	private GestorReserva gestorReserva;

	/**
	 * Constructor con 6 parametros. Crea una reserva de mesa a partir de un
	 * identificador, un nombre de cliente, un numero de comensales,
	 * un turno de comida o cena, un número de turno, y una mesa.
	 *
	 * @param idReserva     ID de la mesa.
	 * @param nombreCliente nombre del cliente que reserva la mesa.
	 * @param comensales    numero de comensales de la mesa.
	 * @param turnoComCen   turno de comida o cena de la reserva.
	 * @param turno         número del turno de la reserva.
	 * @param mesa          mesa en la que se realiza la reserva.
	 * @throws Exception si el identificador de la reserva es menor que 1.
	 * @throws Exception si el número de comensales supera al máximo
	 * permitido por la mesa.
	 * @throws Exception si el número de comensales es menor o igual a 0.
	 * @throws Exception si el número del turno es menor o igual a 0.
	 * @throws Exception si la longitud del nombre del cliente es menor a 1.
	 * @throws Exception si la longitud de la cadena del turno es menor a 1.
	 * @throws Exception si el turno no es comida o cena.
	 */
	public Reserva(int idReserva, String nombreCliente, int comensales,
			String turnoComCen, int turno, Mesa mesa)
					throws Exception {

		if (idReserva < 1) {
			throw new Exception("El numero de reserva no "
					+ "puede ser negativo");
		}

		if (comensales > mesa.getComensales()) {
			throw new Exception("Superado numero maximo "
					+ "de comensales");
		}
		if (comensales <= 0) {
			throw new Exception("el numero de comensales "
					+ "debe ser positivo");
		}
		if (turno <= 0) {
			throw new Exception("Turno no valido");
		}

		if (nombreCliente.length() < 1) {
			throw new Exception("Nombre de cliente no "
					+ "puede ser vacio");
		}
		if (turnoComCen.length() < 1) {
			throw new Exception("Tunro Comdida/Cena no "
					+ "puede ser invalido");
		}
		if (!(turnoComCen
				.equals("comida") || turnoComCen
				.equals("cena"))) {
			throw new Exception("No es un turno valido");
		}
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.comensales = comensales;
		this.turnoComCen = turnoComCen;
		this.turno = turno;
		this.mesa = mesa;
		this.gestorReserva = new GestorReserva();
	}

	/**
	 * Constructor por defecto. Crea una reserva vacía.
	 */
	public Reserva() {
		this.gestorReserva = new GestorReserva();
	}

	/**
	 * Asigna el último id posible a la reserva creada.
	 *
	 * @return true si se asigna correctamente, false en caso contrario.
	 */
	public boolean asignarIDUltimo() {
		return gestorReserva.lastID(this);
	}

	/**
	 * Borrar una reserva de la bbdd.
	 *
	 * @return true si el borrado se realizó, false en caso contrario.
	 */
	public boolean eliminar() {
		return gestorReserva.delete(this);
	}

	/**
	 * Modifica una reserva de la bbdd.
	 *
	 * @return true si se modificó con exito, false en caso contrario.
	 */
	public boolean modificar() {
		return gestorReserva.update(this);
	}

	/**
	 * Insertar reserva en la bbdd.
	 *
	 * @return true si se insertó, false en caso contrario.
	 */
	public boolean insertar() {
		return gestorReserva.insert(this);
	}

	/**
	 * Leer una reserva de la bbdd.
	 *
	 * @return true si se ha leído correctamente, false en caso contrario.
	 */
	public boolean leer() {
		return gestorReserva.read(this);
	}

	/**
	 * Leer todas las reservas de la bbdd.
	 *
	 * @return true si se han leido todas correctamente, false en caso
	 * contrario.
	 */
	public boolean leerTodo() {
		return gestorReserva.readAll();
	}

	/**
	 * Getter.
	 *
	 * @return objeto gestor de la reserva (GestorReserva).
	 */
	public GestorReserva getGestorReserva() {
		return this.gestorReserva;
	}

	/**
	 * Getter.
	 *
	 * @return identificador de la reserva (int).
	 */
	public int getIdReserva() {
		return idReserva;
	}

	/**
	 * Setter.
	 *
	 * @param idReserva establece el identificador de la reserva.
	 * @throws Exception lanza excepción si el número de id es menor que 1.
	 */
	public void setIdReserva(int idReserva) throws Exception {
		if (idReserva < 1) {
			throw new Exception("El numero de "
					+ "reserva no puede ser negativo");
		}
		this.idReserva = idReserva;
	}

	/**
	 * Getter.
	 *
	 * @return nombre del cliente que reserva (String).
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * Setter.
	 *
	 * @param nombreCliente establece el nombre del cliente en
	 * la reserva.
	 * @throws Exception lanza excepción si el nombre del
	 * cliente está vacío.
	 */
	public void setNombreCliente(String nombreCliente) throws Exception {
		if (nombreCliente.length() < 1) {
			throw new Exception("Nombre de cliente no"
					+ " puede ser vacio");
		}
		this.nombreCliente = nombreCliente;
	}

	/**
	 * Getter.
	 *
	 * @return número de personas (comensales) para los que se
	 * reserva la mesa(int).
	 */
	public int getComensales() {
		return comensales;
	}

	/**
	 * Setter.
	 *
	 * @param comensales establece el numero de comensales en la reserva.
	 * @throws Exception lanza excepción si se supera un número
	 * de comensales o elnúmero de comensales no es válido.
	 */
	public void setComensales(int comensales) throws Exception {
		if (comensales > this.mesa.getComensales()) {
			throw new Exception("Superado numero de comensales");
		}
		if (comensales <= 0) {
			throw new Exception("Numero de comensales no valido");
		}
		this.comensales = comensales;
	}

	/**
	 * Getter.
	 *
	 * @return turno de comida o cena en el que se establece la reserva
	 */
	public String getTurnoComCen() {

		return turnoComCen;
	}

	/**
	 * Setter.
	 *
	 * @param turnoComCen establece el turno (comida o cena)
	 * para la reserva.
	 * @throws Exception lanza excepción si el turno de comida
	 * o cena es inválido.
	 */
	public void setTurnoComCen(String turnoComCen) throws Exception {
		if (turnoComCen.length() < 1) {
			throw new Exception("Tunro Comdida/Cena "
					+ "no puede ser invalido");
		}
		if (!(turnoComCen
				.equals("comida") || turnoComCen
				.equals("cena"))) {
			throw new Exception("No es un turno valido");
		}
		this.turnoComCen = turnoComCen;
	}

	/**
	 * Getter.
	 *
	 * @return número del turno en el que se realiza la reserva (int).
	 */
	public int getTurno() {
		return turno;
	}

	/**
	 * Setter.
	 *
	 * @param turno establece el número del turno en la reserva (1, 2 o 3).
	 * @throws Exception lanza excepción si el turno es menor a 0.
	 */
	public void setTurno(int turno) throws Exception {
		if (turno < 0) {
			throw new Exception("Turno no valido");
		}
		this.turno = turno;
	}

	/**
	 * Getter.
	 *
	 * @return mesa que ha sido asignada a una reserva (Mesa).
	 */
	public Mesa getMesa() {
		return mesa;
	}

	/**
	 * Setter.
	 *
	 * @param mesa establecer la mesa en una reserva.
	 */
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}

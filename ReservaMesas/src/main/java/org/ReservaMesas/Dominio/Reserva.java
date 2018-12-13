package org.ReservaMesas.Dominio;
/**
 * Info about this package.
 **/
import org.ReservaMesas.Persistencia.GestorReserva;
/**
 * Clase Usuario. Utilizada para representar a un usuario que se autentica en el
 * sistema. Cada usuario queda determinado por un nombre de usuario, una
 * contraseña y un tipo (función que desempeña dentro del restaurante)
 *
 * @author in4mates
 * @version 1.0
 */
public class Reserva {
	/**
	 * Comenta variable
	 **/
	private int idReserva;
	/**
	 * Comenta variable
	 **/
	private String nombreCliente;
	/**
	 * Comenta variable
	 **/
	private int comensales;
	/**
	 * Comenta variable
	 **/
	private String turnoComCen;
	/**
	 * Comenta variable
	 **/
	private int turno;
	/**
	 * Comenta variable
	 **/
	private Mesa mesa;
	/**
	 * Comenta variable
	 **/
	private GestorReserva gestorReserva;

	/**
	 * Constructor con 5 parametros. Explicar.
	 *
	 * @param idReserva   ID de la mesa
	 * @param nombreCliente comenta
	 * @param comensales comenta     
	 * @param turnoComCen comenta
	 * @param turno comenta
	 * @param mesa comenta
	 * @throws Exception explicar
	 */
	public Reserva(int idReserva, String nombreCliente, int comensales, String turnoComCen, int turno, Mesa mesa) throws Exception{
		
		if(idReserva < 1) {
			throw new Exception("El numero de reserva no puede ser negativo");
		}
		
		if(comensales > mesa.getComensales()) {
			throw new Exception("Superado numero maximo de comensales");
		}
		if(comensales <=  0 ) {
			throw new Exception("el numero de comensales debe ser positivo");
		}
		if (turno <= 0) {
			throw new Exception("Turno no valido");
		}
		
		if(nombreCliente.length()<1) {
			throw new Exception("Nombre de cliente no puede ser vacio");
		}
		if(turnoComCen.length()<1 ) {
			throw new Exception("Tunro Comdida/Cena no puede ser invalido");
		}
		if(!(turnoComCen.equals("comida") || turnoComCen.equals("cena"))){
			throw new Exception("No es un turno valido");
		}
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.comensales = comensales;
		this.turnoComCen = turnoComCen;
		this.turno = turno;
		this.mesa = mesa;
		this.gestorReserva=new GestorReserva();
	}
	
	/**
	 * Constructor por defecto. Crea un usuario vacío.
	 */
	public Reserva() {
		this.gestorReserva=new GestorReserva();
	}
	
	/**
	 * Leer todos los usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean asignarIDUltimo() {
		return gestorReserva.lastID(this);
	}
	
	/**
	 * Leer todos los usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean eliminar() {
		return gestorReserva.delete(this);
	}
	
	/**
	 * Leer todos los usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean modificar() {
		return gestorReserva.update(this);
	}
	
	/**
	 * Leer todos los usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean insertar() {
		return gestorReserva.insert(this);
	}
	
	/**
	 * Leer todos los usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean leer() {
		return gestorReserva.read(this);
	}
	
	/**
	 * Leer todos los usuario de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario
	 */
	public boolean leerTodo() {
		return gestorReserva.readAll();
	}
	
	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public GestorReserva getGestorReserva() {
		return this.gestorReserva;
	}

	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public int getIdReserva() {
		return idReserva;
	}

	/**
	 * Setter.
	 *
	 * @param idReserva comenta
	 * @throws Exception comenta
	 */
	public void setIdReserva(int idReserva)throws Exception {
		if(idReserva < 1) {
			throw new Exception("El numero de reserva no puede ser negativo");
		}
		this.idReserva = idReserva;
	}

	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * Setter.
	 *
	 * @param nombreCliente comenta
	 * @throws Exception comenta
	 */
	public void setNombreCliente(String nombreCliente)throws Exception {
		if(nombreCliente.length()<1) {
			throw new Exception("Nombre de cliente no puede ser vacio");
		}
		this.nombreCliente = nombreCliente;
	}

	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public int getComensales() {
		return comensales;
	}

	/**
	 * Setter.
	 *
	 * @param comensales comenta.
	 * @throws Exception comenta
	 */
	public void setComensales(int comensales) throws Exception{
		if(comensales> this.mesa.getComensales()) {
			throw new Exception("Superado numero de comensales");
		}
		if(comensales <= 0) {
			throw new Exception("Numero de comensales no valido");
		}
		this.comensales = comensales;
	}

	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public String getTurnoComCen() {
		
		return turnoComCen;
	}

	/**
	 * Setter.
	 *
	 * @param turnoComCen comenta
	 * @throws Exception comenta
	 */
	public void setTurnoComCen(String turnoComCen) throws Exception {
		if(turnoComCen.length()<1 ) {
			throw new Exception("Tunro Comdida/Cena no puede ser invalido");
		}
		if(!(turnoComCen.equals("comida") || turnoComCen.equals("cena"))){
			throw new Exception("No es un turno valido");
		}
		this.turnoComCen = turnoComCen;
	}

	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public int getTurno() {
		return turno;
	}

	/**
	 * Setter.
	 *
	 * @param turno comenta.
	 * @throws Exception comenta
	 */
	public void setTurno(int turno) throws Exception{
		if (turno < 0) {
			throw new Exception("Turno no valido");
		}
		this.turno = turno;
	}

	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public Mesa getMesa() {
		return mesa;
	}

	/**
	 * Setter.
	 *
	 * @param mesa comenta
	 */
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	

}

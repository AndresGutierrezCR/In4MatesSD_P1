package org.ReservaMesas.Persistencia;

/**
 * Paquete de Persistencia dentro de ReservaMesas.
 **/
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.Autenticacion.Persistencia.Agente;
import org.ReservaMesas.Dominio.Mesa;
import org.ReservaMesas.Dominio.Reserva;

/**
 * Clase GestorReserva. Utilizada para la gestión de todas las posibles 
 * acciones que se pueden realizar sobre una reserva. Cada gestor de reservas 
 * queda determinado por una lista de reservas.
 *
 * @author in4mates
 * @version 1.0
 */
public class GestorReserva {
	/**
	 * ArrayList para la lista de las reservas del sistema.
	 **/
	private ArrayList<Reserva> listaReserva;

	/**
	 * Constructor por defecto. Crea la arraylist de reservas para listarlas.
	 */
	public GestorReserva() {
		listaReserva = new ArrayList<Reserva>();
	}

	/**
	 * Getter.
	 *
	 * @return lista dinámica de las reservas en el sistema.
	 */
	public ArrayList<Reserva> getListaReserva() {
		return listaReserva;
	}

	/**
	 * Setter.
	 *
	 * @param listaReserva establece la lista de reservas.
	 */
	public void setListaReserva(ArrayList<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}

	/**
	 * Borrar una reserva de la bbdd.
	 *
	 * @param reserva objeto reserva que se dispone para ser borrado de la base 
	 * de datos.
	 * @return true si el borrado se completó, false en caso contrario.
	 */
	public boolean delete(Reserva reserva) {
		boolean correcto = false;
		try {
			Agente.getAgente()
					.modificar("DELETE FROM reserva WHERE idReserva = "
							+ reserva.getIdReserva() + ";");
			correcto = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}

	/**
	 * Actualizar una reserva de la bbdd.
	 *
	 * @param reserva objeto reserva que se dispone para ser modificado en la 
	 * base de datos.
	 * @return true si se ha actualizado correctamente, false en caso contrario.
	 */
	public boolean update(Reserva reserva) {
		boolean correcto = false;

		try {
			Agente.getAgente().modificar("UPDATE reserva SET nombrecliente='"
					+ reserva.getNombreCliente() + "', " + "comensales="
					+ reserva.getComensales() + ", turnocomcen ='"
					+ reserva.getTurnoComCen() + "'" + ", turno="
					+ reserva.getTurno() + ", idMesa="
					+ reserva.getMesa().getIdMesa() + " WHERE idReserva = "
					+ reserva.getIdReserva() + ";");
			correcto = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}

	/**
	 * Insertar una reserva en la bbdd.
	 *
	 * @param reserva objeto reserva que se dispone para ser insertado en 
	 * la base de datos.
	 * @return true si el insertado se completó, false en caso contrario.
	 */
	public boolean insert(Reserva reserva) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("INSERT INTO reserva VALUES("
					+ reserva.getIdReserva() + ",'"
					+ reserva.getNombreCliente() + "',"
					+ reserva.getComensales() + ",'" + reserva.getTurnoComCen()
					+ "'," + reserva.getTurno() + ","
					+ reserva.getMesa().getIdMesa() + ");");
			correcto = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}

	/**
	 * Leer una reserva de la bbdd.
	 *
	 * @param reserva objeto reserva que se lee de la base de datos.
	 * @return true si la lectura se completó, false en caso contrario.
	 */
	public boolean read(Reserva reserva) {
		ResultSet resultado;
		boolean correcto = false;
		try {
			resultado = Agente.getAgente()
					.leer("SELECT * FROM reserva WHERE idReserva="
							+ reserva.getIdReserva() + ";");
			while (resultado.next()) {
				correcto = true;
				Mesa m = new Mesa();
				m.setIdMesa(resultado.getInt(6));
				m.leer();
				reserva.setMesa(m);
				reserva.setNombreCliente(resultado.getString(2));
				reserva.setComensales(resultado.getInt(3));
				reserva.setTurnoComCen(resultado.getString(4));
				reserva.setTurno(resultado.getInt(5));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}

	/**
	 * Asignar el último id a una reserva de la bbdd.
	 *
	 * @param reserva objeto reserva al que se le asigna el último id en la 
	 * base de datos.
	 * @return true si se asignó correctamente, false en caso contrario.
	 */
	public boolean lastID(Reserva reserva) {
		ResultSet resultado;
		boolean correcto = false;
		try {

			resultado = Agente.getAgente()
					.leer("SELECT MAX(idReserva) FROM reserva;");
			// resultado = Agente.getAgente().leer("SELECT * FROM reserva;");

			while (resultado.next()) {
				correcto = true;
				reserva.setIdReserva(resultado.getInt(1) + 1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Excepcion SQL");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excepcion general");
			// e.printStackTrace();
		}
		return correcto;
	}

	/**
	 * Leer todas las reservas de la bbdd.
	 *
	 * @return true si toda la lectura se completó, false en caso contrario.
	 */
	public boolean readAll() {
		boolean correcto = false;
		ResultSet resultado;

		try {
			resultado = Agente.getAgente()
					.leer("SELECT * FROM reserva ORDER BY idReserva;");
			Reserva reserva;

			while (resultado.next()) {
				correcto = true;
				Mesa m = new Mesa();
				m.setIdMesa(resultado.getInt(6));
				m.leer();
				reserva = new Reserva(resultado.getInt(1),
						resultado.getString(2), resultado.getInt(3),
						resultado.getString(4), resultado.getInt(5), m);

				listaReserva.add(reserva);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;

	}

}

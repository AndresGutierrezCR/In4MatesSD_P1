package org.ReservaMesas.Persistencia;

/**
 * Paquete de Persistencia dentro de ReservaMesas.
 **/
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.Autenticacion.Persistencia.Agente;
import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;

/**
 * Clase GestorMesa. Utilizada para la gestión de todas las posibles acciones
 * que se pueden realizar sobre una mesa. Cada gestor de mesas queda 
 * determinado por una lista de mesas.
 *
 * @author in4mates
 * @version 1.0
 */
public class GestorMesa {
	/**
	 * ArrayList para la lista de las mesas del sistema.
	 **/
	private ArrayList<Mesa> listaMesas;

	/**
	 * Constructor por defecto. Crea la arraylist de mesas para listarlas.
	 */
	public GestorMesa() {
		listaMesas = new ArrayList<Mesa>();
	}

	/**
	 * Getter.
	 *
	 * @return lista dinámica de las mesas en el sistema.
	 */
	public ArrayList<Mesa> getListaMesas() {
		return listaMesas;
	}

	/**
	 * Setter.
	 *
	 * @param listaMesas establece la lista de mesas.
	 */
	public void setListaMesas(ArrayList<Mesa> listaMesas) {
		this.listaMesas = listaMesas;
	}

	/**
	 * Borrar una mesa de la bbdd.
	 *
	 * @param mesa objeto mesa que se dispone para ser borrado de la base de 
	 * datos.
	 * @return true si el borrado se completó, false en caso contrario.
	 */
	public boolean delete(Mesa mesa) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("DELETE FROM mesas WHERE "
					+ "idMesa = " + mesa.getIdMesa() + "");
			correcto = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			correcto = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			correcto = false;
		}
		return correcto;
	}

	/**
	 * Actualizar una mesa de la bbdd.
	 *
	 * @param mesa objeto mesa que se dispone para ser modificado en la base de
	 *             datos.
	 * @return true si se ha actualizado correctamente, false en caso contrario.
	 */
	public boolean update(final Mesa mesa) {
		boolean correcto = false;
		try {
			final String SQL = "UPDATE mesas SET comensales="
					+ mesa.getComensales() + ", " + "estado='"
					+ mesa.getEstado() + "', horaEstado='"
					+ mesa.getHoraEstado() + "' WHERE idMesa = "
					+ mesa.getIdMesa() + "";
	
			Agente.getAgente().modificar(SQL);
			correcto = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			correcto = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			correcto = false;
		}
		return correcto;
	}

	/**
	 * Insertar una mesa en la bbdd.
	 *
	 * @param mesa objeto mesa que se dispone para ser insertado en la base de
	 *             datos.
	 * @return true si el insertado se completó, false en caso contrario.
	 */
	public boolean insert(final Mesa mesa) {
		boolean correcto = false;
		try {
			final String SQL = "INSERT INTO mesas VALUES(" + mesa.getIdMesa()
					+ "," + mesa.getComensales() + ",'" + mesa.getEstado()
					+ "','" + mesa.getHoraEstado() + "')";
			Agente.getAgente().modificar(SQL);
			correcto = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			correcto = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			correcto = false;
		}
		return correcto;
	}

	/**
	 * Leer una mesa de la bbdd.
	 * 
	 * @param mesa objeto mesa que se lee de la base de datos.
	 * @return true si la lectura se completó, false en caso contrario.
	 */
	public boolean read(Mesa mesa) {
		boolean correcto = false;
		ResultSet resultado;
		try {
			resultado = Agente.getAgente()
					.leer("SELECT * FROM mesas WHERE idmesa="
							+ mesa.getIdMesa() + "");
			while (resultado.next()) {
				correcto = true;
				mesa.setComensales(resultado.getInt(2));
				Estados estado = Estados.valueOf(resultado.getString(3));
				mesa.setEstado(estado);
				mesa.setHoraEstado(resultado.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			correcto = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			correcto = false;
		}
		return correcto;
	}

	/**
	 * Leer todas las mesas de la bbdd.
	 *
	 * @return true si toda la lectura se completó, false en caso contrario.
	 */
	public boolean readAll() {
		ResultSet resultado;
		boolean correcto = false;
		try {
			resultado = Agente.getAgente()
					.leer("SELECT * FROM mesas ORDER BY idMesa");
			Mesa mesa;

			while (resultado.next()) {
				correcto = true;
				Estados estado = Estados.valueOf(resultado.getString(3));
				mesa = new Mesa(resultado.getInt(1), resultado.getInt(2),
						estado, resultado.getString(4));
				listaMesas.add(mesa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			correcto = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			correcto = false;
		}
		return correcto;
	}

}

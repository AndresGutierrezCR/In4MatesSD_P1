package org.ReservaMesas.Persistencia;
/**
 * Info about this package.
 **/
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.Autenticacion.Persistencia.Agente;
import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;
/**
 * Clase Usuario. Utilizada para representar a un usuario que se autentica en el
 * sistema. Cada usuario queda determinado por un nombre de usuario, una
 * contraseña y un tipo (función que desempeña dentro del restaurante)
 *
 * @author in4mates
 * @version 1.0
 */
public class GestorMesa {
	/**
	 * Comenta variable
	 **/
	private ArrayList<Mesa> listaMesas;
	
	/**
	 * Constructor por defecto.
	 */
	public GestorMesa() {
		listaMesas = new ArrayList<Mesa>();
	}

	/**
	 * Getter.
	 *
	 * @return lo que devuelve
	 */
	public ArrayList<Mesa> getListaMesas() {
		return listaMesas;
	}

	/**
	 * Setter.
	 *
	 * @param 
	 * @throws 
	 */
	public void setListaMesas(ArrayList<Mesa> listaMesas) {
		this.listaMesas = listaMesas;
	}

	/**
	 * Borrar una mesa de la bbdd.
	 *
	 * @param Una mesa.
	 * @return true si el borrado se completó, false en caso contrario.
	 */
	public boolean delete(Mesa mesa) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("DELETE FROM mesas WHERE idMesa = " + mesa.getIdMesa() + "");
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
	 * Borrar una mesa de la bbdd.
	 *
	 * @param Una mesa.
	 * @return true si el borrado se completó, false en caso contrario.
	 */
	public boolean update(Mesa mesa) {
		boolean correcto = false;
		try {
			Agente.getAgente()
					.modificar("UPDATE mesas SET comensales=" + mesa.getComensales() + ", " + "estado='"
							+ mesa.getEstado() + "', horaEstado='" + mesa.getHoraEstado() + "' WHERE idMesa = "
							+ mesa.getIdMesa() + "");
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
	 * Borrar una mesa de la bbdd.
	 *
	 * @param Una mesa.
	 * @return true si el borrado se completó, false en caso contrario.
	 */
	public boolean insert(Mesa mesa) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("INSERT INTO mesas VALUES(" + mesa.getIdMesa() + "," + mesa.getComensales()
					+ ",'" + mesa.getEstado() + "','" + mesa.getHoraEstado() + "')");
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
	 * Borrar una mesa de la bbdd.
	 *
	 * @param Una mesa.
	 * @return true si el borrado se completó, false en caso contrario.
	 */
	public boolean read(Mesa mesa) {
		boolean correcto = false;
		ResultSet resultado;
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM mesas WHERE idmesa=" + mesa.getIdMesa() + "");
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
	 * Borrar una mesa de la bbdd.
	 *
	 * @return true si el borrado se completó, false en caso contrario.
	 */
	public boolean readAll() {
		ResultSet resultado;
		boolean correcto = false;
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM mesas ORDER BY idMesa");
			Mesa mesa;

			while (resultado.next()) {
				correcto = true;
				Estados estado = Estados.valueOf(resultado.getString(3));
				mesa = new Mesa(resultado.getInt(1), resultado.getInt(2), estado, resultado.getString(4));
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

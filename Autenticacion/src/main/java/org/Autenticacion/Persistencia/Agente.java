/**
 * Paquete que contiene las clases de persistencia del módulo autenticarse.
 **/
package org.Autenticacion.Persistencia;

import java.sql.*;

/**
 * Clase Agente. Utilizada para realizar la conexión y las distintas
 * interacciones con la base de datos. Solo podrá crearse un agente a la vez y
 * controlaremos esto mediante la instancia del agente se realizara la conexión
 * a la base de datos que estará contenida en un fichero access y se hará uso de
 * los drivers necesarios para su correcto funcionamiento.
 *
 * @author in4mates
 * @version 1.0
 */

public class Agente {
	/**
	 * Instancia del agente que se inicializará a nulo en un inicio.
	 **/
	protected static Agente mInstancia = null;
	/**
	 * Conexión a través de la cual se trabajará sobre la base de datos.
	 **/
	protected static Connection mBD;
	/**
	 * Dirección en la que se encuentra la base de datos sobre la que
	 * se trabaja.
	 **/
	private static String url = "jdbc:ucanaccess://in4mates.accdb";
	/**
	 * Driver que se utilizará para la conexión con la base de datos.
	 **/
	private static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";

	/**
	 * Constructor por defecto. Realiza la conexión a la base de datos.
	 * 
	 * @throws Exception .
	 */
	private Agente() throws Exception {
		conectar();

	}

	/**
	 * Constructor que creará y devolverá un agente en caso de que
	 * no exista uno previamente, si existe un agente con anterioridad
	 * se devolverá dicho agente.
	 * 
	 * @return Instancia del agente.
	 * @throws Exception .
	 */
	public static Agente getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new Agente();
		}
		return mInstancia;
	}

	/**
	 * Realiza la conexión con la base de datos mediante el uso del driver y
	 * de la
	 * url.
	 * 
	 * @throws Exception .
	 */
	private void conectar() throws Exception {
		Class.forName(driver);
		mBD = DriverManager.getConnection(url, "", "");
	}

	/**
	 * Realiza la desconexión con la base de datos.
	 * 
	 * @throws Exception .
	 */
	public void desconectar() throws Exception {
		mBD.close();
	}

	/**
	 * Comunica a la base de datos la consulta SQL de modificación que ha
	 * recibido el agente por parte del gestor.
	 * 
	 * @throws Exception .
	 * @throws SQLException .
	 * @param SQL (Consulta SQL de modificación sobre la base de datos).
	 * @return Resultado de la consulta SQL (si esta se ha
	 * realizado de manera correcta).
	 */
	public int modificar(String SQL) throws SQLException, Exception {
		Statement st = mBD.createStatement();
		int res = st.executeUpdate(SQL);
		st.close();
		return res;
	}

	/**
	 * Comunica a la base de datos la consulta SQL de lectura de datos que
	 * ha sido entregada al agente por el gestor.
	 * 
	 * @throws Exception .
	 * @throws SQLException .
	 * @param SQL (Consulta SQL de lectura de datos sobre la base de datos).
	 * @return Resultado de la consulta SQL (Datos obtenidos de la base de
	 * datos).
	 */
	public ResultSet leer(String SQL) throws SQLException, Exception {
		Statement st = mBD.createStatement();
		ResultSet resultado = st.executeQuery(SQL);
		return resultado;
	}

}

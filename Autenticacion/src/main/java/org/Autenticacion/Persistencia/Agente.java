/**
 * Paquete que contiene las clases de persistencia del modulo autenticarse.
 **/
package org.Autenticacion.Persistencia;

import java.awt.List;
import java.io.File;
import java.sql.*;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Clase Agente. Utilizada para realizar la conexion y las distintas interacciones con la base de datos.
 * Solo podra crearse un agente a la vez y controlaremos esto mediante la instancia del agente
 * se realizara la conexion a la base de datos que estara contenida en un fichero access
 * y se hara uso de los driveers necesarios para su correcto funcionamiento.
 *
 * @author in4mates
 * @version 1.0
 */

public class Agente {
	/**
	 * Instancia del agente que se inicializara a nulo en un inicio.
	 **/
    protected static Agente mInstancia = null;
    /**
	 * Conexion a traves de la cual se trabajara sobre la base de datos.
	 **/
    protected static Connection mBD;
    /**
	 * Direccion en la que se encuentra la base de datos sobre la que se trabaja.
	 **/
    private static String url = "jdbc:ucanaccess://in4mates.accdb";
    /**
	 * Driver que se utilizara para la conexion con la base de datos.
	 **/
    private static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";

	/**
	 * Constructor por defecto. Realiza la conexion a la base de datos.
	 * @throws Exception.
	 */
    private Agente() throws Exception {
        conectar();

    }

	/**
	 * Constructor que creara y devolvera un agente en caso de que no exista uno previamente, si existe un
	 * agente con anterioridad se devolvera dicho agente.
	 * @throws Exception.
	 * @return Instancia del agente.
	 */
    public static Agente getAgente() throws Exception {
    //	File miDir = new File (".");
    //	System.out.println(miDir.getCanonicalPath().toString());
        if (mInstancia == null) {
            mInstancia = new Agente();
        }
        return mInstancia;
    }
	/**
	 * Realiza la conexion con la base de datos mediante el uso del driver y de la url.
	 * @throws Exception.
	 */
    private void conectar() throws Exception {
        Class.forName(driver);
        mBD = DriverManager.getConnection(url, "", "");;
    }

	/**
	 * Realiza la desconexion con la base de datos.
	 * @throws Exception.
	 */
    public void desconectar() throws Exception {
        mBD.close();
    }

	/**
	 * Comunica a la base de datos la consulta SQL de modificacion que ha recibido el 
	 * agente por parte del gestor.
	 * @throws Exception, SQLException.
	 * @param String SQL (Consulta SQL de modificacion sobre la base de datos).
	 * @return Resultado de la consulta SQL (si esta se ha realizado de manera correcta).
	 */
    public int modificar(String SQL) throws SQLException, Exception {
      //  PreparedStatement stmt = mBD.prepareStatement(SQL);
        Statement st =mBD.createStatement();
     //   int res = stmt.executeUpdate();
        int res = st.executeUpdate(SQL);
        st.close();
     //   desconectar();
        return res;
    }

    /**
	 * Comunica a la base de datos la consulta SQL de lectura de datos que ha sido entregada al agente por
	 * el gestor.
	 * @throws Exception, SQLException.
	 * @param String SQL (Consulta SQL de lectura de datos sobre la base de datos).
	 * @return Resultado de la consulta SQL (Datos obtenidos de la base de datos).
	 */
    public ResultSet leer(String SQL) throws SQLException, Exception {
        
    	Statement st =mBD.createStatement();
        //  PreparedStatement stmt = mBD.prepareStatement(SQL);
         // ResultSet resultado = stmt.executeQuery(SQL);
      	ResultSet resultado = st.executeQuery(SQL);
      	
        return resultado;
    }
}
package org.Autenticacion.Persistencia;

import java.awt.List;
import java.io.File;
import java.sql.*;
import java.util.LinkedList;
import java.util.Vector;


public class Agente {

    protected static Agente mInstancia = null;
    protected static Connection mBD;
    private static String url = "jdbc:ucanaccess://in4mates.accdb";
    private static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";

    
    private Agente() throws Exception {
        conectar();

    }

    
    public static Agente getAgente() throws Exception {
    //	File miDir = new File (".");
    //	System.out.println(miDir.getCanonicalPath().toString());
        if (mInstancia == null) {
            mInstancia = new Agente();
        }
        return mInstancia;
    }

    private void conectar() throws Exception {
        Class.forName(driver);
        mBD = DriverManager.getConnection(url, "", "");;
    }

    
    public void desconectar() throws Exception {
        mBD.close();
    }

    
    public int modificar(String SQL) throws SQLException, Exception {
      //  PreparedStatement stmt = mBD.prepareStatement(SQL);
        Statement st =mBD.createStatement();
     //   int res = stmt.executeUpdate();
        int res = st.executeUpdate(SQL);
        st.close();
     //   desconectar();
        return res;
    }


    public ResultSet leer(String SQL) throws SQLException, Exception {
        
    	Statement st =mBD.createStatement();
        //  PreparedStatement stmt = mBD.prepareStatement(SQL);
         // ResultSet resultado = stmt.executeQuery(SQL);
      	ResultSet resultado = st.executeQuery(SQL);
      	
        return resultado;
    }
}
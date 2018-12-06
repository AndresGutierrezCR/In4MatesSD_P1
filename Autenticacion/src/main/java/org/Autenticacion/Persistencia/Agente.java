package org.Autenticacion.Persistencia;

import java.awt.List;
import java.sql.*;
import java.util.LinkedList;
import java.util.Vector;


public class Agente {

    protected static Agente mInstancia = null;
    protected static Connection mBD;
    private static String url = "jdbc:mysql://127.0.0.1:3306/in4mates";
    private static String driver = "com.mysql.jdbc.Driver";

    
    private Agente() throws Exception {
        conectar();

    }

    
    public static Agente getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new Agente();
        }
        return mInstancia;
    }

    private void conectar() throws Exception {
        Class.forName(driver);
        mBD = DriverManager.getConnection(url, "in4mates", "in4mates");;
    }

    
    public void desconectar() throws Exception {
        mBD.close();
    }

    
    public int modificar(String SQL) throws SQLException, Exception {
        PreparedStatement stmt = mBD.prepareStatement(SQL);
        int res = stmt.executeUpdate();
        stmt.close();
     //   desconectar();
        return res;
    }


    public ResultSet leer(String SQL) throws SQLException, Exception {
        

        PreparedStatement stmt = mBD.prepareStatement(SQL);
        ResultSet resultado = stmt.executeQuery(SQL);

        
        return resultado;
    }
}
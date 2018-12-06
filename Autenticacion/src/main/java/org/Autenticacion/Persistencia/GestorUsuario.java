package org.Autenticacion.Persistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.Autenticacion.Dominio.Usuario;



public class GestorUsuario {

	
	private ArrayList <Usuario> listaUsuarios;
	
	public GestorUsuario() {
		this.listaUsuarios=new ArrayList<Usuario>();
	}
	
	public ArrayList<Usuario> getListaUsuarios() {
		return this.listaUsuarios;
	}
	
	public boolean delete(Usuario usuario) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("DELETE FROM usuarios WHERE nombre = '"+usuario.getNombre()+"'");
			correcto=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			correcto=false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			correcto=false;
		}
		return correcto;
	}
	
	public boolean update(Usuario usuario) {
		boolean correcto = false;
		try {
			String SQL = "UPDATE usuarios SET nombre='"+usuario.getNombre()+"', "
					+ "pass='"+usuario.getPassword()+"',tipo='"+usuario.getTipo()+"'"
					+ " WHERE nombre = '"+usuario.getNombre()+"' AND pass='"+usuario.getPassword()+"'";
			Agente.getAgente().modificar(SQL);
			correcto=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			correcto=false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			correcto=false;
		}
		return correcto;
	}
	
	public boolean insert(Usuario usuario) {
		boolean correcto=false;
		try {
			Agente.getAgente().modificar("INSERT INTO usuarios VALUES ('"+usuario.getNombre()+"',"
					+ "'"+usuario.getPassword()+"','"+usuario.getTipo()+"')");
			correcto=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			correcto=false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			correcto=false;
		}
		return correcto;
	}

	
	public boolean login(Usuario usuario) {
		ResultSet resultado;
		boolean existe=false;
		try {
			resultado=Agente.getAgente().leer("SELECT * FROM usuarios WHERE nombre='"+usuario.getNombre()+"'"
					+ " AND pass='"+usuario.getPassword()+"'");
			
			while(resultado.next()) {
				existe=true;
				usuario.setNombre(resultado.getString(1));
				usuario.setPassword(resultado.getString(2));
				usuario.setTipo(resultado.getString(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			existe=false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			existe=false;
		}
		return existe;
	}
	
	public boolean readAll() {
	ResultSet resultado;
	boolean correcto = false;
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM usuarios");
			Usuario usuario;
			
			while (resultado.next()){
				correcto=true;
				usuario=new Usuario(resultado.getString(1),resultado.getString(2),resultado.getString(3));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			correcto=false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			correcto=false;
		}
		return correcto;
	}
	
}

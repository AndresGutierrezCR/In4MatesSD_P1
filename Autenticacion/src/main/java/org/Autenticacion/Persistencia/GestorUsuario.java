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
	
	public void delete(Usuario usuario) {
		try {
			Agente.getAgente().modificar("DELETE FROM usuarios WHERE nombre = '"+usuario.getNombre()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Usuario usuario) {
		try {
			Agente.getAgente().modificar("UPDATE usuarios SET nombre='"+usuario.getNombre()+"', "
					+ "pass='"+usuario.getPassword()+"', tipo='"+usuario.getTipo()+"'"
							+ " WHERE nombre = "+usuario.getNombre()+" AND pass='"+usuario.getPassword()+"' AND "
									+ "tipo='"+usuario.getTipo()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(Usuario usuario) {
		try {
			Agente.getAgente().modificar("INSERT INTO usuarios VALUES ('"+usuario.getNombre()+"',"
					+ "'"+usuario.getPassword()+"','"+usuario.getTipo()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public boolean read(Usuario usuario) {
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
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
	}
	
	public void readAll() {
	ResultSet resultado;
		
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM usuarios");
			Usuario usuario;
			
			while (resultado.next()){
				
				usuario=new Usuario(resultado.getString(1),resultado.getString(2),resultado.getString(3));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

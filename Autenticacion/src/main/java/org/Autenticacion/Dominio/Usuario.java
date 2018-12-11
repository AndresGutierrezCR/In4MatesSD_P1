package org.Autenticacion.Dominio;

import org.Autenticacion.Persistencia.GestorUsuario;

public class Usuario {

	private String nombre;
	private String password;
	private String tipo;
	
	private GestorUsuario gestorUsuario;
	
	public Usuario() {
		this.gestorUsuario = new GestorUsuario();
	}
	
	public Usuario(String nombre,String password,String tipo) throws Exception{
		if (nombre.length() < 1) {
			throw new Exception("El nombre no puede ser vacio");
		}
		if(password.length() < 1) {
			throw new Exception("La password no puede ser vacia");
		}
		if(tipo.length() < 1) {
			throw new Exception("El tipo no puede ser vacio");
		}
		this.gestorUsuario = new GestorUsuario();
		this.nombre = nombre;
		this.password = password;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {
		if(nombre.length() < 1) {
			throw new Exception("El usuario no puede ser vacio");
		}
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws Exception{
		if(password.length() < 1) {
			throw new Exception("La password no puede ser vacia");
		}
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo)throws Exception {
		if(tipo.length() < 1) {
			throw new Exception("El tipo no puede ser vacio");
		}
		this.tipo = tipo;
	}

	public GestorUsuario getGestorUsuario() {
		return gestorUsuario;
	}
	
	
	public boolean eliminar () {
		return gestorUsuario.delete(this);
	}
	
	public boolean autenticarse() {
		return gestorUsuario.login(this);
	}
	
	public boolean leerTodo() {
		return gestorUsuario.readAll();
	}
	
	public boolean modificar() {
		return gestorUsuario.update(this);
	}
	
	public boolean insertar() {
		return gestorUsuario.insert(this);
	}
}

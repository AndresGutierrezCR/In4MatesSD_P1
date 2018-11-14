package org.Autenticacion.Dominio;

import org.Autenticacion.Persistencia.GestorUsuario;

public class Usuario {

	private String nombre;
	private String password;
	private String tipo;
	
	private GestorUsuario gestorUsuario;
	
	public Usuario() {
		this.gestorUsuario=new GestorUsuario();
	}
	
	public Usuario(String nombre,String password,String tipo) {
		this.gestorUsuario= new GestorUsuario();
		this.nombre=nombre;
		this.password=password;
		this.tipo=tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public GestorUsuario getGestorUsuario() {
		return gestorUsuario;
	}
	
	
	
	
}

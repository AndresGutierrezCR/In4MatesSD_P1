package org.ReservaMesas.Dominio;

import org.ReservaMesas.Persistencia.GestorMesa;

public class Mesa {
	
	private int idMesa;
	private int comensales;
	private Estados estado;
	
	private GestorMesa gestorMesa;
	
	public Mesa() {
		this.gestorMesa= new GestorMesa();
	}
	
	public Mesa(int idMesa, int comensales, Estados estado) {
		this.idMesa=idMesa;
		this.comensales=comensales;
		this.estado=estado;
		this.gestorMesa= new GestorMesa();
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	
	
	public void eliminar() {
		gestorMesa.delete(this);
	}
	
	public void modificar() {
		gestorMesa.update(this);
	}
	
	public void insertar() {
		gestorMesa.insert(this);
	}
	
	public void leer() {
		gestorMesa.read(this);
	}
	
	public void leerTodo() {
		
	}
	

}

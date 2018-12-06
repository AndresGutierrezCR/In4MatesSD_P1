package org.ReservaMesas.Dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.ReservaMesas.Persistencia.GestorMesa;

public class Mesa {
	
	private int idMesa;
	private int comensales;
	private Estados estado;
	private String horaEstado;
	
	private GestorMesa gestorMesa;
	
	public Mesa() {
		this.gestorMesa= new GestorMesa();
	}
	
	public Mesa(int idMesa, int comensales, Estados estado,String horaEstado) throws Exception{
		
		if (idMesa < 1) {
			throw new Exception("El id mesa debe ser positivo");
		}
		if (comensales < 1) {
			throw new Exception("Los comensales deben ser positivos");
		}

			
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		formatoFecha.setLenient(false);
		formatoFecha.parse(horaEstado);
		
		this.idMesa=idMesa;
		this.comensales=comensales;
		this.estado=estado;
		this.horaEstado=horaEstado;
		this.gestorMesa= new GestorMesa();
	}

	public String getHoraEstado() {
		return horaEstado;
	}
	
	public void setHoraEstado(String horaEstado) throws ParseException {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		formatoFecha.setLenient(false);
		formatoFecha.parse(horaEstado);
		this.horaEstado=horaEstado;
	}
	
	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa)throws Exception {
		if (idMesa < 1) {
			throw new Exception("El id mesa debe ser positivo");
		}
		this.idMesa = idMesa;
	}

	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales)throws Exception {
		if (comensales < 1) {
			throw new Exception("Los comensales deben ser positivos");
		}
		this.comensales = comensales;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	public GestorMesa getGestorMesa() {
		return gestorMesa;
	}
	
	
	public boolean eliminar() {
		return gestorMesa.delete(this);
	}
	
	public boolean modificar() {
		return gestorMesa.update(this);
	}
	
	public boolean insertar() {
		return gestorMesa.insert(this);
	}
	
	public boolean leer() {
		return gestorMesa.read(this);
	}
	
	public boolean leerTodo() {
		return gestorMesa.readAll();
	}
	

}

package org.ReservaMesas.Dominio;

import org.ReservaMesas.Persistencia.GestorReserva;

public class Reserva {
	
	private int idReserva;
	private String nombreCliente;
	private int comensales;
	private String turnoComCen;
	private int turno;

	private Mesa mesa;
	private GestorReserva gestorReserva;

	public Reserva(int idReserva, String nombreCliente, int comensales, String turnoComCen, int turno, Mesa mesa) {
		
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.comensales = comensales;
		this.turnoComCen = turnoComCen;
		this.turno = turno;
		this.mesa = mesa;
		this.gestorReserva=new GestorReserva();
	}
	
	public Reserva() {
		this.gestorReserva=new GestorReserva();
	}
	
	public void asignarIDUltimo() {
		gestorReserva.lastID(this);
	}
	
	public void eliminar() {
		gestorReserva.delete(this);
	}
	
	public void modificar() {
		gestorReserva.update(this);
	}
	
	public void insertar() {
		gestorReserva.insert(this);
	}
	public void leer() {
		gestorReserva.read(this);
	}
	public void leerTodo() {
		gestorReserva.readAll();
	}
	
	public GestorReserva getGestorReserva() {
		return this.gestorReserva;
	}

	
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	public String getTurnoComCen() {
		return turnoComCen;
	}

	public void setTurnoComCen(String turnoComCen) {
		this.turnoComCen = turnoComCen;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	

}

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

	public Reserva(int idReserva, String nombreCliente, int comensales, String turnoComCen, int turno, Mesa mesa) throws Exception{
		
		if(idReserva < 1) {
			throw new Exception("El numero de reserva no puede ser negativo");
		}
		
		if(comensales > mesa.getComensales()) {
			throw new Exception("Superado numero maximo de comensales");
		}
		if(comensales <=  0 ) {
			throw new Exception("el numero de comensales debe ser positivo");
		}
		if (turno <= 0) {
			throw new Exception("Turno no valido");
		}
		
		if(nombreCliente.length()<1) {
			throw new Exception("Nombre de cliente no puede ser vacio");
		}
		if(turnoComCen.length()<1 ) {
			throw new Exception("Tunro Comdida/Cena no puede ser invalido");
		}
		if(!(turnoComCen.equals("comida") || turnoComCen.equals("cena"))){
			throw new Exception("No es un turno valido");
		}
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
	
	public boolean asignarIDUltimo() {
		return gestorReserva.lastID(this);
	}
	
	public boolean eliminar() {
		return gestorReserva.delete(this);
	}
	
	public boolean modificar() {
		return gestorReserva.update(this);
	}
	
	public boolean insertar() {
		return gestorReserva.insert(this);
	}
	public boolean leer() {
		return gestorReserva.read(this);
	}
	public boolean leerTodo() {
		return gestorReserva.readAll();
	}
	
	public GestorReserva getGestorReserva() {
		return this.gestorReserva;
	}

	
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva)throws Exception {
		if(idReserva < 1) {
			throw new Exception("El numero de reserva no puede ser negativo");
		}
		this.idReserva = idReserva;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente)throws Exception {
		if(nombreCliente.length()<1) {
			throw new Exception("Nombre de cliente no puede ser vacio");
		}
		this.nombreCliente = nombreCliente;
	}

	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales) throws Exception{
		if(comensales> this.mesa.getComensales()) {
			throw new Exception("Superado numero de comensales");
		}
		if(comensales <= 0) {
			throw new Exception("Numero de comensales no valido");
		}
		this.comensales = comensales;
	}

	public String getTurnoComCen() {
		
		return turnoComCen;
	}

	public void setTurnoComCen(String turnoComCen) throws Exception {
		if(turnoComCen.length()<1 ) {
			throw new Exception("Tunro Comdida/Cena no puede ser invalido");
		}
		if(!(turnoComCen.equals("comida") || turnoComCen.equals("cena"))){
			throw new Exception("No es un turno valido");
		}
		this.turnoComCen = turnoComCen;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) throws Exception{
		if (turno < 0) {
			throw new Exception("Turno no valido");
		}
		this.turno = turno;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	

}

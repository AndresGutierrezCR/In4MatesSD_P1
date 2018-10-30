package org.ReservaMesas.Persistencia;

import java.util.ArrayList;

import org.ReservaMesas.Dominio.Mesa;

public class GestorMesa {
	
	private ArrayList <Mesa> listaMesas;
	
	public GestorMesa() {
		listaMesas=new ArrayList <Mesa>();
	}

	public ArrayList<Mesa> getListaMesas() {
		return listaMesas;
	}

	public void setListaMesas(ArrayList<Mesa> listaMesas) {
		this.listaMesas = listaMesas;
	}
	
	public void delete(Mesa mesa) {
		
	}
	
	public void update(Mesa mesa) {
		
	}
	
	public void insert(Mesa mesa) {
		
	}
	
	public void read(Mesa mesa) {
		
	}
	
	public void readAll() {
		
	}

}

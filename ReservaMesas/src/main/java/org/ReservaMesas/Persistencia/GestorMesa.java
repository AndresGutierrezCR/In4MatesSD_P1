package org.ReservaMesas.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.Autenticacion.Persistencia.Agente;
import org.ReservaMesas.Dominio.Estados;
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
		try {
			Agente.getAgente().modificar("DELETE FROM mesas WHERE idMesa = "+mesa.getIdMesa()+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Mesa mesa) {
		try {
			Agente.getAgente().modificar("UPDATE mesas SET comensales="+mesa.getComensales()+", "
					+ "estado='"+mesa.getEstado()+"', horaEstado='"+mesa.getHoraEstado()+"' WHERE idMesa = "+mesa.getIdMesa()+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(Mesa mesa) {
		try {
			Agente.getAgente().modificar("INSERT INTO mesas VALUES("+mesa.getIdMesa()+","+mesa.getComensales()+
					",'"+mesa.getEstado()+"','"+mesa.getHoraEstado()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void read(Mesa mesa) {
		ResultSet resultado;
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM mesas WHERE idmesa="+mesa.getIdMesa()+"");
			while(resultado.next()) {
				mesa.setComensales(resultado.getInt(2));
				Estados estado=Estados.valueOf(resultado.getString(3));
				mesa.setEstado(estado);
				mesa.setHoraEstado(resultado.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void readAll() {
		ResultSet resultado;
		
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM mesas ORDER BY idMesa");
			Mesa mesa;
			
			while (resultado.next()){
				
				Estados estado=Estados.valueOf(resultado.getString(3));
				mesa=new Mesa(resultado.getInt(1),resultado.getInt(2),estado,resultado.getString(4));
				listaMesas.add(mesa);
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

package org.ReservaMesas.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;
import org.ReservaMesas.Dominio.Reserva;

public class GestorReserva {
private ArrayList <Reserva> listaReserva;
	
	public GestorReserva() {
		listaReserva=new ArrayList <Reserva>();
	}

	public ArrayList<Reserva> getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(ArrayList<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}
	
	public void delete(Reserva reserva) {
		try {
			Agente.getAgente().modificar("DELETE FROM reserva WHERE idReserva = "+reserva.getIdReserva()+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Reserva reserva) {
		try {
			Agente.getAgente().modificar("UPDATE reserva SET nombrecliente='"+reserva.getNombreCliente()+"', "
					+ "comensales="+reserva.getComensales()+", turnocomcen ='"+reserva.getTurnoComCen()+"'"
							+ ", turno="+reserva.getTurno()+", idMesa="+reserva.getMesa().getIdMesa()+" WHERE idReserva = "+reserva.getIdReserva()+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(Reserva reserva) {
		try {
			Agente.getAgente().modificar("INSERT INTO reserva VALUES("+reserva.getIdReserva()+",'"+reserva.getNombreCliente()+
					"',"+reserva.getComensales()+",'"+reserva.getTurnoComCen()+"',"+
					reserva.getTurno()+","+reserva.getMesa().getIdMesa()+");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void read(Reserva reserva) {
		ResultSet resultado;
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM mesas WHERE idmesa="+mesa.getIdMesa()+";");
			while(resultado.next()) {
				mesa.setComensales(resultado.getInt(2));
				Estados estado=Estados.valueOf(resultado.getString(3));
				mesa.setEstado(estado);
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
			Reserva reserva;
			
			while (resultado.next()){
				
				reserva=new Reserva(resultado.getInt(1),resultado.getInt(2),estado);
				listaReserva.add(reserva);
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

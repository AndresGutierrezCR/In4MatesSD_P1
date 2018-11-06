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
			resultado = Agente.getAgente().leer("SELECT * FROM reserva WHERE idReserva="+reserva.getIdReserva()+";");
			while(resultado.next()) {
				
				reserva.setNombreCliente(resultado.getString(2));
				reserva.setComensales(resultado.getInt(3));
				reserva.setTurnoComCen(resultado.getString(4));
				reserva.setTurno(resultado.getInt(5));
				
				Mesa m = new Mesa();
				m.setIdMesa(resultado.getInt(6));
				
				m.leer();
				
				reserva.setMesa(m);
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
			resultado = Agente.getAgente().leer("SELECT * FROM reserva ORDER BY idReserva");
			Reserva reserva;
			
			while (resultado.next()){
				Mesa m = new Mesa();
				m.setIdMesa(resultado.getInt(6));
				reserva=new Reserva(resultado.getInt(1),resultado.getString(2),resultado.getInt(3),
						resultado.getString(4),resultado.getInt(5),m);
				
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

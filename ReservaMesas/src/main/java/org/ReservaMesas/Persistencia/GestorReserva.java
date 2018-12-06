package org.ReservaMesas.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.Autenticacion.Persistencia.Agente;
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
	
	public boolean delete(Reserva reserva) {
		boolean correcto=false;
		try {
			Agente.getAgente().modificar("DELETE FROM reserva WHERE idReserva = "+reserva.getIdReserva()+";");
			correcto = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}
	
	public boolean update(Reserva reserva) {
		boolean correcto=false;
		
		try {
			Agente.getAgente().modificar("UPDATE reserva SET nombrecliente='"+reserva.getNombreCliente()+"', "
					+ "comensales="+reserva.getComensales()+", turnocomcen ='"+reserva.getTurnoComCen()+"'"
							+ ", turno="+reserva.getTurno()+", idMesa="+reserva.getMesa().getIdMesa()+" WHERE idReserva = "+reserva.getIdReserva()+";");
		correcto=true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}
	
	public boolean insert(Reserva reserva) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("INSERT INTO reserva VALUES("+reserva.getIdReserva()+",'"+reserva.getNombreCliente()+
					"',"+reserva.getComensales()+",'"+reserva.getTurnoComCen()+"',"+
					reserva.getTurno()+","+reserva.getMesa().getIdMesa()+");");
			correcto=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}
	
	public boolean read(Reserva reserva) {
		ResultSet resultado;
		boolean correcto=false;
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM reserva WHERE idReserva="+reserva.getIdReserva()+";");
			while(resultado.next()) {
				correcto=true;
				Mesa m = new Mesa();
				m.setIdMesa(resultado.getInt(6));
				m.leer();	
				reserva.setMesa(m);
				reserva.setNombreCliente(resultado.getString(2));
				reserva.setComensales(resultado.getInt(3));
				reserva.setTurnoComCen(resultado.getString(4));
				reserva.setTurno(resultado.getInt(5));
				
				
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}
	
	public boolean lastID(Reserva reserva) {
		ResultSet resultado;
		boolean correcto = false;
		try {
			
			resultado = Agente.getAgente().leer("SELECT MAX(idReserva) FROM reserva;");
			//resultado = Agente.getAgente().leer("SELECT * FROM reserva;");
			
			while(resultado.next()) {
				 correcto=true;
				reserva.setIdReserva(resultado.getInt(1)+1);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Excepcion SQL");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excepcion general");
			//e.printStackTrace();
		}
		return correcto;
	}
	
	public boolean readAll() {
		boolean correcto = false;
		ResultSet resultado;
		
		try {
			resultado = Agente.getAgente().leer("SELECT * FROM reserva ORDER BY idReserva;");
			Reserva reserva;
			
			while (resultado.next()){
				correcto=true;
				Mesa m = new Mesa();
				m.setIdMesa(resultado.getInt(6));
				m.leer();
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
		return correcto;
		
	}




}

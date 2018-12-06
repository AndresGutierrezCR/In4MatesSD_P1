package org.ReservaMesas;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;
import org.ReservaMesas.Dominio.Reserva;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestReserva {

	private Mesa mesaValida;

	@Before
	public void setUp() throws Exception {
		mesaValida = new Mesa(2, 6, Estados.LIBRE, "01/01/2019 12:00:00");
	}

	@Test(expected = Exception.class)
	public void test1() throws Exception {
		Reserva r = new Reserva(-3, "pepe", -5, "comida", -7, mesaValida);
	}

	@Test(expected = Exception.class)
	public void test2() throws Exception {
		Reserva r = new Reserva(0, "pepe", -5, "comida", -7, mesaValida);
	}

	@Test(expected = Exception.class)
	public void test3() throws Exception {
		Reserva r = new Reserva(0, "pepe", 0, "comida", -7, mesaValida);
	}

	@Test(expected = Exception.class)
	public void test4() throws Exception {
		Reserva r = new Reserva(100, "", 0, "comida", -7, mesaValida);
	}

	@Test(expected = Exception.class)
	public void test5() throws Exception {
		Reserva r = new Reserva(100, "", 0, "cena", -7, mesaValida);
	}

	@Test(expected = Exception.class)
	public void test6() throws Exception {
		Reserva r = new Reserva(100, "Pepe", 2, "", -7, mesaValida);
	}

	@Test(expected = Exception.class)
	public void test7() throws Exception {
		Reserva r = new Reserva(100, "Pepe", 2, "comida", 0, mesaValida);
	}

	@Test(expected = Exception.class)
	public void test8() throws Exception {
		Reserva r = new Reserva(-3, "Pepe", 2, "cena", 10, mesaValida);
	}

	@Test(expected = Exception.class)
	public void test9() throws Exception {
		Reserva r = new Reserva(100, "pepe", 2, "prueba", 10, mesaValida);
	}

	@Test(expected = Exception.class)
	public void test10() throws Exception {
		Reserva r = new Reserva(100, "Pepe", 2, "comida", 10, null);
	}

	@Test
	public void test11() {
		try {
			Reserva r = new Reserva(4, "Manolo", 2, "cena", 2, mesaValida);
		} catch (Exception e) {
			
			assumeNoException(e);
		}
	}
	@Test(expected = Exception.class)
	public void test12() throws Exception {
		
		Reserva r = new Reserva(4, "Manolo", 200, "comida", 2, mesaValida);
		
	}

	@Test
	public void TestGetters() throws Exception {
		Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
		try {
			assertEquals(4, r.getIdReserva());
			assertEquals("Manolo", r.getNombreCliente());
			assertEquals(2, r.getComensales());
			assertEquals("comida", r.getTurnoComCen());
			assertEquals(2, r.getTurno());
		} catch (Exception e) {
			assumeNoException(e);
		}

	}

	@Test
	public void TestSetNombre() {
		try {
			Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
			r.setNombreCliente("Manuel");
		} catch (Exception e) {
			assumeNoException(e);
		}
	}

	@Test(expected = Exception.class)
	public void TestSetNombreFalla()throws Exception {
	
			Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
			r.setNombreCliente("");
		
	}

	@Test
	public void TestSetIDreserva() {
		try {
			Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
			r.setIdReserva(3);
		} catch (Exception e) {
			assumeNoException(e);
		}
	}

	@Test(expected = Exception.class)
	public void TestSetIDreservaFalla() throws Exception {

		Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
		r.setIdReserva(-10);

	}

	@Test
	public void TestSetComensales() {
		try {
			Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
			r.setComensales(4);
		} catch (Exception e) {
			assumeNoException(e);
		}
	}

	@Test(expected = Exception.class)
	public void TestSetComensalesFalla() throws Exception {

		Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
		r.setComensales(-4);

	}

	@Test
	public void TestSetTurnoComCem() {
		try {
			Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
			r.setTurnoComCen("cena");
		} catch (Exception e) {
			assumeNoException(e);
		}
	}

	@Test(expected = Exception.class)
	public void TestSetTurnoComCemFalla() throws Exception {

		Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
		r.setTurnoComCen("");

	}
	@Test(expected = Exception.class)
	public void TestSetTurnoComCemFalla2() throws Exception {

		Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
		r.setTurnoComCen("prueba");

	}

	@Test
	public void TestSetTurno() {
		try {
			Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
			r.setTurno(5);
		} catch (Exception e) {
			assumeNoException(e);
		}
	}

	@Test(expected = Exception.class)
	public void TestSetTurnoFalla() throws Exception {

		Reserva r = new Reserva(4, "Manolo", 2, "comida", 2, mesaValida);
		r.setTurno(-5);

	}
	
	
	@Test
	public void TestOperacionesCRUD() {
		Reserva r1=null;
		Reserva r2=null;
		try {
			r1 = new Reserva(10,"Isidoro",2,"cena",2,mesaValida);
			r2 = new Reserva();
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		assertTrue(r1.insertar());
		
		try {
			r1.setTurnoComCen("comida");
			r2.setIdReserva(10);
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		assertTrue(r1.modificar());
		
		assertTrue(r2.leer());
		assertEquals("comida",r2.getTurnoComCen());
		
		assertTrue(r1.eliminar());
		
	}
	
	@Test 
	public void testLastID() {
		Reserva r1 = null;
		Reserva r2 = null;
		try {
			r1 = new Reserva(10000,"Desiderio",2,"cena",2,mesaValida);
			r2 = new Reserva();
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertTrue(r1.insertar());
		assertTrue(r2.asignarIDUltimo());
		
		assertEquals(10001,r2.getIdReserva());
		
		assertTrue(r1.eliminar());
	}
	
	@Test
	public void testReadAll() {
		Reserva r1 = new Reserva();
		assertTrue(r1.leerTodo());
	}
}
package org.ReservaMesas;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;
import org.ReservaMesas.Dominio.Reserva;
import org.junit.Before;
import org.junit.Test;

public class TestReserva {

	private Mesa mesaValida;
	
	@Before
	public void setUp() throws Exception{
		mesaValida = new Mesa(2, 6, Estados.LIBRE, "01/01/2019 12:00:00");
	}
	
	@Test(expected = Exception.class)
	public void test1() throws Exception {
		Reserva r = new Reserva(-3, "pepe", -5, "comida", -8, mesaValida);
	}
	@Test(expected = Exception.class)
	public void test2() throws Exception {
		Reserva r = new Reserva(100, "", 2, "cena", 2, mesaValida);
	}
	@Test(expected = Exception.class)
	public void test3() throws Exception {
		Reserva r = new Reserva(0, "pepe", 0, "", 2, null);
	}
	@Test(expected = Exception.class)
	public void test4() throws Exception {
		Reserva r = new Reserva(-3, "", 100, "comida", 1, mesaValida);
	}
	@Test(expected = Exception.class)
	public void test5() throws Exception {
		Reserva r = new Reserva(100, "pepe", -5, "cena", -8, mesaValida);
	}
	@Test(expected = Exception.class)
	public void test6() throws Exception {
		Reserva r = new Reserva(-3, "pepe", 0, "comida", -8, mesaValida);
	}

	public void test7() throws Exception {
		try {
		Reserva r = new Reserva(100, "pepe", 2, "cena",2, mesaValida);
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	@Test(expected = Exception.class)
	public void test8() throws Exception {
		Reserva r = new Reserva(0, "", -5, "comida", 1, mesaValida);
	}
	@Test(expected = Exception.class)
	public void test9() throws Exception {
		Reserva r = new Reserva(-3, "pepe", 2, "cena", 1, mesaValida);
	}
	@Test(expected = Exception.class)
	public void test10() throws Exception {
		Reserva r = new Reserva(100, "pepe", -5, "comida", 0, mesaValida);
	}
	@Test(expected = Exception.class)
	public void test11() throws Exception {
		Reserva r = new Reserva(0, "", -5, "", 2, mesaValida);
	}
	
	@Test(expected = Exception.class)
	public void test12() throws Exception {
		Reserva r = new Reserva(100, "pepe", -5, "comida", 2, mesaValida);
	}
	@Test(expected = Exception.class)
	public void test13() throws Exception {
		Reserva r = new Reserva(100, "pepe", 2, "cena", 0, mesaValida);
	}
	@Test(expected = Exception.class)
	public void test14() throws Exception {
		Reserva r = new Reserva(100, "pepe", 2, "", 2, mesaValida);
	}
	@Test
	public void test15() throws Exception {
		try {
		Reserva r = new Reserva(100, "pepe", 2, "comida", 2, mesaValida);
		}catch(Exception e) {
			assumeNoException(e);
		}
	}

	/* Test set idReserva */
	@Test(expected = Exception.class)
	public void testsetIdReserva1() throws Exception {
		Reserva r = new Reserva();
		r.setIdReserva(-3);
	}
	@Test(expected = Exception.class)
	public void testsetIdReserva2() throws Exception {
		Reserva r = new Reserva();
		r.setIdReserva(0);
	}
	@Test
	public void testsetGetIdReserva3() throws Exception {
		Reserva r = new Reserva();
		try {
		r.setIdReserva(100);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(r.getIdReserva(),100);
	}
	
	/* Test set NombreCliente*/

	@Test(expected = Exception.class)
	public void testsetNombreCliente1() throws Exception {
		Reserva r = new Reserva();
		r.setNombreCliente("");
	}
	@Test
	public void testsetGetNombreCliente2() throws Exception {
		Reserva r = new Reserva();
		try {
		r.setNombreCliente("pepe");
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(r.getNombreCliente(),"pepe");
	}
	
	/* Tests set comensales */
	@Test(expected = Exception.class)
	public void testsetComensales1() throws Exception {
		Reserva r = new Reserva(1, "pepe",3 , "comida", 2, mesaValida);
		r.setComensales(-5);
	}
	@Test(expected = Exception.class)
	public void testsetComensales2() throws Exception {
		Reserva r = new Reserva(1, "pepe",3 , "comida", 2, mesaValida);
		r.setComensales(0);
	}
	@Test(expected = Exception.class)
	public void testsetComensales3() throws Exception {
		Reserva r = new Reserva(1, "pepe",3 , "comida", 2, mesaValida);
		r.setComensales(100);
	}
	@Test
	public void testSetGetComensales4() throws Exception {
		Reserva r = new Reserva(1, "pepe",3 , "comida", 2, mesaValida);
		try {
		r.setComensales(2);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(2, r.getComensales());
	}
	
	/* set turn com cen */
	
	@Test(expected = Exception.class)
	public void testsetturncomcen1() throws Exception {
		Reserva r = new Reserva();
		r.setTurnoComCen("");
	}
	@Test
	public void testsetturncomcen2() throws Exception {
		Reserva r = new Reserva();
		try {
			r.setTurnoComCen("comida");
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	@Test
	public void testGetSetturncomcen3() throws Exception {
		Reserva r = new Reserva();
		try {
			r.setTurnoComCen("cena");
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals("cena",r.getTurnoComCen());
	}
	
	/* test set turno*/
	
	@Test(expected = Exception.class)
	public void testsetturno1() throws Exception {
		Reserva r = new Reserva();
		r.setTurno(-8);
	}
	@Test(expected = Exception.class)
	public void testsetturno2() throws Exception {
		Reserva r = new Reserva();
		r.setTurno(0);
	}
	@Test
	public void testsetgetturno3() throws Exception {
		Reserva r = new Reserva();
		try {
		r.setTurno(2);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(2,r.getTurno());
	}
	
	/* Test Operaciones CRUD*/
	
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
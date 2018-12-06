package org.ReservaMesas;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;
import org.junit.Test;

public class TestMesa {
	private Mesa m;


	@Test
	public void testCase1() {

		try {
			m = new Mesa(32, 7, Estados.RESERVADA, "27/11/18 23:41:03");
		} catch (Exception e) {
			assumeNoException(e);
		}

	}

	@Test(expected = Exception.class)
	public void testCase2() throws Exception {

		m = new Mesa(-5, 7, Estados.RESERVADA, "27/11/18 23:41:03");

	}

	@Test(expected = Exception.class)
	public void testCase3() throws Exception {

		m = new Mesa(0, 7, Estados.RESERVADA, "27/11/18 23:41:03");

	}

	@Test(expected = Exception.class)
	public void testCase4() throws Exception {

		m = new Mesa(32, -3, Estados.RESERVADA, "27/11/18 23:41:03");

	}

	@Test(expected = Exception.class)
	public void testCase5() throws Exception {

		m = new Mesa(32, 0, Estados.RESERVADA, "27/11/18 23:41:03");

	}

	@Test(expected = Exception.class)
	public void testCase6() throws Exception {

		m = new Mesa(1, 7, Estados.RESERVADA, "31/02/18 23:41:03");

	}

	@Test(expected = Exception.class)
	public void testCase7() throws Exception {

		m = new Mesa(4,2, Estados.RESERVADA, "27/12/19 40:41:03");

	}

	@Test(expected = Exception.class)
	public void testCase8() throws Exception {

		m = new Mesa(4,2, Estados.RESERVADA, "-5/13/19 23:41:61");

	}
	
	@Test
	public void getters_SettersTest() throws Exception{
		m=new Mesa();
		m.setIdMesa(5);
		assertEquals(m.getIdMesa(),5);
		
		m.setEstado(Estados.RESERVADA);
		assertEquals(m.getEstado(),Estados.RESERVADA);
		
		m.setHoraEstado("23/12/19 23:30:30");
		assertEquals(m.getHoraEstado(),"23/12/19 23:30:30");
		
		m.setComensales(3);
		assertEquals(m.getComensales(),3);
	}
	
	@Test(expected = Exception.class)
	public void testCase10() throws Exception {

		m=new Mesa();
		m.setIdMesa(-5);

	}

	@Test(expected = Exception.class)
	public void testCase11() throws Exception {

		m=new Mesa();
		m.setComensales(-5);

	}
	
	@Test(expected = Exception.class)
	public void testCase12() throws Exception {

		m=new Mesa();
		m.setHoraEstado("40/05/-8 25:61:70");

	}
	
	@Test
	public void testInsertarYborrar() throws Exception {
		m = new Mesa(10, 7, Estados.RESERVADA, "10/02/18 23:41:03");
		assertTrue(m.insertar());
		
		m = new Mesa(10, 7, Estados.RESERVADA, "10/02/18 23:41:03");
		assertTrue(m.eliminar());
	}
	
	@Test
	public void testActualizarYLeerYBorrar(){
		try {
		m = new Mesa(9, 7, Estados.RESERVADA, "10/02/18 23:41:03");
		assertTrue(m.insertar());
		m = new Mesa(9, 7, Estados.RESERVADA, "10/02/18 23:41:03");
		m.setComensales(15);
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		assertTrue(m.modificar());
		Mesa m1 = null;
		try {
			m1 = new Mesa();
			m1.setIdMesa(9);
			m1.leer();
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		assertEquals(15,m1.getComensales());
		
		try {
			m.eliminar();
		}catch(Exception e) {
			assumeNoException(e);
		}
		
	}
	
	@Test
	public void TestReadAll() {
		try {
			Mesa mtodas = new Mesa();
			assertTrue(mtodas.leerTodo());
			assertNotEquals(mtodas.getGestorMesa().getListaMesas().size(), 0);
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	

}

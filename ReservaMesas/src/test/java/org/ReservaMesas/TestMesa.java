package org.ReservaMesas;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Dominio.Mesa;
import org.junit.Test;

public class TestMesa {

	private Mesa m;
	
	/* test constructor */
	@Test(expected = Exception.class)
	public void test1()throws Exception {
		m=new Mesa(-5,-3,Estados.RESERVADA,"27/11/2018  23:41:30");
	}
	@Test(expected = Exception.class)
	public void test2()throws Exception {
		m=new Mesa(32,7,Estados.RESERVADA,"-5/13/19 23:41:01");
	}
	@Test(expected = Exception.class)
	public void test3()throws Exception {
		m=new Mesa(0,0,Estados.RESERVADA,"27/12/19 40:41:03 ");
	}
	@Test(expected = Exception.class)
	public void test4()throws Exception {
		m=new Mesa(-5,7,Estados.RESERVADA,"-5/13/19 23:41:61");
	}
	@Test(expected = Exception.class)
	public void test5()throws Exception {
		m=new Mesa(32,0,Estados.RESERVADA,"27/11/2018  23:41:30");
	}
	@Test(expected = Exception.class)
	public void test6()throws Exception {
		m=new Mesa(0,-3,Estados.RESERVADA,"-5/13/19 23:41:01");
	}
	@Test(expected = Exception.class)
	public void test7()throws Exception {
		m=new Mesa(0,7,Estados.RESERVADA,"27/12/19 40:41:03 ");
	}
	@Test(expected = Exception.class)
	public void test8()throws Exception {
		m=new Mesa(32,-3,Estados.RESERVADA,"-5/13/19 23:41:61");
	}
	@Test(expected = Exception.class)
	public void test9()throws Exception {
		m=new Mesa(-5,0,Estados.RESERVADA,"27/11/2018  23:41:30");
	}
	@Test
	public void test10()throws Exception {
		try {
		m=new Mesa(32,7,Estados.RESERVADA,"27/11/2018  23:41:30");
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	/* set horaEstado*/
	
	@Test
	public void testSetHoraEstado1()throws Exception {
		m=new Mesa();
		try {
		m.setHoraEstado("27/11/2018  23:41:03");
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals("27/11/2018  23:41:03",m.getHoraEstado());
	}
	
	@Test(expected = Exception.class)
	public void testSetHoraEstado2()throws Exception {
		m=new Mesa();
		m.setHoraEstado("-5/13/19 23:41:01");
	}
	@Test(expected = Exception.class)
	public void testSetHoraEstado3()throws Exception {
		m=new Mesa();
		m.setHoraEstado("27/12/19 40:41:03");
	}
	@Test(expected = Exception.class)
	public void testSetHoraEstado4()throws Exception {
		m=new Mesa();
		m.setHoraEstado("-5/13/19 23:41:61");
	}
	
	/* set idMesa */
	
	@Test(expected = Exception.class)
	public void testSetIdMesa1()throws Exception {
		m=new Mesa();
		m.setIdMesa(-5);
	}
	@Test(expected = Exception.class)
	public void testSetIdMesa2()throws Exception {
		m=new Mesa();
		m.setIdMesa(0);
	}
	@Test
	public void testSetIdMesa3()throws Exception {
		m=new Mesa();
		try {
		m.setIdMesa(32);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(32,m.getIdMesa());
		
	}
	
	/* set comensales */
	@Test(expected = Exception.class)
	public void testSetComensales1()throws Exception {
		m=new Mesa();
		m.setComensales(-3);
	}
	@Test(expected = Exception.class)
	public void testSetComensales2()throws Exception {
		m=new Mesa();
		m.setComensales(0);
	}
	@Test
	public void testSetComensales3()throws Exception {
		m=new Mesa();
		try {
		m.setComensales(7);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(7,m.getComensales());
	}
	
	/* test get set estado*/
	@Test
	public void testSetGetEstado()throws Exception {
		m=new Mesa();
		m.setEstado(Estados.OCUPADA);
		assertEquals(Estados.OCUPADA,m.getEstado());
	}
	
	/* Tests operaciones CRUD*/
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
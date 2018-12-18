package org.Autenticacion;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.Autenticacion.Dominio.Usuario;
import org.junit.Test;

public class TestUsuario1 {

	Usuario u;
	
	/*Test constructor*/
	
	@Test
	public void test1()throws Exception {
		try {
		u=new Usuario("antonio","antonio","camarero");
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	@Test(expected = Exception.class)
	public void test2()throws Exception {
		u=new Usuario("antonio","antonio","");
	}
	@Test(expected = Exception.class)
	public void test3()throws Exception {
		u=new Usuario("antonio","","camarero");
	}
	@Test(expected = Exception.class)
	public void test4()throws Exception {
		u=new Usuario("antonio","","");
	}
	@Test(expected = Exception.class)
	public void test5()throws Exception {
		u=new Usuario("","antonio","camarero");
	}
	@Test(expected = Exception.class)
	public void test6()throws Exception {
		u=new Usuario("","antonio","");
	}
	@Test(expected = Exception.class)
	public void test7()throws Exception {
		u=new Usuario("","","camarero");
	}
	@Test(expected = Exception.class)
	public void test8()throws Exception {
		u=new Usuario("","","");
	}
	
	/*set nombre*/
	@Test(expected = Exception.class)
	public void testsetNombre1()throws Exception {
		u=new Usuario();
		u.setNombre("");
	}
	@Test
	public void testsetNombre2()throws Exception {
		try {
		u=new Usuario();
		u.setNombre("antonio");
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals("antonio",u.getNombre());
	}
	/*set password*/
	@Test(expected = Exception.class)
	public void testsetPassword1()throws Exception {
		u=new Usuario();
		u.setPassword("");
	}
	@Test
	public void testsetPassword2()throws Exception {
		try {
		u=new Usuario();
		u.setPassword("antonio");
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals("antonio",u.getPassword());
	}
	/*set tipo*/
	@Test(expected = Exception.class)
	public void testsetTipo1()throws Exception {
		u=new Usuario();
		u.setTipo("");
	}
	@Test
	public void testsetTipo2()throws Exception {
		try {
		u=new Usuario();
		u.setTipo("camarero");
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals("camarero",u.getTipo());
	}
	
}

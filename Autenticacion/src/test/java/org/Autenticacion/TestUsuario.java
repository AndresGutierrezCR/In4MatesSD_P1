package org.Autenticacion;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.Autenticacion.Dominio.Usuario;
import org.junit.Test;

public class TestUsuario {

	Usuario u;

	/* Test constructor */

	@Test
	public void test1() throws Exception {
		try {
			u = new Usuario("antonio", "antonio", "camarero");
		} catch (Exception e) {
			assumeNoException(e);
		}
	}

	@Test(expected = Exception.class)
	public void test2() throws Exception {
		u = new Usuario("antonio", "antonio", "");
	}

	@Test(expected = Exception.class)
	public void test3() throws Exception {
		u = new Usuario("antonio", "", "camarero");
	}

	@Test(expected = Exception.class)
	public void test4() throws Exception {
		u = new Usuario("antonio", "", "");
	}

	@Test(expected = Exception.class)
	public void test5() throws Exception {
		u = new Usuario("", "antonio", "camarero");
	}

	@Test(expected = Exception.class)
	public void test6() throws Exception {
		u = new Usuario("", "antonio", "");
	}

	@Test(expected = Exception.class)
	public void test7() throws Exception {
		u = new Usuario("", "", "camarero");
	}

	@Test(expected = Exception.class)
	public void test8() throws Exception {
		u = new Usuario("", "", "");
	}

	/* set nombre */
	@Test(expected = Exception.class)
	public void testsetNombre1() throws Exception {
		u = new Usuario();
		u.setNombre("");
	}

	@Test
	public void testsetNombre2() throws Exception {
		try {
			u = new Usuario();
			u.setNombre("antonio");
		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals("antonio", u.getNombre());
	}

	/* set password */
	@Test(expected = Exception.class)
	public void testsetPassword1() throws Exception {
		u = new Usuario();
		u.setPassword("");
	}

	@Test
	public void testsetPassword2() throws Exception {
		try {
			u = new Usuario();
			u.setPassword("antonio");
		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals("antonio", u.getPassword());
	}

	/* set tipo */
	@Test(expected = Exception.class)
	public void testsetTipo1() throws Exception {
		u = new Usuario();
		u.setTipo("");
	}

	@Test
	public void testsetTipo2() throws Exception {
		try {
			u = new Usuario();
			u.setTipo("camarero");
		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals("camarero", u.getTipo());
	}

	@Test
	public void testAutenticarse() throws Exception {
		Usuario usuarioExiste = new Usuario("in4mates", "in4mates",
				"jefe de sala");
		Usuario usuarioNoExiste = new Usuario("pepe", "pepe", "camarerp");
		assertTrue(usuarioExiste.autenticarse());
		assertFalse(usuarioNoExiste.autenticarse());
	}

	@Test
	public void testInsertarBorrarYModifiarUsuario() throws Exception {
		Usuario u1 = new Usuario("pepe", "pepe", "jefe de sala");
		assertTrue(u1.insertar());
		u1.setTipo("camarero");
		assertTrue(u1.modificar());

		/* Comprobamos que la modificacion es correcta */

		Usuario u2 = new Usuario();
		u2.setNombre("pepe");
		u2.setPassword("pepe");
		assertTrue(u2.autenticarse());

		assertEquals(u2.getTipo(), "camarero");

		assertTrue(u1.eliminar());
	}

	@Test
	public void testInsertarUsuarioYaExistente() throws Exception {
		Usuario u1 = new Usuario("in4mates", "in4mates", "jefe de sala");
		assertFalse(u1.insertar()); // devuelve false por que el usuario ya existe
	}

	@Test
	public void testReadAll() throws Exception {
		Usuario u = new Usuario();
		assertTrue(u.leerTodo());
		assertNotEquals(0, u.getGestorUsuario().getListaUsuarios().size());
	}
}

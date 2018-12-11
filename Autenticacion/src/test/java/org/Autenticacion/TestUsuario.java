package org.Autenticacion;

import static org.junit.Assert.*;

import org.Autenticacion.Dominio.Usuario;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUsuario {

	private Usuario UsuarioExiste;
	private Usuario noExiste;

	@Before
	public void setUp() throws Exception {
		UsuarioExiste = new Usuario();
		UsuarioExiste.setNombre("in4mates");
		UsuarioExiste.setPassword("in4mates");

		noExiste = new Usuario();
		noExiste.setNombre("noExiste");
		noExiste.setPassword("noExiste");

		// Agente a = Agente.getAgente();

	}

	@Test
	public void testAutenticarse() {
		assertTrue(UsuarioExiste.autenticarse());
		assertFalse(noExiste.autenticarse());
	}

	@Test
	public void testGetSetNombre() throws Exception {
		UsuarioExiste.setNombre("in4mates");
		assertEquals(UsuarioExiste.getNombre(), "in4mates");
	}

	@Test
	public void testGetSetPassword() throws Exception {
		UsuarioExiste.setPassword("in4mates");
		assertEquals(UsuarioExiste.getPassword(), "in4mates");
	}

	@Test
	public void testGetSetTipo() throws Exception {
		UsuarioExiste.setTipo("jefe de sala");
		assertEquals(UsuarioExiste.getTipo(), "jefe de sala");
		
	}
	
	@Test(expected = Exception.class)
	public void testCrearUsuarioFallo1() throws Exception{
		Usuario u = new Usuario("antonio","antonio","");
	}
	@Test(expected = Exception.class)
	public void testCrearUsuarioFallo2() throws Exception{
		Usuario u = new Usuario("antionio","","camarero");
	}
	@Test(expected = Exception.class)
	public void testCrearUsuarioFallo3() throws Exception{
		Usuario u = new Usuario("","antonio","camarero");
	}
	
	@Test(expected = Exception.class)
	public void testSetNombreFallo() throws Exception{
		UsuarioExiste.setNombre("");
	}
	
	@Test(expected = Exception.class)
	public void testSetPasswordFallo() throws Exception{
		UsuarioExiste.setPassword("");
	}
	
	@Test(expected = Exception.class)
	public void testSetTipoFallo() throws Exception{
		UsuarioExiste.setTipo("");
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

	@Test(expected = Exception.class)
	public void testInsertarUsuarioYaExistente() throws Exception {
		Usuario u1 = new Usuario("in4mates", "in4mates", UsuarioExiste.getTipo());
		assertFalse(u1.insertar());
	}


}





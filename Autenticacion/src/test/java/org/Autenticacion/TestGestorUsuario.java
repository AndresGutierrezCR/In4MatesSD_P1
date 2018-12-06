package org.Autenticacion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.Autenticacion.Dominio.Usuario;
import org.Autenticacion.Persistencia.GestorUsuario;
import org.junit.Before;
import org.junit.Test;

public class TestGestorUsuario {


	private Usuario UsuarioExiste;
	private Usuario noExiste;
	private GestorUsuario gestorUsuario;
	

	@Before
	public void setUp() throws Exception {
		
		gestorUsuario = new GestorUsuario();
		
		UsuarioExiste = new Usuario();
		UsuarioExiste.setNombre("in4mates");
		UsuarioExiste.setPassword("in4mates");

		noExiste = new Usuario();
		noExiste.setNombre("noExiste");
		noExiste.setPassword("noExiste");
		
	}
	@Test
	public void autenticarse() {
	
		assertTrue(UsuarioExiste.autenticarse());
	    assertFalse(noExiste.autenticarse());
	}

	@Test
	public void testInsertarBorrarYModifiarUsuario() throws Exception {
		
		Usuario u1 = new Usuario("pepe","pepe","camarero");
		assertTrue(gestorUsuario.insert(u1));
		u1.setTipo("camarero");
		assertTrue(gestorUsuario.update(u1));
		
		
		Usuario u2 = new Usuario();
		u2.setNombre("pepe");
		u2.setPassword("pepe");
		assertTrue(gestorUsuario.login(u2));
		
		assertEquals(u2.getTipo(),"camarero");
		
		assertTrue(gestorUsuario.delete(u1));
		
	}
	
	@Test
	public void testReadAll() {
		
		assertTrue(gestorUsuario.readAll());
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		UsuarioExiste.autenticarse();
		listaUsuario.add(UsuarioExiste);
		
		//assertArrayEquals(listaUsuario, gestorUsuario.getListaUsuarios());
		assertNotEquals(gestorUsuario.getListaUsuarios(),0);
		
	}

}

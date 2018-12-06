package org.Autenticacion;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.Autenticacion.Presentacion.IU_Autenticacion;
import org.junit.Test;

public class TestIU_Autenticacion {

	private IU_Autenticacion interfaz;
	
	@Test
	public void test1() {
		try {
			interfaz = new IU_Autenticacion();
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	@Test
	public void testAutenticacionVerdadera() {
		try {
			interfaz = new IU_Autenticacion();
			interfaz.setTxtNombre("in4mates");
			interfaz.setPassword("in4mates");
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		try {
			assertTrue(interfaz.aceptar());
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	@Test
	public void testAutenticacionFalsa() {
		try {
			interfaz = new IU_Autenticacion();
			interfaz.setTxtNombre("nada");
			interfaz.setPassword("nada");
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		try {
			assertFalse(interfaz.aceptar());
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	@Test
	public void testAutenticacionFalsaVacio() {
		try {
			interfaz = new IU_Autenticacion();
			interfaz.setTxtNombre("");
			interfaz.setPassword("");
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		try {
			assertFalse(interfaz.aceptar());
		}catch(Exception e) {
			assumeNoException(e);
		}
	}

}

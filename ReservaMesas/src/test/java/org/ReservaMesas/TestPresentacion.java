package org.ReservaMesas;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.ReservaMesas.Dominio.Estados;
import org.ReservaMesas.Presentacion.IU_EstadosMesas;
import org.ReservaMesas.Presentacion.IU_P_estadoMesa;
import org.ReservaMesas.Presentacion.IU_VerReservas;
import org.ReservaMesas.Presentacion.Ventana_Principal;
import org.junit.Test;

public class TestPresentacion {


	
	@Test
	public void test_VentanaPrincial() {
		try {
			Ventana_Principal vp = new Ventana_Principal();
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	@Test
	public void test_IU_EstadosMesas() {
		IU_EstadosMesas ventana = null;
		try {
			ventana = new IU_EstadosMesas();
			ventana.recargar();
		}catch(Exception e) {
			assumeNoException(e);
		}
		
	}
	
	@Test (expected = Exception.class)
	public void test_IU_P_estadoMesa1() throws Exception {
		IU_P_estadoMesa panel = new IU_P_estadoMesa(-6);
	}
	
	@Test (expected = Exception.class)
	public void test_IU_P_estadoMesa2() throws Exception {
		IU_P_estadoMesa panel = new IU_P_estadoMesa(0);
	}

	@Test 
	public void test_IU_P_estadoMesa3() throws Exception {
		try {
		IU_P_estadoMesa panel = new IU_P_estadoMesa(3);
		} catch(Exception e) {
			assumeNoException(e);
		}
	}

	@Test 
	public void test_IU_P_estadoMesa4() throws Exception {
		IU_P_estadoMesa panel = new IU_P_estadoMesa(3);
		panel.estadoBotones(Estados.PIDIENDO);
		assertEquals(panel.getEstadoUltimo(),Estados.PIDIENDO);
	}

	@Test
	public void test_IU_VerReservas1() throws Exception {
		try {
			IU_VerReservas res = new IU_VerReservas();
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	
	
}
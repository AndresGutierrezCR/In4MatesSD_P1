package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;

import org.ReservaMesas.Dominio.Mesa;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;

public class IU_EstadosMesas extends JPanel {
	private JPanel[] panelesMesas;
	private Mesa mesa;
	private JPanel PanelContenedor;
	/**
	 * Create the panel.
	 */
	public IU_EstadosMesas() {
		setLayout(new BorderLayout(0, 0));
		{
			PanelContenedor = new JPanel();
			add(PanelContenedor, BorderLayout.CENTER);
		}
		{
			
			
			cargar();
			
		}
		
		
		
	}
	
	public void cargar() {
		mesa=new Mesa();
		mesa.leerTodo();
		panelesMesas = new JPanel[mesa.getGestorMesa().getListaMesas().size()];
		for(int i=0;i<mesa.getGestorMesa().getListaMesas().size();i++) {
			try {
			panelesMesas[i] = new IU_P_estadoMesa(mesa.getGestorMesa().getListaMesas().get(i).getIdMesa());
			((IU_P_estadoMesa) panelesMesas[i]).setIdMesa(i+1);
			panelesMesas[i].setBorder(new TitledBorder(null, "Estados mesa "+(i+1), TitledBorder.LEADING, TitledBorder.TOP, null, null));;
			PanelContenedor.add(panelesMesas[i]);
			((IU_P_estadoMesa) panelesMesas[i]).estadoInicial();
			}catch(Exception e) {
				
			}
		}
	}
	
	public void recargar() {
		for(int i=PanelContenedor.getComponents().length-1;i>=0;i--) {
			PanelContenedor.remove(i);
		}
		cargar();
	}
	
	

}

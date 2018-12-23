/**
 * Paquete que contiene las clases de presentación del módulo ReservaMesas.
 **/
package org.ReservaMesas.Presentacion;

import javax.swing.JPanel;

import org.ReservaMesas.Dominio.Mesa;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
/**
 * Clase IU_EstadosMesas. Contiene la interfaz que permite visualizar los
 * estados de las mesas.
 *
 * @author in4mates
 * @version 1.0
 */
public class IU_EstadosMesas extends JPanel {
	/**
	 * Panel que muestra las distintas mesas.
	 **/
	private JPanel[] panelesMesas;
	/**
	 * Objeto de la clase mesa.
	 **/
	private Mesa mesa;
	/**
	 * Panel que contiene todo lo demas.
	 **/
	private JPanel PanelContenedor;
	/**
	 * Constructor de la interfaz estados mesas con todos
	 * sus campos y características.
	 **/
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
	/**
	 * método cargar que carga todas las mesas y sus estados.
	 **/
	public void cargar() {
		mesa = new Mesa();
		mesa.leerTodo();
		panelesMesas = new JPanel[mesa.getGestorMesa()
		        .getListaMesas().size()];
		for (int i = 0; i < mesa.getGestorMesa()
				.getListaMesas().size(); i++) {
			try {
				panelesMesas[i] =
					new IU_P_estadoMesa(mesa.getGestorMesa()
					.getListaMesas()
					.get(i).getIdMesa());
				((IU_P_estadoMesa) panelesMesas[i])
				.setIdMesa(i + 1);
				panelesMesas[i].setBorder(new TitledBorder(null,
						"Estados mesa "
				+ (i + 1), TitledBorder.LEADING,
						TitledBorder.TOP, null, null));
				PanelContenedor.add(panelesMesas[i]);
				((IU_P_estadoMesa) panelesMesas[i])
				.estadoInicial();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	/**
	 * método recargar que vuelve a cargar los elementos en el panel una vez
	 * se realiza algún cambio en alguno de los estados de las mesas.
	 **/
	public void recargar() {
		for (int i = PanelContenedor.getComponents()
				.length - 1; i >= 0; i--) {
			PanelContenedor.remove(i);
		}
		cargar();
	}

}

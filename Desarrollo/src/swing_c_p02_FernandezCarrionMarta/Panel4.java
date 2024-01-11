/**
 * Panel4.java
 * 21 nov 2023 14:00:37
 * @author Marta Fernández Carrión
 */
package swing_c_p02_FernandezCarrionMarta;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * @author Marta
 *
 */
public class Panel4 extends JPanel {
	
	JTabbedPane tabbedPane;
	JTextArea arrendador;
	JTextArea inmueble;
	private Panel2 panelArrendador;
	Panel3 panelInmueble;
	
	

	public Panel4() {
		// Crear el JTabbedPane
		tabbedPane = new JTabbedPane();
		arrendador = new JTextArea(10, 20);
		inmueble = new JTextArea(10, 20);
		
		tabbedPane.addTab("Arrendador", new JScrollPane(arrendador));
		tabbedPane.addTab("Inmueble", new JScrollPane(inmueble));
		

		// Agregar JTextArea al panel
		add(tabbedPane, BorderLayout.CENTER);
		
	}



	/**
	 * 
	 */
	public void nuevoRegistro() {
		// TODO Auto-generated method stub
		
	}



	/**
	 * 
	 */
	public boolean datosIngresados() {
		return false;
		
		
	}
	
	
}


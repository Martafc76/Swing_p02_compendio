/**
 * Panel2.java
 * 21 nov 2023 13:53:40
 * @author Marta Fernández Carrión
 */
package swing_c_p02_FernandezCarrionMarta;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Marta
 *
 */
public class Panel2 extends JPanel implements FocusListener {

	JTextField nombre;
	JTextField apellidos;
	JTextField campoDNI;
	JTextField telefono;
	JTextArea datosArrendador;
	private Panel4 panel4;

	public Panel2(Panel4 panel4) {

		// SEGUNDO PANEL
		JPanel panelDatosArrendador = new JPanel();
		datosArrendador = new JTextArea(10, 20);

		panelDatosArrendador.setBackground(new Color(0xAAD4D3));
		panelDatosArrendador.setLayout(new BoxLayout(panelDatosArrendador, BoxLayout.Y_AXIS));

		// Creo los componentes
		nombre = new JTextField(20);
		apellidos = new JTextField(20);
		campoDNI = new JTextField(10);
		telefono = new JTextField(9);

		// Agrego los componentes al segundo panel
		panelDatosArrendador.add(new JLabel("Nombre:"));
		panelDatosArrendador.add(nombre);
		panelDatosArrendador.add(new JLabel("\nApellidos:"));
		panelDatosArrendador.add(apellidos);
		panelDatosArrendador.add(new JLabel("\nDNI:"));
		panelDatosArrendador.add(campoDNI);
		panelDatosArrendador.add(new JLabel("\nTeléfono:"));
		panelDatosArrendador.add(telefono);

		// Validaciones para el campo DNI
		campoDNI.addFocusListener(this);

		// Validaciones para el campo Teléfono
		telefono.addFocusListener(this);

		add(panelDatosArrendador);
	}

	// Método para mostrar un mensaje de error
	private void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(telefono) && !telefono.getText().matches("\\d{9}")) {
			telefono.setBackground(new Color(0XFF0000));
			telefono.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		} else if (e.getSource().equals(telefono)) {
			telefono.setBackground(new Color(0XFFFFFF));
			telefono.setBorder(null);
		}

		if (e.getSource().equals(campoDNI) && !campoDNI.getText().matches("\\d{8}\\w")) {
			campoDNI.setBackground(new Color(0XFF0000));
			campoDNI.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		} else if (e.getSource().equals(campoDNI)) {
			campoDNI.setBackground(new Color(0XFFFFFF));
			campoDNI.setBorder(null);
		}

	}

	/**
	 * 
	 */
	public void nuevoRegistro() {
		nombre.setText("");
		apellidos.setText("");
		campoDNI.setText("");
		telefono.setText("");

	}

	/**
	 * 
	 */
	public boolean datosIngresados() {
		boolean datosCorrectos = true;

		// Verificar nombre
		if (nombre.getText().isEmpty()) {
			mostrarErrorCampo(nombre);
			datosCorrectos = false;
		}

		// Verificar apellidos
		if (apellidos.getText().isEmpty()) {
			mostrarErrorCampo(apellidos);
			datosCorrectos = false;
		}

		// Verificar DNI
		if (!campoDNI.getText().matches("\\d{8}\\w")) {
			mostrarErrorCampo(campoDNI);
			datosCorrectos = false;
		}

		// Verificar teléfono
		if (!telefono.getText().matches("\\d{9}")) {
			mostrarErrorCampo(telefono);
			datosCorrectos = false;
		}

		return datosCorrectos;
	}

	// Método para mostrar un mensaje de error en el campo específico
	private void mostrarErrorCampo(JComponent campo) {
		campo.setBackground(new Color(0xFF0000));
		campo.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		mostrarMensajeError("Por favor, complete correctamente todos los campos.");
	}

}

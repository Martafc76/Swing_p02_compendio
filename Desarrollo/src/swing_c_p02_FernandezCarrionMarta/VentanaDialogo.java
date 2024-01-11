/**
 * VentanaDialogo.java
 * 21 nov 2023 1:06:53
 * @author Marta Fernández Carrión
 */
package swing_c_p02_FernandezCarrionMarta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Marta
 *
 */
public class VentanaDialogo extends JDialog {

	private Panel2 panel2;
	private Panel3 panel3;
	private Panel4 panel4;

	public VentanaDialogo() {

		setTitle("Alta pisos");
		setLayout(new BorderLayout());

		// Hago que la ventana sea de la reslucion de mi pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height - 50);

		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/logo1.jpg"));
		setIconImage(icon.getImage());

		// PRIMER PANEL
		JPanel panelNombreEmpresa = new JPanel();

		// Uso el new color para añadir un color azul
		// personalizado
		panelNombreEmpresa.setBackground(new Color(0x5C9493));

		Color borderColor = new Color(0xC6D5D2);
		panelNombreEmpresa.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		// declaro la imagen y texto
		JLabel labelImagen = new JLabel(new ImageIcon(getClass().getResource("/resources/logo1.jpg")));

		JLabel labelNombreEmpresa = new JLabel("MFCTouristicHouse");
		labelNombreEmpresa.setFont(new Font("Georgia", Font.BOLD, 40));

		panelNombreEmpresa.add(labelImagen);
		panelNombreEmpresa.add(labelNombreEmpresa);

		panel2 = new Panel2(panel4);
		panel2.setBackground(new Color(0xAAD4D3));
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

		panel3 = new Panel3();

		panel3.setBackground(new Color(0x5C9493));

		panel4 = new Panel4();
		panel4.setBackground(new Color(0xAAD4D3));
		panel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

		// cambio el tamaño del panel4 con ancho que yo quiera y uso getheight para que
		// ocuper toda la altura
		int anchoPanel4 = 200;
		int altoPanel4 = getHeight();

		// Configuración del tamaño preferido para el Panel4
		panel4.setPreferredSize(new Dimension(anchoPanel4, altoPanel4));

		JPanel botonesRestantes = new JPanel();
		botonesRestantes.setBackground(new Color(0xFFFFFF));
		botonesRestantes.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		botonesRestantes.setLayout(new BoxLayout(botonesRestantes, BoxLayout.X_AXIS));

		JButton imprimir = new JButton("Imprimir Documento");

		JButton nuevo = new JButton("Nuevo Registro");

		nuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nuevoRegistro();
				JOptionPane.showMessageDialog(VentanaDialogo.this, "Datos vaciados", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton guardar = new JButton("Guardar");

		guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (datosIngresados()) {
					// Si la operación es correcta, muestra el mensaje
					JOptionPane.showMessageDialog(VentanaDialogo.this, "Registro Guardado", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		
		JButton toolkiBoton = new JButton("Boton en pruebas");
		toolkiBoton.setToolTipText("Este boton está en pruebas aún");
		
		toolkiBoton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(VentanaDialogo.this, "Botón en pruebas", "Información",
		                JOptionPane.INFORMATION_MESSAGE);
		    }
		});

		botonesRestantes.add(toolkiBoton);
		botonesRestantes.add(imprimir);
		botonesRestantes.add(nuevo);
		botonesRestantes.add(guardar);

		// Configuración de la disposición y adición de componentes
		add(panelNombreEmpresa, BorderLayout.NORTH);
		add(panel2, BorderLayout.WEST);
		add(panel3, BorderLayout.CENTER);
		add(panel4, BorderLayout.EAST);
		add(botonesRestantes, BorderLayout.SOUTH);
	}

	// Método para mostrar un mensaje de error
	private void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	 private boolean datosIngresados() {
	        boolean datosCorrectos = true;

	        // Llamada a los métodos de verificación en los paneles
	        if (!panel2.datosIngresados() && !panel3.datosIngresados() ) {
	            datosCorrectos = false;
	        }

	        return datosCorrectos;
	    }
	 
//	  || !panel4.datosIngresados()

	private void nuevoRegistro() {
		panel2.nuevoRegistro();
		panel3.nuevoResgistro();
		panel4.nuevoRegistro();
	}
}

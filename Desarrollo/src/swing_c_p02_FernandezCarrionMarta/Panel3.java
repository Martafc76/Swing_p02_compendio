/**
 * Panel3.java
 * 21 nov 2023 14:00:15
 * @author Marta Fernández Carrión
 */
package swing_c_p02_FernandezCarrionMarta;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Marta
 *
 */
public class Panel3 extends JPanel {

	// creo un arrayList para las imagenes
	private List<ImageIcon> imagenes = new ArrayList<>();
	private int imagen = 0;

	private JLabel labelPrecioMinimo;
	private double precioMinimo;
	
	JLabel baño;
	JCheckBox bañoSi;
	JCheckBox niños;
	JComboBox<String> comboBoxTipoCamas;
	JSpinner spinnerNumCamas;
	JTextField textFieldDireccion;
	JComboBox<String> comboBoxProvincia;
	JFormattedTextField textFieldFechaAlta;
	JFormattedTextField textFieldFechaDisponibilidad;
	JSpinner numeroHuesped;
	JSpinner spinnerEdadNiños;
	JSpinner spinnerImagenes;
	JTextField textFieldExtras;

	private final double PRECIO_POR_CAMA_SIMPLE = 15;
	private final double PRECIO_POR_CAMA_DOBLE = 20;
	private final double PRECIO_POR_SOFÁ_CAMA = 15;
	private final double PRECIO_POR_BAÑO = 25;
	private final double PRECIO_POR_CUNA_O_SUPLETORIA = 12;

	public Panel3() {
		// Configuración del layout
		// GridLayout con 2 columnas
		setLayout(new GridLayout(0, 4, 1, 50));

		JLabel labelDireccion = new JLabel("Dirección:");
		textFieldDireccion = new JTextField(20);

		JLabel labelProvincia = new JLabel("Provincia:");
		// Uso JComboBox para las provincias
		String[] provincias = { "Selecciona una provincia", "Álava (Araba) - País Vasco (Euskadi)",
				"Albacete - Castilla-La Mancha", "Alicante - Comunidad Valenciana", "Almería - Andalucía",
				"Asturias - Principado de Asturias", "Ávila - Castilla y León", "Badajoz - Extremadura",
				"Barcelona - Cataluña (Catalunya)", "Burgos - Castilla y León", "Cáceres - Extremadura",
				"Cádiz - Andalucía", "Cantabria - Cantabria",
				"Castellón (Castelló) - Comunidad Valenciana (Comunitat Valenciana)",
				"Ciudad Real - Castilla-La Mancha", "Córdoba - Andalucía", "Cuenca - Castilla-La Mancha",
				"Gerona (Girona) - Cataluña (Catalunya)", "Granada - Andalucía", "Guadalajara - Castilla-La Mancha",
				"Guipúzcoa (Gipuzkoa) - País Vasco (Euskadi)", "Huelva - Andalucía", "Huesca - Aragón",
				"Islas Baleares (Illes Balears) - Islas Baleares (Illes Balears)", "Jaén - Andalucía",
				"La Coruña (A Coruña) - Galicia", "La Rioja - La Rioja", "Las Palmas - Canarias",
				"León - Castilla y León", "Lérida (Lleida) - Cataluña (Catalunya)", "Lugo - Galicia",
				"Madrid - Comunidad de Madrid", "Málaga - Andalucía", "Murcia - Región de Murcia",
				"Navarra (Nafarroa) - Comunidad Foral de Navarra (Nafarroako Foru Komunitate)",
				"Orense (Ourense) - Galicia", "Palencia - Castilla y León", "Pontevedra - Galicia",
				"Salamanca - Castilla y León", "Santa Cruz de Tenerife - Canarias", "Segovia - Castilla y León",
				"Sevilla - Andalucía", "Soria - Castilla y León", "Tarragona - Cataluña", "Teruel - Aragón",
				"Toledo - Castilla-La Mancha", "Valencia - Comunidad Valenciana (Comunitat Valenciana)",
				"Valladolid - Castilla y León", "Vizcaya (Bizkaia) - País Vasco (Euskadi)", "Zamora - Castilla y León",
				"Zaragoza - Aragón" };
		comboBoxProvincia = new JComboBox<>(provincias);

		// FECHA DE ALTA y final
		JLabel labelFechaAlta = new JLabel("Fecha de Alta:");

		textFieldFechaAlta = new JFormattedTextField();
		

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		JLabel labelFechaDisponibilidad = new JLabel("Fecha Final de Disponibilidad:");

		textFieldFechaDisponibilidad = new JFormattedTextField();
		textFieldFechaAlta.setValue(new Date());
		textFieldFechaDisponibilidad.setValue(calcularFecha());

		JLabel labelNumeroHuesped = new JLabel("Numero de huespedes: ");

		SpinnerNumberModel spiner = new SpinnerNumberModel(1, 1, 8, 1);
		numeroHuesped = new JSpinner(spiner);

		labelDireccion.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		textFieldDireccion.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		labelProvincia.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		comboBoxProvincia.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		labelFechaAlta.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		textFieldFechaAlta.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		labelFechaDisponibilidad.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		textFieldFechaDisponibilidad.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		labelNumeroHuesped.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		numeroHuesped.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		
		
		// Agregar componentes al panel
		add(labelDireccion);
		add(textFieldDireccion);
		add(labelProvincia);
		add(comboBoxProvincia);
		add(labelFechaAlta);
		add(textFieldFechaAlta);
		add(labelFechaDisponibilidad);
		add(textFieldFechaDisponibilidad);
		add(labelNumeroHuesped);
		add(numeroHuesped);

		// Depende del número de camas, se activa/desactiva la
		// lista de tipo de camas
		spinnerNumCamas = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));
		JLabel labelTipoCamas = new JLabel("Tipo de Camas:");
		String[] tipoCamas = { "simple", "doble", "sofá cama" };
		comboBoxTipoCamas = new JComboBox<>(tipoCamas);

		comboBoxTipoCamas.setEnabled(false);

		// le añado el listner al JSPinner para habilitar o no el vomboBox
		spinnerNumCamas.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int numCamas = (int) spinnerNumCamas.getValue();
				comboBoxTipoCamas.setEnabled(numCamas > 0);
			}
		});
		JLabel numCamas = new JLabel("Nº de camas: ");
		
		numCamas.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		spinnerNumCamas.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		labelTipoCamas.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		comboBoxTipoCamas.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
	
		add(numCamas);
		add(spinnerNumCamas);
		add(labelTipoCamas);
		add(comboBoxTipoCamas);

		niños = new JCheckBox("¿Hay niños?");
		niños.setBackground(new Color(0x5C9493));

		JPanel panelExtrasNiños = new JPanel();
		panelExtrasNiños.setLayout(new GridLayout(2, 2));

		JLabel labelEdadNiños = new JLabel("Edad de Niños:");
		spinnerEdadNiños = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

		JLabel labelExtras = new JLabel("Extras:");
		textFieldExtras = new JTextField();

		niños.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				panelExtrasNiños.setEnabled(niños.isSelected());
				spinnerEdadNiños.setEnabled(niños.isSelected());
				textFieldExtras.setEnabled(niños.isSelected());
			}
		});

		panelExtrasNiños.setBorder(BorderFactory.createTitledBorder("Extras niños"));
		panelExtrasNiños.setEnabled(false);
		spinnerEdadNiños.setEnabled(false);
		textFieldExtras.setEnabled(false);

		// Muetsra el contenido dependinedo de la edad que se introduzca en el cuadro de
		// texto
		textFieldExtras.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				int edad = (int) spinnerEdadNiños.getValue();
				if (edad >= 0 && edad <= 3) {
					textFieldExtras.setText("Cuna");
				} else if (edad >= 4 && edad <= 10) {
					textFieldExtras.setText("Cama supletoria pequeña");
				}
			}
		});

		panelExtrasNiños.setBackground(new Color(0x5C9493));
		panelExtrasNiños.add(labelEdadNiños);
		panelExtrasNiños.add(spinnerEdadNiños);
		panelExtrasNiños.add(labelExtras);
		panelExtrasNiños.add(textFieldExtras);

//		//añado las imagenes a la lista

		JPanel ts = new JPanel();
		JLabel texto = new JLabel("Imágenes de las habitaciones del hotel ");

		SpinnerModel imagenes = new SpinnerNumberModel(1, 0, 3, 1);
		spinnerImagenes = new JSpinner(imagenes);

		CardLayout cardLayout = new CardLayout();
		JPanel panelImagenes = new JPanel(cardLayout);

		JLabel imagen0 = new JLabel(new ImageIcon(getClass().getResource("/resources/hotel1.jpg")));
		JLabel imagen1 = new JLabel(new ImageIcon(getClass().getResource("/resources/hotel2.jpg")));
		JLabel imagen2 = new JLabel(new ImageIcon(getClass().getResource("/resources/hotel3.jpg")));

		panelImagenes.add(imagen0, "1");
		panelImagenes.add(imagen1, "2");
		panelImagenes.add(imagen2, "3");

		spinnerImagenes.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int valor = (int) spinnerImagenes.getValue();
				cardLayout.show(panelImagenes, String.valueOf(valor));
			}
		});

		baño = new JLabel("¿Quiere baño?");
		bañoSi = new JCheckBox("Sí");

		niños.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		panelExtrasNiños.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		baño.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		bañoSi.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		spinnerImagenes.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		panelImagenes.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		
		add(niños);
		add(panelExtrasNiños);
		add(baño);
		add(bañoSi);
		add(spinnerImagenes);
		add(panelImagenes);
		

		precioMinimo = 0;

		labelPrecioMinimo = new JLabel("Precio Mínimo: " + precioMinimo + "€");
		labelPrecioMinimo.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		add(labelPrecioMinimo);

		spinnerNumCamas.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// Actualiza las variables de precios según el número de camas
				int numCamas = (int) spinnerNumCamas.getValue();
				double precioTotal = numCamas * PRECIO_POR_CAMA_SIMPLE; // Precio base por cama simple

				// Añade los precios por tipo de cama seleccionada
				String tipoCamaSeleccionada = (String) comboBoxTipoCamas.getSelectedItem();
				precioTotal += calcularPrecioPorTipoCama(tipoCamaSeleccionada);

				// Añade precio por la presencia de niños
				if (niños.isSelected()) {
					precioTotal += PRECIO_POR_CUNA_O_SUPLETORIA;
				}

				// Añade precio por la presencia de baño
				if (bañoSi.isSelected()) {
					precioTotal += PRECIO_POR_BAÑO;
				}

				// Calcula el precio mínimo según la fórmula proporcionada
				precioMinimo = calcularPrecioMinimo(precioTotal);

				// Actualiza el campo en la interfaz
				labelPrecioMinimo.setText("Precio Mínimo: " + precioMinimo + " €");
			}
		});

		comboBoxTipoCamas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarPrecio();

			}

		});
		
		bañoSi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarPrecio();
				
			}
		});
		
		niños.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarPrecio();
				
			}
		});

	}

	// Método para calcular la fecha actual más 1 año
	private java.util.Date calcularFecha() {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.add(java.util.Calendar.YEAR, 1);
		return calendar.getTime();
	}

	// Método para calcular el precio mínimo según la fórmula dada
	private double calcularPrecioMinimo(double precioTotal) {
		return precioTotal ;
	}

	// Método para calcular el precio por tipo de cama seleccionada
	private double calcularPrecioPorTipoCama(String tipoCama) {
		switch (tipoCama) {
		case "simple":
			return PRECIO_POR_CAMA_SIMPLE;
		case "doble":
			return PRECIO_POR_CAMA_DOBLE;
		case "sofá cama":
			return PRECIO_POR_SOFÁ_CAMA;
		default:
			return 0.0; // Precio por defecto si no se reconoce el tipo de cama
		}
	}

	// Método para actualizar el precio total y mínimo
	private void actualizarPrecio() {
		// Actualiza las variables de precios según el número de camas
		int numCamas = (int) spinnerNumCamas.getValue();
		double precioTotal = numCamas * PRECIO_POR_CAMA_SIMPLE; // Precio base por cama simple

		// Añade los precios por tipo de cama seleccionada
		String tipoCamaSeleccionada = (String) comboBoxTipoCamas.getSelectedItem();
		precioTotal += calcularPrecioPorTipoCama(tipoCamaSeleccionada);

		// Añade precio por la presencia de niños
		if (niños.isSelected()) {
			precioTotal += PRECIO_POR_CUNA_O_SUPLETORIA;
		}

		// Añade precio por la presencia de baño
		if (bañoSi.isSelected()) {
			precioTotal += PRECIO_POR_BAÑO;
		}

		// Calcula el precio mínimo según la fórmula proporcionada
		precioMinimo = calcularPrecioMinimo(precioTotal);

		// Actualiza el campo en la interfaz
		labelPrecioMinimo.setText("Precio Mínimo: " + precioMinimo + " €");

	}

	/**
	 * 
	 */
	public void nuevoResgistro() {
		textFieldDireccion.setText("");
		bañoSi.setSelected(false);
		comboBoxTipoCamas.setSelectedIndex(0);
		spinnerNumCamas.setValue(0);
		textFieldDireccion.setText("");
		comboBoxProvincia.setSelectedIndex(0);
		textFieldFechaAlta.setText("");
		textFieldFechaDisponibilidad.setText("");
		numeroHuesped.setValue(0);
		spinnerEdadNiños.setValue(0);
		spinnerImagenes.setValue(0);
		textFieldExtras.setText("");
		labelPrecioMinimo.setText("");
		
	}

	private void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean datosIngresados() {
	    boolean datosCorrectos = true;

	    // Verificar dirección
	    if (textFieldDireccion.getText().isEmpty()) {
	        mostrarErrorCampo(textFieldDireccion, "Por favor, ingrese una dirección.");
	        datosCorrectos = false;
	    }

	    // Verificar provincia
	    if (comboBoxProvincia.getSelectedIndex() == 0) {
	        mostrarErrorCampo(comboBoxProvincia, "Por favor, seleccione una provincia.");
	        datosCorrectos = false;
	    }

	    // Verificar fecha de alta
	    if (textFieldFechaAlta.getText().isEmpty()) {
	        mostrarErrorCampo(textFieldFechaAlta, "Por favor, ingrese la fecha de alta.");
	        datosCorrectos = false;
	    }

	    // Verificar fecha de disponibilidad
	    if (textFieldFechaDisponibilidad.getText().isEmpty()) {
	        mostrarErrorCampo(textFieldFechaDisponibilidad, "Por favor, ingrese la fecha de disponibilidad.");
	        datosCorrectos = false;
	    }

	    // Verificar número de huéspedes
	    int numHuespedes = (int) numeroHuesped.getValue();
	    if (numHuespedes < 1) {
	        mostrarErrorCampo(numeroHuesped, "Por favor, ingrese un número válido de huéspedes.");
	        datosCorrectos = false;
	    }

	    // Verificar tipo de camas y número de camas
	    int numCamas = (int) spinnerNumCamas.getValue();
	    if (numCamas > 0 && comboBoxTipoCamas.getSelectedIndex() == 0) {
	        mostrarErrorCampo(comboBoxTipoCamas, "Por favor, seleccione un tipo de cama.");
	        datosCorrectos = false;
	    }

	    // Otros campos a verificar según tus requisitos

	    return datosCorrectos;
	}

	// Método auxiliar para mostrar un mensaje de error en el campo específico
	private void mostrarErrorCampo(JComponent campo, String mensaje) {
	    campo.setBackground(new Color(0xFF0000));
	    campo.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	    mostrarMensajeError(mensaje);
	}
	
	
}

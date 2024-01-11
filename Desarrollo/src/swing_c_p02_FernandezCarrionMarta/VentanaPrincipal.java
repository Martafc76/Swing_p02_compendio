/**
 * VentanaPrincipal.java
 * 21 nov 2023 1:06:27
 * @author Marta Fernández Carrión
 */
package swing_c_p02_FernandezCarrionMarta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * @author Marta
 *
 */
public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal() {

		// Creo la ventana principal, con la posicion en la mitad, el titulo y la
		// operacion de cerrar la ventana
		setTitle("Gestión Apartamentos Turísticos - MFCTouristicHouse");
		setSize(getScreenWidth() / 2, getScreenHeight() / 2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(getScreenWidth() / 2, getScreenHeight() / 2));
		setLayout(new GridLayout());

		// Añado el icono de forma interna en el proyecto
		ImageIcon icono = new ImageIcon(getClass().getResource("/resources/logo1.jpg"));
		setIconImage(icono.getImage());

		// Añado la barra del menú
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);

		// Añado a la barra el menu Archivo y dentro el item salir
		JMenu menuArchivo = new JMenu("Archivo");
		JMenuItem salirItem = new JMenuItem("Salir");
		salirItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuArchivo.add(salirItem);
		barraMenu.add(menuArchivo);

		// Añado la opcion de registro, con lo skey listener para la alta y baja de
		// pisos
		JMenu registroMenu = new JMenu("Registro");
		registroMenu.setMnemonic('R');
		JMenuItem altaPisosItem = new JMenuItem("Alta Pisos");
		altaPisosItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		altaPisosItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirVentanaAltaPisos();
			}
		});
		JMenuItem bajaPisosItem = new JMenuItem("Baja Pisos");
		bajaPisosItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		bajaPisosItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Aquí muestro el mensaje de que todavía no se ha desarrollado
				JOptionPane.showMessageDialog(VentanaPrincipal.this, "Esta opción no ha sido desarrollada", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		
		
		
		registroMenu.add(altaPisosItem);
		registroMenu.add(bajaPisosItem);
		barraMenu.add(registroMenu);

		// Añado el menu ayuda dond evooy a mostrar la info de la empresa
		JMenu ayudaMenu = new JMenu("Ayuda");
		JMenuItem acercaDeItem = new JMenuItem("Acerca de...");
		acercaDeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Muestro la informacion que se pide en ayuda, usando showMessageDialog
				JOptionPane.showMessageDialog(VentanaPrincipal.this,
						"Gestión Apartamentos Turísticos\nMFCTouristicHouse, \nOriginada por Marta Fernández Carrión en 2023",
						"Acerca de", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		ayudaMenu.add(acercaDeItem);
		barraMenu.add(ayudaMenu);
		

		// Creo el boton de alta pisos
		
		JPanel botonAlta = new JPanel();
		botonAlta.setLayout(new BorderLayout());
		JButton altaPisosButton = new JButton("Alta pisos");
		altaPisosButton.setIcon(new ImageIcon(getClass().getResource("/resources/Alta.png")));
		altaPisosButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirVentanaAltaPisos();
			}
		});
		

		// Creo el boton de baja de pisos
		JPanel botonBaja = new JPanel();
		JButton bajaPisosButton = new JButton("Baja pisos");
		bajaPisosButton.setIcon(new ImageIcon(getClass().getResource("/resources/Baja.png")));
		bajaPisosButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// muestro el mensaje de que no está desarrollado
				JOptionPane.showMessageDialog(VentanaPrincipal.this, "Esta opción no se ha desarrollado aún", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}
		});


		
		add(altaPisosButton);
		add(bajaPisosButton);
	}

	private void abrirVentanaAltaPisos() {
		VentanaDialogo dialogo = new VentanaDialogo();
		dialogo.setVisible(true);
	}

	private int getScreenWidth() {
		return Toolkit.getDefaultToolkit().getScreenSize().width;
	}

	private int getScreenHeight() {
		return Toolkit.getDefaultToolkit().getScreenSize().height;
	}

}

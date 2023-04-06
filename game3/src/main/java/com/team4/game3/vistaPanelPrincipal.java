package com.team4.game3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class vistaPanelPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public String nivelActualString = "principiante";
	
	public ArrayList<Color> coloresNuevos;
 
	// Instaciamos la vistaPanelesDer
	private vistaPanelesDer vistaPanelesDer;
	// Instanciamos la vistaComprobar
	private vistaComprobar vistaComprobar;
	// Instanciamos la vistaNivel
	private vistaNivel vNivel;
	// Instanciamos la vistaCambioColores
	vistaCambioColores vCamCol;

	public vistaPanelPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 1000);
		setTitle("MASTERMIND");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Crea la barra de menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 684, 22);
		contentPane.add(menuBar);

		// Crea los menus y sus items
		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);

		JMenuItem itemNuevoJuego = new JMenuItem("Nuevo Juego");
		menuArchivo.add(itemNuevoJuego);

		JMenuItem itemNivel = new JMenuItem("Nivel");
		menuArchivo.add(itemNivel);

		JMenuItem itemSalir = new JMenuItem("Salir");
		menuArchivo.add(itemSalir);

		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);

		JMenuItem itemComoJugar = new JMenuItem("Como Jugar");
		menuAyuda.add(itemComoJugar);

		JMenuItem itemAcercaDe = new JMenuItem("Acerca De");
		menuAyuda.add(itemAcercaDe);

		JMenu menuOpciones = new JMenu("Opciones");
		// menuOpciones.setEnabled(false); // Primera partida desactivado
		menuBar.add(menuOpciones);

		JMenuItem itemCambioColor = new JMenuItem("Cambiar Colores");
		menuOpciones.add(itemCambioColor);

		// Añade los ActionListeners a cada item del menu
		itemNuevoJuego.addActionListener(nuevoJuegoActionListener);
		itemNivel.addActionListener(nivelActionListener);
		itemSalir.addActionListener(salirActionListener);
		itemComoJugar.addActionListener(comoJugarActionListener);
		itemAcercaDe.addActionListener(acercaDeActionListener);
		itemCambioColor.addActionListener(cambioColorActionListener);

		vistaPanelesDer = new vistaPanelesDer(nivelActualString, null);
		vistaComprobar = new vistaComprobar(vistaPanelesDer.getColores(), vistaPanelesDer);

		// Agregar panelSuperiorDerecho y panelInferiorDerecho al diseño en
		// vistaPanelPrincipal
		contentPane.add(vistaPanelesDer.getPanelSuperiorDerecho());
		contentPane.add(vistaPanelesDer.getPanelInferiorDerecho());

		// Agragamos el panel vistaComprobar al JPanel principal
		contentPane.add(vistaComprobar);

		setVisible(true);
	}

	ActionListener nuevoJuegoActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nuevoJuego(coloresNuevos);
		}
	};

	ActionListener nivelActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			vNivel = new vistaNivel();
			vNivel.buttonAceptar.addActionListener(nivelAceptarActionListener);
		}
	};

	ActionListener nivelAceptarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nivelActualString = vNivel.getNivel();
			vNivel.dispose();
			nuevoJuego(null);
		}
	};

	ActionListener salirActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};

	ActionListener comoJugarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			vistaComoJugar vCoJu = new vistaComoJugar();
		}
	};

	ActionListener acercaDeActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			vistaAcercaDe vAcDe = new vistaAcercaDe();
		}
	};

	ActionListener cambioColorActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			vCamCol = new vistaCambioColores(nivelActualString);
			vCamCol.buttonAceptar.addActionListener(cambioColorAceptarActionListener);
		}
	};

	ActionListener cambioColorAceptarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			coloresNuevos = vCamCol.crearColores();
			vCamCol.dispose();
			nuevoJuego(coloresNuevos);
		}
	};

	// Elimina todos los componentes
	public void borrar_componentes() {
		contentPane.remove(vistaPanelesDer.getPanelSuperiorDerecho());
		contentPane.remove(vistaPanelesDer.getPanelInferiorDerecho());
		contentPane.remove(vistaComprobar);
	}

	// Termina la partida actual e inicia un nuevo juego
	public void nuevoJuego(ArrayList<Color> col) {
		borrar_componentes();
		vistaPanelesDer = new vistaPanelesDer(nivelActualString, col);

		vistaComprobar = new vistaComprobar(vistaPanelesDer.getColores(), vistaPanelesDer);

		// Agregar panelSuperiorDerecho y panelInferiorDerecho al diseño en
		// vistaPanelPrincipal
		contentPane.add(vistaPanelesDer.getPanelSuperiorDerecho());
		contentPane.add(vistaPanelesDer.getPanelInferiorDerecho());

		// Agragamos el panel vistaComprobar al JPanel principal
		contentPane.add(vistaComprobar);
		contentPane.revalidate();
		contentPane.repaint();
	}

}

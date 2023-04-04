package com.team4.game3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaPanelPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public String nivelActualString = "";

	public vistaPanelPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
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
		menuOpciones.setEnabled(false);
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

		setVisible(true);
	}

	ActionListener nuevoJuegoActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nuevoJuego();
		}
	};

	ActionListener nivelActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			vistaNivel vNivel = new vistaNivel();
			// FALTA RECOGER EL NIVEL QUE SE HA ASIGNADO !!
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
			System.out.println("Cambio color");
			//vistaCambioColor vCaCo = new vistaCambioColor();
		}
	};

	// Termina la partida actual e inicia un nuevo juego
	public void nuevoJuego() {
		System.out.println("NUEVO JUEGO!");
	}

}

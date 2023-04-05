package com.team4.game3;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.util.Random;

public class vistaPanelesDer {
	private JPanel panelSuperiorDerecho; // Panel que contiene 'Colores disponibles'
	private JPanel panelInferiorDerecho; // Panel que contiene 'Combinacion secreta' de colores
	private Color[] colores; // Array con los colores disponibles
	private Color[] solucion; // Array que guarda la 'Combinacion secreta' de colores aleatorios
	private boolean acertaste = false;

	int nivel = 4; // Se pasará por parámetro desde vistaPanelPrincipal

	/**
	 * Contructor que inicializa un array de colores con dimensión segun nivel de
	 * dificultad Inicializa el método que crea el panel superior con 'Colores
	 * disponibles' Inicializa el método que crea el panel inferior con
	 * 'Conmbinación secreta'
	 */
	public vistaPanelesDer() {
		// Inicializa con 4 colores por defecto
		inicializarColores(nivel);
		crearColores();
		crearSolucion();
	}

	/**
	 * Crea un array de colores de tamaño según nivel de dificultad
	 * @param nivelDifi
	 */
	public void inicializarColores(int nivelDifi) {
		colores = new Color[nivelDifi];

		// Colores nivel por pricipiante
		colores[0] = Color.RED;
		colores[1] =  new Color(114, 140, 187);
		colores[2] = Color.GREEN;
		colores[3] = Color.YELLOW;

		// Colores nivel medio
		if (nivelDifi == 6) {
			colores[4] = Color.ORANGE;
			colores[5] = Color.MAGENTA;
		}

		// colores nivel avanzado
		if (nivelDifi == 8) {
			colores[6] = Color.CYAN;
			colores[7] = Color.PINK;
		}
	}

	/**
	 */
	public void crearColores() {
		panelSuperiorDerecho = new JPanel();
		panelSuperiorDerecho.setBounds(450, 50, 230, 60);
		panelSuperiorDerecho.setLayout(new GridLayout(1, colores.length, 10, 10));

		Border outerBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		Border innerBorder = BorderFactory.createEmptyBorder(20, 10, 10, 10);
		Border compoundBorder1 = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
		panelSuperiorDerecho.setBorder(BorderFactory.createTitledBorder(compoundBorder1, "Colores Disponibles"));

		for (Color color : colores) {
			JPanel bolaColor = new JPanel();
			bolaColor.setBackground(color);
			bolaColor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			panelSuperiorDerecho.add(bolaColor);
		}
		
	}

	public void crearSolucion() {
		panelInferiorDerecho = new JPanel();
		panelInferiorDerecho.setBounds(450, 150, 230, 60);
		panelInferiorDerecho.setLayout(new GridLayout(1, colores.length, 10, 10));

		Border outerBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		Border innerBorder = BorderFactory.createEmptyBorder(20, 10, 10, 10);
		Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
		panelInferiorDerecho.setBorder(BorderFactory.createTitledBorder(compoundBorder, "Combinación secreta"));

		// El panel de solución no seravisible inicialmente
//		panelInferiorDerecho.setVisible(true);
		panelInferiorDerecho.setVisible(true);

		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		solucion = new Color[colores.length];
		Random rand = new Random();
		for (int i = 0; i < colores.length; i++) {
			int randomIndex = rand.nextInt(colores.length);
			solucion[i] = colores[randomIndex];
			JPanel bolaSolucion = new JPanel();
			bolaSolucion.setBackground(solucion[i]);
			bolaSolucion.setBorder(border);
			panelInferiorDerecho.add(bolaSolucion);
		}
	}
	
	public void actualizarPanelSolucion() {
	    panelInferiorDerecho.setVisible(acertaste);
	}

	

	public JPanel getPanelSuperiorDerecho() {
		return panelSuperiorDerecho;
	}

	public JPanel getPanelInferiorDerecho() {
		return panelInferiorDerecho;
	}

	public Color[] getColores() {
		return colores;
	}

	public int getNumColores() {
		return colores.length;
	}

	public Color[] getSolucion() {
		return solucion;
	}

	public boolean isAcertaste() {
		return acertaste;
	}

	public void setAcertaste(boolean acertaste) {
		this.acertaste = acertaste;
	}
	

}

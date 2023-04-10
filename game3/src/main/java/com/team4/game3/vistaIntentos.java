package com.team4.game3;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Clase encargada de crear y gestionar la visializacion de los intentos
 * restantes en el juego.
 * 
 */
public class vistaIntentos {
	private JPanel panelIntentos; // Panel que contiene los intentos
	JLabel labelIntentos = new JLabel();
	int nivel;
	int maxIntentos;

	/**
	 * Contructor de la clase el que recibe por aprametro el nivel de dificultad del
	 * juego
	 * 
	 * @param niv nivel de dificultad del juego
	 */
	public vistaIntentos(String niv) {
		ajustarNivel(niv);
		crearPanel();
	}

	/**
	 * Recibe por parametro el nivel del juego, segun el que se haya seleccioando se
	 * ajusta el valor de 'maxIntentos' que es el numero de intentos maximo
	 * permitidos.
	 * 
	 * @param niv
	 */
	public void ajustarNivel(String niv) {
		switch (niv) {
		case "principiante":
			maxIntentos = 10;
			break;
		case "medio":
			maxIntentos = 8;
			break;
		case "avanzado":
			maxIntentos = 6;
			break;
		default:
			maxIntentos = 10;
			break;
		}
	}

	/**
	 * Muestra la informacion de los intentos restantes del juego. Inicializa
	 * 'panelIntentos' y la etiqueta 'labelIntentos' encargados de mostrar la
	 * cantidad de intentos disponibles.
	 */
	public void crearPanel() {
		panelIntentos = new JPanel();
		panelIntentos.setBorder(new LineBorder(Color.BLACK, 1));
		panelIntentos.setBounds(450, 150, 230, 60);
		panelIntentos.setLayout(null);

		labelIntentos.setText("Intentos: " + maxIntentos);
		labelIntentos.setBounds(10, 8, 171, 44);
		labelIntentos.setHorizontalAlignment(SwingConstants.LEFT);
		panelIntentos.add(labelIntentos);
	}

	/**
	 * Devuelve el panelIntentos que contiene la informacion de los intentos
	 * restantes.
	 * 
	 * @return
	 */
	public JPanel getPanelIntentos() {
		return panelIntentos;
	}

	/**
	 * Actuliza la canridad de intentos restantes. Recibe por parametro la cantidad
	 * de intentos usados. 'labelIntentos' se actualiza con la cantidad de intentos
	 * restantes.
	 */
	public void nuevoIntento(int intento) {
		labelIntentos.setText("Intentos: " + (maxIntentos - intento));
	}
}

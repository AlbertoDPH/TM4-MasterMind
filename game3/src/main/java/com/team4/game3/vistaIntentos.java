package com.team4.game3;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class vistaIntentos {
	private JPanel panelIntentos; // Panel que contiene los intentos
	JLabel labelIntentos = new JLabel();
	int nivel;
	int maxIntentos;

	public vistaIntentos(String niv) {
		ajustarNivel(niv);
		crearPanel();
	}

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

	public JPanel getPanelIntentos() {
		return panelIntentos;
	}

	public void nuevoIntento(int intento) {
		labelIntentos.setText("Intentos: " + (maxIntentos - intento));
	}
}

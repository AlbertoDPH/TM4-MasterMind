package com.team4.game3;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class vistaComprobar extends JPanel {

	private JPanel comporobarColores;
	private JLabel bola;
	private int posicionBola = 10;
	private int posicionNuevoIntento = 0;
	private int posXComprobar;
	private int correctPositions = 0;
	private Color[] colores;
	private vistaPanelesDer panelesDer;

	vistaPanelesDer vp = new vistaPanelesDer();

	public vistaComprobar(Color[] colores, vistaPanelesDer panelesDer) {
		this.colores = colores;
		this.panelesDer = panelesDer;

		setBounds(10, 30, 450, 300);
		setLayout(null);
		crear_linea_bola(0);

	}

	public void crear_linea_bola(int posicionNuevoIntento) {
		comporobarColores = new JPanel();
		comporobarColores.setBounds(0, posicionNuevoIntento, 434, 47);
		add(comporobarColores);
		comporobarColores.setLayout(null);

		int i = 0;

		// Crea tantos Box como colores
		while (i < colores.length) {
			bola = new JLabel("");
			bola.setOpaque(true);
			bola.setBackground(new Color(255, 255, 255));
			bola.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			bola.setBounds(posicionBola, 10, 25, 25);

			// Agregue una propiedad para almacenar el índice actual del color en el JLabel
			bola.putClientProperty("colorIndex", 0);

			bola.addMouseListener(raton);

			i++;
			posicionBola += 35;

			comporobarColores.add(bola);
		}

		posicionBola = 10;

		if (colores.length == 8)
			posXComprobar = 300;
		else if (colores.length == 6)
			posXComprobar = 250;
		else
			posXComprobar = 150;

		JButton btnNewButton = new JButton("Comprobar");

		btnNewButton.addActionListener(comprobar);
		btnNewButton.setBounds(posXComprobar, 11, 98, 25);
		comporobarColores.add(btnNewButton);
	}

	MouseListener raton = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			JLabel clickedBola = (JLabel) e.getSource();
			int colorIndex = (int) clickedBola.getClientProperty("colorIndex");

			// Asigne el color según el índice actual
			clickedBola.setBackground(colores[colorIndex]);

			// Incremente el índice del color y actualice la propiedad en el JLabel
			colorIndex = (colorIndex + 1) % colores.length;
			clickedBola.putClientProperty("colorIndex", colorIndex);
		}
	};

	ActionListener comprobar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Color[] solucion = panelesDer.getSolucion();
			
			if (solucion != null) {
				correctPositions = 0;
				for (int i = 0; i < colores.length; i++) {
					JLabel currentBola = (JLabel) comporobarColores.getComponent(i);
					Color currentColor = currentBola.getBackground();

					if (currentColor.equals(solucion[i])) {
						correctPositions++;
						currentBola.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
					} else if (Arrays.asList(solucion).contains(currentColor)) {
						currentBola.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
					}

				}

			}
			if (correctPositions == colores.length) {

				// Descubrimos el panel 'Comcinación secreta'
				panelesDer.setAcertaste(true);
				panelesDer.actualizarPanelSolucion();

				JOptionPane.showMessageDialog(null, "LO HAS CONSEGUIDO");
				// Hacer visible el panel 'panelInferiorDerecho'

			} else {
				// Crear nueva línea de bolas y actualizar la interfaz de usuario
				crear_linea_bola(posicionNuevoIntento += 40);
				comporobarColores.repaint();

			}

		}
	};

}

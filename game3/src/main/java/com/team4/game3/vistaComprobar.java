package com.team4.game3;

import java.awt.Color;
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
	private JButton btnComprobarActual; // activa o desactiva el boton
	private JButton btnComprobarAnterior;
	private JLabel[] bolasAnteriores; // Controlamos las tiradas anteriores

	// vistaPanelesDer vp = new vistaPanelesDer();

	public vistaComprobar(Color[] colores, vistaPanelesDer panelesDer) {
		this.colores = colores;
		this.panelesDer = panelesDer;

		setBounds(10, 30, 450, 900);

		setLayout(null);
		crear_linea_bola(0);

	}

	public void crear_linea_bola(int posicionNuevoIntento) {
		// Deshabilita la tirada anterior
		if (bolasAnteriores != null) {
			for (JLabel bola : bolasAnteriores) {
				bola.removeMouseListener(raton); // Hace que no se puedan activar las bolas anteriores
			}
		}
		// Deshabilita el boton de la tirada anterior
		if (btnComprobarActual != null) {
			btnComprobarActual.setVisible(false);

		}
		// Oculta el boton btnComprobar de la tirada anterior
		if (btnComprobarAnterior != null) {
			btnComprobarAnterior.setVisible(false);
		}

		if (posicionNuevoIntento > 900) {
			JOptionPane.showMessageDialog(null, "Has agotado los intentos");
			btnComprobarActual.setEnabled(false);
			comporobarColores.setEnabled(false);

		}

		comporobarColores = new JPanel();
		comporobarColores.setBounds(0, posicionNuevoIntento, 434, 35);// *
//		comporobarColores.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));// *
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

		// Habilita el boton de la tirada actual
		btnNewButton.setEnabled(true);
		btnComprobarActual = btnNewButton;

		btnNewButton.addActionListener(comprobar);
		btnNewButton.setBounds(posXComprobar, 11, 98, 25);
		comporobarColores.add(btnNewButton);

		/*
		 * Crea el array con el numero de coleres, dentro del buble obtiene el component
		 * y lo castea para guardarlo en el array Por lo qeu este arrray contiene la
		 * tirada anterior con las bolas deshabilitdas a eventos de raton
		 */
		bolasAnteriores = new JLabel[colores.length];
		for (i = 0; i < colores.length; i++) {
			bolasAnteriores[i] = (JLabel) comporobarColores.getComponent(i);
		}
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
				int semiCorrectPositions = 0;

				for (int i = 0; i < colores.length; i++) {
					JLabel currentBola = (JLabel) comporobarColores.getComponent(i);
					Color currentColor = currentBola.getBackground();

					if (currentColor.equals(solucion[i])) {
						correctPositions++;
//						currentBola.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
					} else if (Arrays.asList(solucion).contains(currentColor)) {
						semiCorrectPositions++;
//						currentBola.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
					}

				}
				mostrarAciertos(correctPositions, semiCorrectPositions, posicionNuevoIntento + 40);

			}
			if (correctPositions == colores.length) {

				// Descubrimos el panel 'Comcinación secreta'
				panelesDer.setAcertaste(true);
				panelesDer.actualizarPanelSolucion();

				JOptionPane.showMessageDialog(null, "LO HAS CONSEGUIDO");
				// Hacer visible el panel 'panelInferiorDerecho'

			} else {
				// Crear nueva línea de bolas y actualizar la interfaz de usuario
				crear_linea_bola(posicionNuevoIntento += 70);
				comporobarColores.repaint();

			}

		}
	};

	public void mostrarAciertos(int numCorrectos, int numSemiaciertos, int posY) {
		JPanel aciertosPanel = new JPanel();
		aciertosPanel.setBounds(0, posY, 434, 20);

//		aciertosPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));// *
		aciertosPanel.setLayout(null);
		add(aciertosPanel);

		int startX = 13;
		int startY = 0;

		for (int i = 0; i < numCorrectos; i++) {
			JLabel correctLabel = new JLabel("");
			correctLabel.setOpaque(true);
			correctLabel.setBackground(Color.BLACK);

			correctLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			correctLabel.setBounds(startX, startY, 15, 15);
			aciertosPanel.add(correctLabel);
			startX += 35;
		}

		for (int i = 0; i < numSemiaciertos; i++) {
			JLabel semiCorrectLabel = new JLabel("");
			semiCorrectLabel.setOpaque(true);
			semiCorrectLabel.setBackground(Color.WHITE);
			semiCorrectLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			semiCorrectLabel.setBounds(startX, startY, 15, 15);
			aciertosPanel.add(semiCorrectLabel);
			startX += 35;
		}

		aciertosPanel.revalidate();
		aciertosPanel.repaint();
	}

}

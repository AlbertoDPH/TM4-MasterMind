package com.team4.game3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

/**
 * Clase encargada de mostrar el about del juego
 */
public class vistaAcercaDe extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public vistaAcercaDe() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		setTitle("Acerca De");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label1 = new JLabel(
				"<html>MASTERMIND <br><br> Autores: Alberto del Pozo, Andrea de Pezzo y Roger Gibert <br><br> Abril 2023");
		label1.setBounds(20, 24, 344, 113);
		contentPane.add(label1);

		setVisible(true);
	}

}

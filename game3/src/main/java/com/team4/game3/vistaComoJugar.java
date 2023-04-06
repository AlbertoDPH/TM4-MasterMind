package com.team4.game3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class vistaComoJugar extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public vistaComoJugar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 570, 435);
		setTitle("Como Jugar");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label1 = new JLabel("<html> Como jugar: <br><br> 1. Se crea un combinación de colores aleatoria <br><br>"
				+ "2. El jugador intenta adivinar la combinación de colores <br><br>"
				+ "3. Al terminar el turno: <br>"
				+ "- Una ficha negra indica que la de color es correcta y está en la posición adecuada<br>"
				+ "- Una ficha blanca indica que la de color es correcta pero no está en la posición adecuada <br><br>"
				+ "4. Si le quedan intentos, el jugador vuelve a intentar adivinar la combinación <br><br>"
				+ "5. El juego termina cuando el jugador adivina la combinación o se queda sin intentos <br><br>"
				+"_________________________________________________________ <br><br>"
				+ "Niveles:<br><br>"
				+ "- Principiante: 4 colores / 10 intentos <br> "
				+ "- Medio: 6 colores / 8 intentos <br> "
				+ "- Avanzado: 8 colores / 6 intentos </html>");
		label1.setVerticalAlignment(SwingConstants.TOP);
		label1.setBounds(20, 27, 524, 357);
		contentPane.add(label1);

		setVisible(true);
	}

}

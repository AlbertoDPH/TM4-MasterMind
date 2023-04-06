package com.team4.game3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaCambioColores extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private String nivel = "principiante";
	private int panelesVisibles = 0;

	private ArrayList<Color> colores = new ArrayList<>();

	private ArrayList<JPanel> paneles = new ArrayList<>();

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JPanel panel7 = new JPanel();
	private JPanel panel8 = new JPanel();

	public JButton buttonAceptar;

	public vistaCambioColores(String niv) {
		setResizable(false);
		nivel = niv;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, calcFrameWidth(niv), 200);
		setTitle("Opciones de juego");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// -----------------------------------------------------------------------------

		panel1.setBounds(5, 20, 75, 75);
		panel1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel1);

		panel2.setBounds(85, 20, 84, 75);
		panel2.setBackground(Color.WHITE);
		contentPane.add(panel2);

		panel3.setBounds(174, 20, 84, 75);
		panel3.setBackground(Color.WHITE);
		contentPane.add(panel3);

		panel4.setBounds(263, 20, 75, 75);
		panel4.setBackground(Color.WHITE);
		contentPane.add(panel4);

		panel5.setBounds(343, 20, 75, 75);
		panel5.setBackground(Color.WHITE);
		contentPane.add(panel5);

		panel6.setBounds(423, 20, 75, 75);
		panel6.setBackground(Color.WHITE);
		contentPane.add(panel6);

		panel7.setBounds(503, 20, 75, 75);
		panel7.setBackground(Color.WHITE);
		contentPane.add(panel7);

		panel8.setBounds(583, 20, 80, 75);
		panel8.setBackground(Color.WHITE);
		contentPane.add(panel8);

		// -----------------------------------------------------------------------------

		paneles.add(panel1);
		paneles.add(panel2);
		paneles.add(panel3);
		paneles.add(panel4);
		paneles.add(panel5);
		paneles.add(panel6);
		paneles.add(panel7);
		paneles.add(panel8);

		// -----------------------------------------------------------------------------

		panel1.addMouseListener(panelClicked);
		panel2.addMouseListener(panelClicked);
		panel3.addMouseListener(panelClicked);
		panel4.addMouseListener(panelClicked);
		panel5.addMouseListener(panelClicked);
		panel6.addMouseListener(panelClicked);
		panel7.addMouseListener(panelClicked);
		panel8.addMouseListener(panelClicked);

		// -----------------------------------------------------------------------------

		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(((calcFrameWidth(niv) / 2) - 140), 115, 100, 25);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(((calcFrameWidth(niv) / 2) + 40), 115, 100, 25);
		contentPane.add(buttonCancelar);
		buttonCancelar.addActionListener(cancelarActionListener);

		// -----------------------------------------------------------------------------
		comprovarPanelesVisibles();

		setVisible(true);
	}

	ActionListener cancelarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};
	
	MouseAdapter panelClicked = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
			if (newColor != null) {
				e.getComponent().setBackground(newColor);
			}
		}
	};

	public ArrayList<Color> crearColores() {
		for (int i = 0; i < panelesVisibles; i++) {
			colores.add(paneles.get(i).getBackground());
		}
		return colores;
	}

	// -----------------------------------------------------------------------------
	public int calcFrameWidth(String niv) {
		int width = 0;

		switch (niv) {
		case "principiante":
			width = 360;
			break;
		case "medio":
			width = 520;
			break;
		case "avanzado":
			width = 685;
			break;
		}
		return width;
	};

	// -----------------------------------------------------------------------------
	public void comprovarPanelesVisibles() {
		if (nivel == "principiante") {
			panelesVisibles = 4;
			panel5.setVisible(false);
			panel6.setVisible(false);
			panel7.setVisible(false);
			panel8.setVisible(false);
		} else if (nivel == "medio") {
			panelesVisibles = 6;
			panel5.setVisible(true);
			panel6.setVisible(true);
			panel7.setVisible(false);
			panel8.setVisible(false);
		} else if (nivel == "avanzado") {
			panelesVisibles = 8;
			panel5.setVisible(true);
			panel6.setVisible(true);
			panel7.setVisible(true);
			panel8.setVisible(true);
		}
	}
}

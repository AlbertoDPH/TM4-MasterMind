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
	
	private ArrayList<Color> colores = new ArrayList<>();
	
	private ArrayList<JPanel> paneles = new ArrayList<>();
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();

	public vistaCambioColores() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 250);
		setTitle("Opciones de juego");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// -----------------------------------------------------------------------------
		panel1.setBackground(new Color(255, 255, 255));
		panel1.setBounds(14, 35, 80, 80);
		contentPane.add(panel1);
		
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(108, 35, 80, 80);
		contentPane.add(panel2);
		
		panel3.setBackground(Color.WHITE);
		panel3.setBounds(202, 35, 80, 80);
		contentPane.add(panel3);
		
		panel4.setBackground(Color.WHITE);
		panel4.setBounds(296, 35, 80, 80);
		contentPane.add(panel4);
		
		panel5.setBackground(Color.WHITE);
		panel5.setBounds(390, 35, 80, 80);
		contentPane.add(panel5);
		
		panel6.setBackground(Color.WHITE);
		panel6.setBounds(484, 35, 80, 80);
		contentPane.add(panel6);

		// -----------------------------------------------------------------------------
		panel1.addMouseListener(panelClicked);
		panel2.addMouseListener(panelClicked);
		panel3.addMouseListener(panelClicked);
		panel4.addMouseListener(panelClicked);
		panel5.addMouseListener(panelClicked);
		panel6.addMouseListener(panelClicked);
		
		paneles.add(panel1);
		paneles.add(panel2);
		paneles.add(panel3);
		paneles.add(panel4);
		paneles.add(panel5);
		paneles.add(panel6);
		
		// -----------------------------------------------------------------------------
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(187, 152, 89, 23);
		contentPane.add(buttonAceptar);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(307, 152, 89, 23);
		contentPane.add(buttonCancelar);
		
		// -----------------------------------------------------------------------------
		buttonAceptar.addActionListener(aceptarActionListener);
		buttonCancelar.addActionListener(cancelarActionListener);
	
		// -----------------------------------------------------------------------------
		comprovarPanelesVisibles();
		
		setVisible(true);
	}
	
	ActionListener aceptarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int numPanelesVisibles = 0;
			if(nivel == "principiante"){
				numPanelesVisibles = 4;
			} else if(nivel == "medio"){
				numPanelesVisibles = 5;
			} else if(nivel == "avanzado"){
				numPanelesVisibles = 6;
			}
			
			for(int i = 0; i < numPanelesVisibles; i++) {
				colores.add(paneles.get(i).getBackground());
			}
			dispose();
		}
	};
	
	ActionListener cancelarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};
	
	MouseAdapter panelClicked = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
			if(newColor != null) {
				e.getComponent().setBackground(newColor);
			}
		}
	};
	
	// -----------------------------------------------------------------------------
	public void comprovarPanelesVisibles() {
		if(nivel == "principiante"){
			panel5.setVisible(false);
			panel6.setVisible(false);
		} else if(nivel == "medio"){
			panel5.setVisible(true);
			panel6.setVisible(false);
		} else if(nivel == "avanzado"){
			panel5.setVisible(true);
			panel6.setVisible(true);
		}
	}
}

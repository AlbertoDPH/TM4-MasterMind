package com.team4.game3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaNivel extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private ButtonGroup rButtonsGroup = new ButtonGroup();
	public String nivelString = "principiante";

	public vistaNivel() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		setTitle("Seleccionar nivel");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Crea los JRadioButton para cada nivel
		JRadioButton rButtonPrincipiante = new JRadioButton("Principiante");
		rButtonPrincipiante.setBounds(90, 33, 109, 23);
		contentPane.add(rButtonPrincipiante);
		rButtonPrincipiante.setActionCommand("principiante");
		rButtonPrincipiante.setSelected(true);

		JRadioButton rButtonMedio = new JRadioButton("Medio");
		rButtonMedio.setBounds(90, 89, 109, 23);
		contentPane.add(rButtonMedio);
		rButtonMedio.setActionCommand("medio");

		JRadioButton rButtonAvanzado = new JRadioButton("Avanzado");
		rButtonAvanzado.setBounds(90, 145, 109, 23);
		contentPane.add(rButtonAvanzado);
		rButtonAvanzado.setActionCommand("avanzado");

		// Añades los radioButtons al grupo rButtonsGroup
		rButtonsGroup.add(rButtonPrincipiante);
		rButtonsGroup.add(rButtonMedio);
		rButtonsGroup.add(rButtonAvanzado);

		// Crea los botones
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(35, 210, 89, 23);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(159, 210, 89, 23);
		contentPane.add(buttonCancelar);

		// Añade los ActionListeners a los botones
		buttonAceptar.addActionListener(aceptarActionListener);
		buttonCancelar.addActionListener(cancelarActionListener);

		setVisible(true);
	}

	// Asigna a nivelString el nivel según el JRadioButton seleccionado
	ActionListener aceptarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nivelString = rButtonsGroup.getSelection().getActionCommand();
			dispose();
		}
	};

	// Asigna a nivelString el nivel principiante
	ActionListener cancelarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nivelString = "principiante"; 
			dispose();
		}
	};
	
	// Devuelve el nivel actual (valor de nivelString)
	public String getNivel() {
		return nivelString;
	}
}

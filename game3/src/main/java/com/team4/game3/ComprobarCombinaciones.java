package com.team4.game3;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class ComprobarCombinaciones extends JFrame {

	private JPanel contentPane;
	private JPanel comporobarColores;
	private JLabel bola;
	private int posicionBola = 10;
	private int posicionNuevoIntento = 0;
	private int vecesClicado = 0;
	
	/**
	 * Create the frame.
	 */
	public ComprobarCombinaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		crear_linea_bola(0);
		
	}
	
	public void crear_linea_bola(int posicionNuevoIntento) {
		comporobarColores = new JPanel();
		comporobarColores.setBounds(0, posicionNuevoIntento, 434, 47);
		contentPane.add(comporobarColores);
		comporobarColores.setLayout(null);
		
		int i = 0;
		
		while(i < 4) {
			bola = new JLabel("");
			bola.setOpaque(true);
			bola.setBackground(new Color(255, 255, 255));
			Border blackline = BorderFactory.createLineBorder(Color.black);
			bola.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			bola.setBounds(posicionBola, 10, 25, 25);
			bola.addMouseListener(raton);
			
			i++;
			posicionBola += 35;
			
			comporobarColores.add(bola);
		}
		
		posicionBola = 10;
		
		JButton btnNewButton = new JButton("Comprobar");
		btnNewButton.addActionListener(comprobar);
		btnNewButton.setBounds(150, 11, 98, 25);
		comporobarColores.add(btnNewButton);
		
		setVisible(true);
	}
	
	MouseListener raton = new MouseListener() {  
	    public void mouseClicked(MouseEvent e) {
	    	vecesClicado += 1;
	    	System.out.println(vecesClicado);
	    	
	    	switch (vecesClicado) { 
		        case 1:
		        	bola.setBackground(Color.BLUE);
		         break;
		        case 2:
		        	
		        	bola.setBackground(Color.RED);
		         break;
		        case 3:
		        	bola.setBackground(Color.GREEN);
		         break;
		        case 4:
		        	bola.setBackground(Color.YELLOW);
					vecesClicado = 0;
		         break;
	    	}
	    }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		} 
	}; 
	
	ActionListener comprobar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			boolean estaElColor = true;
			boolean estaEnPosicion = false;
			int posicionBolaresul = 274;
			
			System.out.println("boton clicado");
			
			int i = 0;
			while(i < 4) {
				JLabel bolaresul = new JLabel("");
				bolaresul.setOpaque(true);
				
				if(estaElColor == true) {
					bolaresul.setBackground(Color.WHITE);
				} else if (estaEnPosicion == true ){
					bolaresul.setBackground(Color.BLACK);
				}
				
				bolaresul.setBounds(posicionBolaresul, 11, 25, 25);
				comporobarColores.add(bolaresul);
				comporobarColores.repaint();
				
				posicionBolaresul += 35;
				i++;
			}
			
			crear_linea_bola(posicionNuevoIntento += 40);
			comporobarColores.repaint();
		}
	};
}

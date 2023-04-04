package com.team4.game3;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.util.Random;

public class vistaPanelesDer {
    private JPanel panelSuperiorDerecho;
    private JPanel panelInferiorDerecho;
    private Color[] colores;
    private Color[] solucion;

    public vistaPanelesDer() {
        // Inicializa con 4 colores por defecto
        inicializarColores(4);
        crearColores();
        crearSolucion();
    }

    public void inicializarColores(int numColores) {
        colores = new Color[numColores];
        // Colores disponibles
        colores[0] = Color.RED;
        colores[1] = Color.BLUE;
        colores[2] = Color.GREEN;
        colores[3] = Color.YELLOW;

        if (numColores >= 6) {
            colores[4] = Color.ORANGE;
            colores[5] = Color.MAGENTA;
        }

        if (numColores == 8) {
            colores[6] = Color.CYAN;
            colores[7] = Color.PINK;
        }
    }

    public void crearColores() {
        panelSuperiorDerecho = new JPanel();
        panelSuperiorDerecho.setBounds(450, 50, 180, 60);
        panelSuperiorDerecho.setLayout(new GridLayout(1, colores.length, 20, 20));

        Border outerBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border innerBorder = BorderFactory.createEmptyBorder(20, 10, 10, 10);
        Border compoundBorder1 = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
        panelSuperiorDerecho.setBorder(BorderFactory.createTitledBorder(compoundBorder1, "Colores Disponibles"));

        for (Color color : colores) {
            JPanel bolaColor = new JPanel();
            bolaColor.setBackground(color);
            bolaColor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            panelSuperiorDerecho.add(bolaColor);
        }
    }


    public void crearSolucion() {
        panelInferiorDerecho = new JPanel();
        panelInferiorDerecho.setBounds(450, 200, 180, 60);
        panelInferiorDerecho.setLayout(new GridLayout(1, colores.length,20,20));

        Border outerBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border innerBorder = BorderFactory.createEmptyBorder(20, 10, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
        panelInferiorDerecho.setBorder(BorderFactory.createTitledBorder(compoundBorder, "Combinación secreta"));

        // El panel de solución no seravisible inicialmente
        panelInferiorDerecho.setVisible(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        solucion = new Color[colores.length];
        Random rand = new Random();
        for (int i = 0; i < colores.length; i++) {
            int randomIndex = rand.nextInt(colores.length);
            solucion[i] = colores[randomIndex];
            JPanel bolaSolucion = new JPanel();
            bolaSolucion.setBackground(solucion[i]);
            bolaSolucion.setBorder(border);
            panelInferiorDerecho.add(bolaSolucion);
        }
    }

    public JPanel getPanelSuperiorDerecho() {
        return panelSuperiorDerecho;
    }

    public JPanel getPanelInferiorDerecho() {
        return panelInferiorDerecho;
    }
}

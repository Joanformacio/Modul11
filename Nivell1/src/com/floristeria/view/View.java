package com.floristeria.view;

import java.awt.*;
import java.awt.List;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import com.floristeria.dao.*;
import com.floristeria.models.*;

public class View extends JFrame {
	FloristeriaDaoImpl floristeria;
	
	public <T> View() {
		String opCancel= "operacion cancelada";
		
		
		
		JLabel Lbl1 = new JLabel("Nombre Floristeria");
		JLabel LbNomFloristeria = new JLabel();

		JLabel LblCmbDecoracio = new JLabel("Tipos de Decoracion");
		JLabel LblTextArea = new JLabel("Stock disponible");

		LblCmbDecoracio.setHorizontalAlignment(JLabel.CENTER);
		LblTextArea.setHorizontalAlignment(JLabel.LEFT);

		JButton BtnAfegirFloristeria = new JButton(" Anadir Floristeria");
		JButton BtnAfegirArbre = new JButton(" Añadir Arbol");
		JButton BtnAfegirFlor = new JButton(" Añadir color flor");
		JButton BtnLimpiarTextArea = new JButton("Limpiar  Resultados");
		JButton BtnListarStock = new JButton("Listar Stock");
		
		JButton BtnSalir = new JButton("Salir");
		
		BtnAfegirArbre.setEnabled(false);
		BtnAfegirFlor.setEnabled(false);
		BtnListarStock.setEnabled(false);
		BtnLimpiarTextArea.setEnabled(false);

		JComboBox cmdTiposDecoracion = new JComboBox();

		cmdTiposDecoracion.addItem("Selecciona tipo decoracion");
		cmdTiposDecoracion.addItem("Fusta");
		cmdTiposDecoracion.addItem("Plàstic");
		cmdTiposDecoracion.setEnabled(false);

		JTextArea jtaStock = new JTextArea();
		jtaStock.setBounds(22,20, 206, 500);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jtaStock.add(scroll);
		Container cp = getContentPane();

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		
		
		cp.setLayout(new GridLayout(5, 1));
		p1.setLayout(new GridLayout(2, 3));
		p2.setLayout(new GridLayout(1, 4));
		p3.setLayout(new GridLayout(1, 2));
		p4.setLayout(new GridLayout(2, 1));
		p5.setLayout(new BorderLayout());
		
		
		
		cp.add(p1);
		cp.add(p2);
		cp.add(p3);
		cp.add(p4);
		cp.add(p5);
		
		
		
		p1.add(Lbl1);
		p1.add(LbNomFloristeria);
		p1.add(BtnAfegirFloristeria);

		p2.add(BtnAfegirArbre);
		p2.add(BtnAfegirFlor);
		p2.add(BtnListarStock);
		
		p4.add(BtnLimpiarTextArea);
		p4.add(BtnSalir);
		
		p4.add(LblCmbDecoracio);
		p4.add(cmdTiposDecoracion);
		p4.add(LblTextArea);
		
		p5.add(jtaStock, BorderLayout.CENTER);
		
		pack();

		// Logica botons;
		BtnAfegirFloristeria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomFloristeria = JOptionPane.showInputDialog("Indica nombre para Floristeria");
				if (nomFloristeria == null) {
					jtaStock.setText(opCancel);
				}else {
					LbNomFloristeria.setText(nomFloristeria);
					floristeria = new FloristeriaDaoImpl(nomFloristeria);
					BtnAfegirArbre.setEnabled(true);
					BtnAfegirFlor.setEnabled(true);
					BtnListarStock.setEnabled(true);
					BtnLimpiarTextArea.setEnabled(true);
					cmdTiposDecoracion.setEnabled(true);
				}
			}
		});

		BtnAfegirArbre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String altura = JOptionPane.showInputDialog("Indica la altura del Arbol");
				String preu = JOptionPane.showInputDialog("Indica el precio del arbol");
				
				if (altura==null || preu== null) {
					jtaStock.setText(opCancel);
				}else {
					try {
						double alturaAbre= Double.parseDouble(altura);
						double preuAbre= Double.parseDouble(preu);
						Arbre arbre = new Arbre(alturaAbre, preuAbre);
						floristeria.AddArbreFlorisDaoImpl(arbre);
					} catch (Exception e1) {
					
						System.out.println(e1.getMessage());
					}
				}

			}
		});

		BtnAfegirFlor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String colorFlor = JOptionPane.showInputDialog("Indica el color de la flor");
				String preu = JOptionPane.showInputDialog("Indica el precio de la flor");
				if (colorFlor== null || preu == null) {
					jtaStock.setText(opCancel);
				}else {
					try {
						double preuFlor = Double.parseDouble(preu);
						Flor flor = new Flor(colorFlor, preuFlor);
						floristeria.AddFlorFlorisDaoImpl(flor);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
					}
				}
				

			}
		});

		BtnLimpiarTextArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jtaStock.setText("");

			}
		});

		cmdTiposDecoracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tipus = (String) cmdTiposDecoracion.getSelectedItem();
				String preu = JOptionPane.showInputDialog("Indica el precio de la decoracion");
				
				if (tipus == null || preu == null) {
					jtaStock.setText(opCancel);
				}else {
					try {
						double preuDeco = Double.parseDouble(preu);
						Decoracio decoracio = new Decoracio(tipus, preuDeco);
						floristeria.AddDecoFlorisDaoImpl(decoracio);
					} catch (Exception e1) {

						System.out.println(e1.getMessage());
					}
				}
				
				
			}
		});

		BtnListarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stock = floristeria.Listar_Stock();

				jtaStock.setText(stock);
			}
		});
		BtnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}

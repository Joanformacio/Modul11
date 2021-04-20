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
		JButton BtnRetirarArbre = new JButton("Eliminar arbol");
		JButton BtnRetirarFlor = new JButton("Eliminar flor");
		JButton BtnRetirarDeco = new JButton("Eliminar Decoracion");
		JButton BtnMostarValor = new JButton("$");
		JButton BtnSalir = new JButton("Salir");
		
		
		BtnAfegirArbre.setEnabled(false);
		BtnAfegirFlor.setEnabled(false);
		BtnListarStock.setEnabled(false);
		BtnLimpiarTextArea.setEnabled(false);
		BtnRetirarArbre.setEnabled(false);
		BtnRetirarFlor.setEnabled(false);
		BtnRetirarDeco.setEnabled(false);
		BtnMostarValor.setEnabled(false);

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
		JPanel p6 = new JPanel();
		
		cp.setLayout(new GridLayout(6, 1));
		p1.setLayout(new GridLayout(1, 3));
		p2.setLayout(new GridLayout(1, 5));
		p3.setLayout(new GridLayout(1, 5));
		p4.setLayout(new GridLayout(1, 3));
		p5.setLayout(new GridLayout(1, 3));
		p6.setLayout(new GridLayout(2, 1));
		
		
		
		cp.add(p1);
		cp.add(p2);
		cp.add(p3);
		cp.add(p4);
		cp.add(p5);
		cp.add(p6);
		
		
		p1.add(Lbl1);
		p1.add(LbNomFloristeria);
		p1.add(BtnAfegirFloristeria);

		p2.add(BtnAfegirArbre);
		p2.add(BtnAfegirFlor);
		p2.add(BtnListarStock);
		p2.add(BtnLimpiarTextArea);
		p2.add(BtnSalir);
		p3.add(BtnRetirarArbre);
		p3.add(BtnRetirarFlor);
		p3.add(BtnRetirarDeco);
		p3.add(BtnMostarValor);
		p4.add(LblTextArea);
		p4.add(LblCmbDecoracio);
		p4.add(cmdTiposDecoracion);
		
			
		
		p5.add(jtaStock);
		
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
					BtnRetirarArbre.setEnabled(true);
					BtnRetirarFlor.setEnabled(true);
					BtnRetirarDeco.setEnabled(true);
					BtnMostarValor.setEnabled(true);
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
		
		BtnMostarValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  valor = Double.toString(floristeria.Hasvaluemoney());
				jtaStock.setText(valor);
			}
		});
		
		BtnRetirarArbre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Indica la id del elemento Abre");
				if (id == null) {
					jtaStock.setText(opCancel);
				} else {

					int idArbre = Integer.parseInt(id);

					floristeria.DelElementToListArbre(idArbre);
				}
			}
		});
		
		BtnRetirarFlor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Indica la id del elemento Flor");
				
				if (id == null) {
					jtaStock.setText(opCancel);
				} else {
					int idFlor = Integer.parseInt(id);

					floristeria.DelElementToListFlor(idFlor);
				}

			}
		});
		
		BtnRetirarDeco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Indica la id del elemento Decoracion");
				if (id == null) {
					jtaStock.setText(opCancel);
				} else {
					int idDec = Integer.parseInt(id);

					floristeria.DelElementToListDec(idDec);
				}
			}
		});
		
		BtnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}

package com.floristeria.models;

import java.util.*;

public class Floristeria {
	private List<Arbre> listArbres=  new ArrayList<Arbre>();
	private List<Flor> listFlors = new ArrayList<Flor>();
	private List<Decoracio> listDecoracio= new ArrayList<Decoracio>();
	private String nom;
	
	public void setListArbres(List<Arbre> listArbres) {
		this.listArbres = listArbres;
	}

	public void setListFlors(List<Flor> listFlors) {
		this.listFlors = listFlors;
	}

	public void setListDecoracio(List<Decoracio> listDecoracio) {
		this.listDecoracio = listDecoracio;
	}

	public Floristeria(String nom) throws Exception {
		if ( nom.equals("")) throw new Exception("the name of florist can not to be empty");
		this.nom=nom;
	}

	public List<Arbre> getListArbres() {
		return listArbres;
	}
	


	public List<Flor> getListFlors() {
		return listFlors;
	}

	public List<Decoracio> getListDecoracio() {
		return listDecoracio;
	}

	public void setDecoracioToList(Decoracio decoracio) {
		this.listDecoracio.add(decoracio);
	}

	public void setArbreToList(Arbre arbre) {
		this.listArbres.add(arbre);
	}
	public void setFlorToList(Flor flor) {
		this.listFlors.add(flor);
	}

	

	

	public String getNom() {
		return nom;
	}
	
	
}

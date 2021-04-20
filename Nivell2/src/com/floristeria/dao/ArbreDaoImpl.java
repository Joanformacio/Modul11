package com.floristeria.dao;

import java.util.List;

import com.floristeria.models.Arbre;

public class ArbreDaoImpl implements IArbreDao {
		Arbre arbre;
	public ArbreDaoImpl(Arbre arbre) {
		this.arbre= arbre;
	}

	@Override
	public Double ObtenirPreu(Arbre arbre) {
		
		return this.arbre.getPreu();
	}

	@Override
	public Arbre ActualitzarAbre( Double altura, Double preu) {
		
		this.arbre.setPreu(preu);
		this.arbre.setAltura(altura);
		return arbre;
	}


	
}

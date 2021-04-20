package com.floristeria.dao;

import java.util.List;

import com.floristeria.models.Arbre;

public interface IArbreDao {
	
	public Double ObtenirPreu(Arbre arbre);
	public Arbre  ActualitzarAbre( Double altura, Double preu);
	
}

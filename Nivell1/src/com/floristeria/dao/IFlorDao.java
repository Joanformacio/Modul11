package com.floristeria.dao;


import com.floristeria.models.Flor;

public interface IFlorDao  {
	public Double ObtenirPreu(Flor flor);
	public Flor  ActualitzarAbre(Flor flor, String color, Double preu);
}

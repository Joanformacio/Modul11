package com.floristeria.dao;

import java.util.List;

import com.floristeria.models.Decoracio;

public interface IDecorationDao {
	public List<Decoracio> ListarDecoracions();
	public double ObtenirPreu (int id);
	public void ActualitzarPreu(double preu, int id);
}

package com.floristeria.dao;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.models.Flor;

public class FlorDaoImpl implements IFlorDao{

	@Override
	public Double ObtenirPreu(Flor flor) {
		
		return flor.getPreu();
	}

	@Override
	public Flor ActualitzarAbre(Flor flor, String color, Double preu) {
		flor.setColor(color);
		flor.setPreu(preu);
		return flor;
	}
	
}

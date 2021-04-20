package com.floristeria.dao;

import java.util.ArrayList;
import java.util.List;

import com.floristeria.models.Decoracio;

public class DecorationDaoImpl implements IDecorationDao{
	List<Decoracio> decoracions = new ArrayList<Decoracio>();
	
	public DecorationDaoImpl() {
		try {
			Decoracio decoracio1 = new Decoracio("Fusta", 0);
			Decoracio decoracio2 = new Decoracio("Plastic", 0);
			decoracions.add(decoracio1);
			decoracions.add(decoracio2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public List<Decoracio> ListarDecoracions() {
		return this.decoracions;
	}

	@Override
	public double ObtenirPreu(int id) {
		double preu=0;
		for (Decoracio d: this.decoracions) {
			if (d.getId()== id) {
				preu= d.getPreu();
			}
		}
		return preu;
	}

	@Override
	public void ActualitzarPreu(double preu, int id) {
		
		for (Decoracio d: this.decoracions) {
			if (d.getId()== id) {
				d.setPreu(preu);
			}
		}
	}

	
}

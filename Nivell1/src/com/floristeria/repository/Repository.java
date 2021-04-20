package com.floristeria.repository;


import java.util.List;

import com.floristeria.dao.*;
import com.floristeria.models.*;

public class Repository {
	Floristeria floristeria;
	StringBuilder s= new StringBuilder();
	public Repository(Floristeria floristeria) {
		this.floristeria=floristeria;
	}
	public Floristeria getFloristeria() {
		return floristeria;
	}
	
	public void AddArbreToStock(Arbre arbre) {
		floristeria.setArbreToList(arbre);
	}
	
	public void AddFlorToStock(Flor flor) {
		floristeria.setFlorToList(flor);
	}
	
	public void AddDecoracioToStock(Decoracio dec) {
		floristeria.setDecoracioToList(dec);
	}
	
	public String ObtenerStock() {
		List<Arbre> totalMoneyArbres=floristeria.getListArbres();
		List<Flor> totalMoneyFlors=floristeria.getListFlors();
		List<Decoracio> totalMoneyDecoracio= floristeria.getListDecoracio();
		StringBuilder s= new StringBuilder();
		
		s.append("Lista de Arbole\n");
		
		 totalMoneyArbres.stream()
				.forEach(a ->  s.append("    " +a));
				
		 s.append("\nLista de Flores\n");
		 
		 totalMoneyFlors.stream()
		 		.forEach(f -> s.append("    " +f));
		
		 s.append("\nLista de Decoracio\n");
		totalMoneyDecoracio.stream()
				.forEach(d -> s.append("    " +d));
		
		return s.toString();
	}
	
	
	public double ObtenerVolumenMonetarioStock() {
		double totalMoneySaved;
		List<Arbre> totalMoneyArbres=floristeria.getListArbres();
		List<Flor> totalMoneyFlors=floristeria.getListFlors();
		List<Decoracio> totalMoneyDecoracio= floristeria.getListDecoracio();
		
		totalMoneySaved = totalMoneyArbres.stream()
				.mapToDouble(a ->  a.getPreu())
				.sum();
		
		totalMoneySaved = totalMoneyFlors.stream()
				.mapToDouble(f ->  f.getPreu())
				.sum();
		totalMoneySaved = totalMoneyDecoracio.stream()
				.mapToDouble(d ->  d.getPreu())
				.sum();
		return (double) totalMoneySaved;
	}
}

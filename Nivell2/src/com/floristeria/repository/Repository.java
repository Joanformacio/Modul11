package com.floristeria.repository;

import java.util.Arrays;
import java.util.List;

import com.floristeria.dao.*;
import com.floristeria.models.*;

public class Repository {
	Floristeria floristeria;
	StringBuilder s = new StringBuilder();

	public Repository(Floristeria floristeria) {
		this.floristeria = floristeria;
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

	public void DelFlorToList(int id) {
		List<Flor> listflor = floristeria.getListFlors();
		
		listflor.removeIf(f -> f.getID_FLOR()==id);
		
		
	}

	public void DelArbreToList(int id) {
		List<Arbre> listArbre = floristeria.getListArbres();

		listArbre.removeIf(a -> a.getID_ARBRE()==id);

	}

	public void DelDecoracioToList(int id) {
		List<Decoracio> listDec = floristeria.getListDecoracio();
		listDec.removeIf(d -> d.getId()==id);
	}

	public String ObtenerStock() {
		List<Arbre> totalMoneyArbres = floristeria.getListArbres();
		List<Flor> totalMoneyFlors = floristeria.getListFlors();
		List<Decoracio> totalMoneyDecoracio = floristeria.getListDecoracio();
		StringBuilder s = new StringBuilder();

		s.append("Lista de Arbole\n");

		totalMoneyArbres.stream().forEach(a -> s.append("    " + a + "\n"));

		s.append("\nLista de Flores\n");

		totalMoneyFlors.stream().forEach(f -> s.append("    " + f + "\n"));

		s.append("\nLista de Decoracio\n");
		totalMoneyDecoracio.stream().forEach(d -> s.append("    " + d + "\n"));

		return s.toString();
	}

	public double ObtenerVolumenMonetarioStock() {
		double totalMoneySaved = 0;
		List<Arbre> totalMoneyArbres = floristeria.getListArbres();
		List<Flor> totalMoneyFlors = floristeria.getListFlors();
		List<Decoracio> totalMoneyDecoracio = floristeria.getListDecoracio();

		totalMoneySaved += totalMoneyArbres.stream().mapToDouble(a -> a.getPreu()).sum();

		totalMoneySaved += totalMoneyFlors.stream().mapToDouble(f -> f.getPreu()).sum();
		totalMoneySaved += totalMoneyDecoracio.stream().mapToDouble(d -> d.getPreu()).sum();
		return (double) totalMoneySaved;
	}
}

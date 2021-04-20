package com.floristeria.dao;



import com.floristeria.models.*;
import com.floristeria.repository.*;

public class FloristeriaDaoImpl implements IFloristeriaDao {
	private Floristeria floristeria;
	Repository repository;
	public FloristeriaDaoImpl(String nom) {
		try {
			this.floristeria= new Floristeria(nom);
			 this.repository= new Repository(this.floristeria);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void AddArbreFlorisDaoImpl(Arbre arbre) {
		repository.AddArbreToStock(arbre);
	}
	
	public void AddFlorFlorisDaoImpl(Flor flor) {
		repository.AddFlorToStock(flor);
	}
	
	public void AddDecoFlorisDaoImpl(Decoracio dec) {
		repository.AddDecoracioToStock(dec);;
	}
	
	public void DelElementToListFlor(int id) {
		repository.DelFlorToList(id);
	}
	
	public void DelElementToListDec(int id) {
		repository.DelDecoracioToList(id);;
	}
	
	public void DelElementToListArbre(int id) {
		System.out.println(id);
		repository.DelArbreToList(id);
	}
	
	@Override
	public  Floristeria getFloristeria(){
		
		return repository.getFloristeria();
	}

	@Override
	public String Listar_Stock() {
		 return repository.ObtenerStock();
				
		
	}

	@Override
	public double Hasvaluemoney() {
		return  repository.ObtenerVolumenMonetarioStock();
	}
	
}

package com.floristeria.models;

public class Arbre {
	private double preu;
	private double altura;
	private static  int ID_ARBRE=0;
	
	public Arbre(double altura, double preu) throws Exception {
		if (preu<0) throw new Exception("The field price  can not to be negative quantity");
		if (altura==0) throw new Exception("The field height can not to be zero");
		
		this.preu=preu;
		this.altura= altura;
		
		ID_ARBRE++;
	}
	
	
	public double getPreu() {
		return preu;
	}

	

	public static int getID_ARBRE() {
		return ID_ARBRE;
	}


	
	public double getAltura() {
		return altura;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}


	@Override
	public String toString() {
		return "Arbre [ID= "+ID_ARBRE+", preu=" + preu + ", altura=" + altura + "]";
	}

	
}

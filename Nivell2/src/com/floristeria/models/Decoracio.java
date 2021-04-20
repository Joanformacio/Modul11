package com.floristeria.models;



public class Decoracio {
	
	private double preu;
	private int id;
	private String tipusDecoracio;
	static int ID_DECORACION=1;
	
	public Decoracio(String tipusDecoracio, double preu) throws Exception {
		if (preu<0) throw new Exception("The field price  can not to be negative quantity");
		if (tipusDecoracio.equals("")) throw new Exception("The field decoration type can not empty");
		this.tipusDecoracio= tipusDecoracio;
		this.preu=preu;
		id= ID_DECORACION;
		ID_DECORACION++;
	}

	
	
	public  int getId() {
		return id;
	}



	public void setPreu(double preu) {
		this.preu = preu;
	}



	public double getPreu() {
		return preu;
	}

	public String getTipusDecoracio() {
		return tipusDecoracio;
	}

	public  int getIdDecoracion() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Decoracio [ID= "+id+", preu=" + preu + ", tipusDecoracio=" + tipusDecoracio + "]";
	}
	
}

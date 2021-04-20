package com.floristeria.models;



public class Decoracio {
	
	private double preu;
	private String tipusDecoracio;
	static int ID_DECORACION=0;
	
	public Decoracio(String tipusDecoracio, double preu) throws Exception {
		if (preu<0) throw new Exception("The field price  can not to be negative quantity");
		if (tipusDecoracio.equals("")) throw new Exception("The field decoration type can not empty");
		this.tipusDecoracio= tipusDecoracio;
		this.preu=preu;
		ID_DECORACION++;
	}

	
	
	public static int getId() {
		return ID_DECORACION;
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

	public static int getIdDecoracion() {
		return ID_DECORACION;
	}
	
	@Override
	public String toString() {
		return "Decoracio [ID= "+ID_DECORACION+", preu=" + preu + ", tipusDecoracio=" + tipusDecoracio + "]";
	}
	
}

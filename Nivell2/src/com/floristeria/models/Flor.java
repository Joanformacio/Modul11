package com.floristeria.models;

public class Flor {
	
	private String color;
	private double preu;
	private int id;
	private  static int ID_FLOR=1;
	
	public Flor(String color, double preu) throws Exception {
		if (color.equals("")) throw new Exception("The field color can not to be empty");
		this.color=color;
		if (preu<0) throw new Exception("The price  can not to be below zero");
		this.preu=preu;
		id= ID_FLOR;
		ID_FLOR++;
	}

	public String getColor() {
		return color;
	}

	public Double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public  int getID_FLOR() {
		return id;
	}

	@Override
	public String toString() {
		return "Flor [ID= "+ id+", color= " + color + ", preu= " + preu + "]";
	}

	
}

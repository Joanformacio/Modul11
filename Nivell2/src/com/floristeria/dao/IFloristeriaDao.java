package com.floristeria.dao;

import com.floristeria.models.Floristeria;

abstract interface IFloristeriaDao {
	Floristeria getFloristeria();
	String Listar_Stock();
	double Hasvaluemoney();
}

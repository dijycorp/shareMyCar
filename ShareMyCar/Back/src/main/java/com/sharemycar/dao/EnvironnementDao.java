package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entities.Environnement;

public interface EnvironnementDao {

//	crud principaux
	public Environnement insert(Environnement environnement);
	public void delete(Environnement environnement);
	public Environnement update(Environnement environnement);	
	public Environnement findById(Integer id);
	public List<Environnement> findAll();
	
}

package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entity.Environnement;

public interface EnvironnementService {

//	crud principaux
	public Environnement insert(Environnement environnement);
	public void delete(Environnement environnement);
	public Environnement update(Environnement environnement);	
	public Environnement findById(Integer id);
	public List<Environnement> findAll();
	
}

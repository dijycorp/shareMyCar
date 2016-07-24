package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entities.Pays;
import com.sharemycar.entities.Region;

public interface PaysService {

	// crud principaux
	public Pays insert(Pays pays);
	public void delete(Pays pays);
	public Pays update(Pays pays);
	public Pays findById(Integer id);
	public List<Pays> findAll();
	
//	action complémentaire
	public Pays LinkPaysToRegion(Pays pays, Region region);
	
}
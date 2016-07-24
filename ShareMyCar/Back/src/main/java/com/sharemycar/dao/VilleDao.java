package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entities.Ville;

public interface VilleDao {

	// crud principaux
	public Ville insert(Ville ville);
	public void delete(Ville ville);
	public Ville update(Ville ville);
	public Ville findById(Integer id);
	public List<Ville> findAll();
	
//	autre fonction

}
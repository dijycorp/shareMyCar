package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entities.Arrondissement;
import com.sharemycar.entities.Ville;

public interface ArrondissementDao {

	// crud principaux
	public Arrondissement insert(Arrondissement arrondissement);
	public void delete(Arrondissement arrondissement);
	public Arrondissement update(Arrondissement arrondissement);
	public Arrondissement findById(Integer id);
	public List<Arrondissement> findAll();

//	autre fonction
	public Arrondissement LinkArrondissementToVille(Arrondissement arrondissement, Ville ville);
	
}
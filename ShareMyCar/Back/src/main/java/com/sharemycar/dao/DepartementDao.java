package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entity.Arrondissement;
import com.sharemycar.entity.Departement;

public interface DepartementDao {

	// crud principaux
	public Departement insert(Departement departement);
	public void delete(Departement departement);
	public Departement update(Departement departement);
	public Departement findById(Integer id);
	public List<Departement> findAll();
	
//	autre fonction
	public Departement LinkDepartementToArrondissement(Departement departement, Arrondissement arrondissement);

}
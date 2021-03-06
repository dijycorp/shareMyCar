package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entities.Departement;
import com.sharemycar.entities.Region;

public interface RegionDao {

	// crud principaux
	public Region insert(Region region);
	public void delete(Region region);
	public Region update(Region region);
	public Region findById(Integer id);
	public List<Region> findAll();
	
//	autre fonction
	public Region LinkRegionToDepartement(Region region,Departement departement);

}
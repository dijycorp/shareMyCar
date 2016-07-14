package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.RegionDao;
import com.sharemycar.entity.Departement;
import com.sharemycar.entity.Region;
import com.sharemycar.service.RegionService;

@Service
@Transactional
public class RegionServiceSpring implements RegionService {

	@Autowired
	private RegionDao regionDao;
	
	@Override
	public Region insert(Region region) {
		// TODO Auto-generated method stub
		return regionDao.insert(region);
	}

	@Override
	public void delete(Region region) {
		// TODO Auto-generated method stub
		regionDao.delete(region);
	}

	@Override
	public Region update(Region region) {
		// TODO Auto-generated method stub
		return regionDao.update(region);
	}

	@Override
	public Region findById(Integer id) {
		// TODO Auto-generated method stub
		return regionDao.findById(id);
	}

	@Override
	public List<Region> findAll() {
		// TODO Auto-generated method stub
		return regionDao.findAll();
	}

	@Override
	public Region LinkRegionToDepartement(Region region, Departement departement) {
		// TODO Auto-generated method stub
		return regionDao.LinkRegionToDepartement(region, departement);
	}

	
}

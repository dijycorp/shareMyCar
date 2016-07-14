package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.DepartementDao;
import com.sharemycar.entity.Arrondissement;
import com.sharemycar.entity.Departement;
import com.sharemycar.service.DepartementService;

@Service
@Transactional
public class DepartementServiceSpring implements DepartementService {

	@Autowired
	private DepartementDao departementDao;
	
	@Override
	public Departement insert(Departement departement) {
		// TODO Auto-generated method stub
		return departementDao.insert(departement);
	}

	@Override
	public void delete(Departement departement) {
		// TODO Auto-generated method stub
		departementDao.delete(departement);
	}

	@Override
	public Departement update(Departement departement) {
		// TODO Auto-generated method stub
		return departementDao.update(departement);
	}

	@Override
	public Departement findById(Integer id) {
		// TODO Auto-generated method stub
		return departementDao.findById(id);
	}

	@Override
	public List<Departement> findAll() {
		// TODO Auto-generated method stub
		return departementDao.findAll();
	}

	@Override
	public Departement LinkDepartementToArrondissement(Departement departement, Arrondissement arrondissement) {
		// TODO Auto-generated method stub
		return departementDao.LinkDepartementToArrondissement(departement, arrondissement);
	}


	
}

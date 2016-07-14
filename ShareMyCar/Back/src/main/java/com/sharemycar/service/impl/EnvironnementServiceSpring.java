package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.EnvironnementDao;
import com.sharemycar.entity.Environnement;
import com.sharemycar.service.EnvironnementService;

@Service
@Transactional
public class EnvironnementServiceSpring implements EnvironnementService {

	@Autowired
	private EnvironnementDao environnementDao;
	
	@Override
	public Environnement insert(Environnement environnement) {
		// TODO Auto-generated method stub
		return environnementDao.insert(environnement);
	}

	@Override
	public void delete(Environnement environnement) {
		// TODO Auto-generated method stub
		environnementDao.delete(environnement);
	}

	@Override
	public Environnement update(Environnement environnement) {
		// TODO Auto-generated method stub
		return environnementDao.update(environnement);
	}

	@Override
	public Environnement findById(Integer id) {
		// TODO Auto-generated method stub
		return environnementDao.findById(id);
	}

	@Override
	public List<Environnement> findAll() {
		// TODO Auto-generated method stub
		return environnementDao.findAll();
	}



	

}

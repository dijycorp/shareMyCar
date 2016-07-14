package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.VilleDao;
import com.sharemycar.entity.Ville;
import com.sharemycar.service.VilleService;

@Service
@Transactional
public class VilleServiceSpring implements VilleService {

	@Autowired
	private VilleDao villeDao;
	
	@Override
	public Ville insert(Ville ville) {
		// TODO Auto-generated method stub
		return villeDao.insert(ville);
	}

	@Override
	public void delete(Ville ville) {
		// TODO Auto-generated method stub
		villeDao.delete(ville);
	}

	@Override
	public Ville update(Ville ville) {
		// TODO Auto-generated method stub
		return villeDao.update(ville);
	}

	@Override
	public Ville findById(Integer id) {
		// TODO Auto-generated method stub
		return villeDao.findById(id);
	}

	@Override
	public List<Ville> findAll() {
		// TODO Auto-generated method stub
		return villeDao.findAll();
	}

	
}

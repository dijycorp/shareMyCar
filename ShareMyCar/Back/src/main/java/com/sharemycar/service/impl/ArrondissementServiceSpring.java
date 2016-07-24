package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.ArrondissementDao;
import com.sharemycar.entities.Arrondissement;
import com.sharemycar.entities.Ville;
import com.sharemycar.service.ArrondissementService;

@Service
@Transactional
public class ArrondissementServiceSpring implements ArrondissementService {

	@Autowired
	private ArrondissementDao arrondissementDao;
	
	@Override
	public Arrondissement insert(Arrondissement arrondissement) {
		// TODO Auto-generated method stub
		return arrondissementDao.insert(arrondissement);
	}

	@Override
	public void delete(Arrondissement arrondissement) {
		// TODO Auto-generated method stub
		arrondissementDao.delete(arrondissement);
	}

	@Override
	public Arrondissement update(Arrondissement arrondissement) {
		// TODO Auto-generated method stub
		return arrondissementDao.update(arrondissement);
	}

	@Override
	public Arrondissement findById(Integer id) {
		// TODO Auto-generated method stub
		return arrondissementDao.findById(id);
	}

	@Override
	public List<Arrondissement> findAll() {
		// TODO Auto-generated method stub
		return arrondissementDao.findAll();
	}

	@Override
	public Arrondissement LinkArrondissementToVille(Arrondissement arrondissement, Ville ville) {
		// TODO Auto-generated method stub
		return arrondissementDao.LinkArrondissementToVille(arrondissement, ville);
	}


	
}

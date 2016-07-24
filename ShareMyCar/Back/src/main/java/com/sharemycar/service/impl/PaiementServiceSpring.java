package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.PaiementDao;
import com.sharemycar.entities.Paiement;
import com.sharemycar.service.PaiementService;

@Service
@Transactional
public class PaiementServiceSpring implements PaiementService {

	@Autowired
	private PaiementDao paiementDao;
	
	@Override
	public void delete(Paiement paiement) {
		// TODO Auto-generated method stub
		paiementDao.delete(paiement);
	}

	@Override
	public Paiement update(Paiement paiement) {
		// TODO Auto-generated method stub
		return paiementDao.update(paiement);
	}

	@Override
	public Paiement findById(Integer id) {
		// TODO Auto-generated method stub
		return paiementDao.findById(id);
	}

	@Override
	public List<Paiement> findAll() {
		// TODO Auto-generated method stub
		return paiementDao.findAll();
	}



	

}

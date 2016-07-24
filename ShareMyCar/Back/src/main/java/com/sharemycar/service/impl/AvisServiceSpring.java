package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.AvisDao;
import com.sharemycar.entities.Avis;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Reservation;
import com.sharemycar.service.AvisService;

@Service
@Transactional
public class AvisServiceSpring implements AvisService {

	@Autowired
	private AvisDao avisDao;
	
	@Override
	public Avis insert(Avis avis) {
		// TODO Auto-generated method stub
		return avisDao.insert(avis);
	}

	@Override
	public void delete(Avis avis) {
		// TODO Auto-generated method stub
		avisDao.delete(avis);
	}

	@Override
	public Avis update(Avis avis) {
		// TODO Auto-generated method stub
		return avisDao.update(avis);
	}

	@Override
	public Avis findById(Integer id) {
		// TODO Auto-generated method stub
		return avisDao.findById(id);
	}

	@Override
	public List<Avis> findAll() {
		// TODO Auto-generated method stub
		return avisDao.findAll();
	}

	@Override
	public Avis linkAvisToReservation(Avis avis, Reservation reservation) {
		// TODO Auto-generated method stub
		return avisDao.linkAvisToReservation(avis, reservation);
	}

	@Override
	public Avis linkAvisToClient(Avis avis, Client client) {
		// TODO Auto-generated method stub
		return avisDao.linkAvisToClient(avis, client);
	}

	@Override
	public List<Avis> findAvisByClient(Client client) {
		// TODO Auto-generated method stub
		return avisDao.findAvisByClient(client);
	}

	@Override
	public List<Avis> findAvisByReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return avisDao.findAvisByReservation(reservation);
	}



	

}

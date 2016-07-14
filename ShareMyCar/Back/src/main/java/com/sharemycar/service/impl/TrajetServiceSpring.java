package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.TrajetDao;
import com.sharemycar.entity.Client;
import com.sharemycar.entity.Reservation;
import com.sharemycar.entity.Trajet;
import com.sharemycar.entity.Voiture;
import com.sharemycar.service.TrajetService;

@Service
@Transactional
public class TrajetServiceSpring implements TrajetService {

	@Autowired
	private TrajetDao trajetDao;
	
	@Override
	public Trajet insert(Trajet trajet) {
		// TODO Auto-generated method stub
		return trajetDao.insert(trajet);
	}

	@Override
	public void delete(Trajet trajet) {
		// TODO Auto-generated method stub
		trajetDao.delete(trajet);
	}

	@Override
	public Trajet update(Trajet trajet) {
		// TODO Auto-generated method stub
		return trajetDao.update(trajet);
	}

	@Override
	public Trajet findById(Integer id) {
		// TODO Auto-generated method stub
		return trajetDao.findById(id);
	}

	@Override
	public List<Trajet> findAll() {
		// TODO Auto-generated method stub
		return trajetDao.findAll();
	}

	@Override
	public Trajet linkTrajetToChauffeur(Trajet trajet, Client client) {
		// TODO Auto-generated method stub
		return trajetDao.linkTrajetToChauffeur(trajet, client);
	}

	@Override
	public Trajet linkTrajetToVoiture(Trajet trajet, Voiture voiture) {
		// TODO Auto-generated method stub
		return trajetDao.linkTrajetToVoiture(trajet, voiture);
	}

	@Override
	public List<Reservation> findReservations(Trajet trajet) {
		// TODO Auto-generated method stub
		return trajetDao.findReservations(trajet);
	}

	@Override
	public List<Trajet> topDestination(Integer nbResult) {
		// TODO Auto-generated method stub
		return trajetDao.topDestination(nbResult);
	}

	@Override
	public List<Trajet> nouveaute(Integer nbResult) {
		// TODO Auto-generated method stub
		return trajetDao.nouveaute(nbResult);
	}



	

}

package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.ReservationDao;
import com.sharemycar.entity.Avis;
import com.sharemycar.entity.Client;
import com.sharemycar.entity.Paiement;
import com.sharemycar.entity.Reservation;
import com.sharemycar.entity.Trajet;
import com.sharemycar.service.ReservationService;

@Service
@Transactional
public class ReservationServiceSpring implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	
	@Override
	public Reservation insert(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationDao.insert(reservation);
	}

	@Override
	public void delete(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.delete(reservation);
	}

	@Override
	public Reservation update(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationDao.update(reservation);
	}

	@Override
	public Reservation findById(Integer id) {
		// TODO Auto-generated method stub
		return reservationDao.findById(id);
	}

	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return reservationDao.findAll();
	}

	@Override
	public Reservation linkReservationToPaiement(Reservation reservation, Paiement paiement) {
		// TODO Auto-generated method stub
		return reservationDao.linkReservationToPaiement(reservation, paiement);
	}

	@Override
	public Reservation linkReservationToTrajet(Reservation reservation, Trajet trajet) {
		// TODO Auto-generated method stub
		return reservationDao.linkReservationToTrajet(reservation, trajet);
	}

	@Override
	public Reservation linkReservationToAvis(Reservation reservation, Avis avis) {
		// TODO Auto-generated method stub
		return reservationDao.linkReservationToAvis(reservation, avis);
	}

	@Override
	public List<Avis> findAvisByReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationDao.findAvisByReservation(reservation);
	}

	@Override
	public Client getPassager(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationDao.getPassager(reservation);
	}

	@Override
	public Trajet getTrajet(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationDao.getTrajet(reservation);
	}

	@Override
	public Reservation accepterReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationDao.accepterReservation(reservation);
	}



	

}

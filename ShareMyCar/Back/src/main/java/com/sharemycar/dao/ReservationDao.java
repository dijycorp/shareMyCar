package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entities.Avis;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Paiement;
import com.sharemycar.entities.Reservation;
import com.sharemycar.entities.Trajet;

public interface ReservationDao {

//	crud principaux
	public Reservation insert(Reservation reservation);
	public void delete(Reservation reservation);
	public Reservation update(Reservation reservation);	
	public Reservation findById(Integer id);
	public List<Reservation> findAll();
	
//	autre fonction
	
	public Reservation linkReservationToPaiement(Reservation reservation, Paiement paiement);
	public Reservation linkReservationToTrajet(Reservation reservation, Trajet trajet);
	public Reservation linkReservationToAvis(Reservation reservation, Avis avis);
	public List<Avis> findAvisByReservation(Reservation reservation);
	
	public Client getPassager(Reservation reservation);
	
	public Trajet getTrajet(Reservation reservation);
	
	public Reservation accepterReservation (Reservation reservation);
	
}

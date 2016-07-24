package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entities.Avis;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Reservation;

public interface AvisService {

//	crud principaux
	
	public Avis insert(Avis avis);
	public void delete(Avis avis);
	public Avis update(Avis avis);	
	public Avis findById(Integer id);
	public List<Avis> findAll();
	
//	autre fonction
	
	public Avis linkAvisToReservation(Avis avis, Reservation reservation);
	public Avis linkAvisToClient(Avis avis, Client client);
	
	public List<Avis> findAvisByClient(Client client);
	public List<Avis> findAvisByReservation(Reservation reservation);
	
	
}

package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entities.Client;
import com.sharemycar.entities.Reservation;
import com.sharemycar.entities.Trajet;
import com.sharemycar.entities.Voiture;

public interface TrajetService {

//	crud principaux
	public Trajet insert(Trajet trajet);
	public void delete(Trajet trajet);
	public Trajet update(Trajet trajet);	
	public Trajet findById(Integer id);
	public List<Trajet> findAll();
	
//	autre fonction
	
	public Trajet linkTrajetToChauffeur(Trajet trajet, Client client);
	public Trajet linkTrajetToVoiture(Trajet trajet, Voiture voiture);

	public List<Reservation> findReservations(Trajet trajet);
	
	public List<Trajet> topDestination(Integer nbResult);
	public List<Trajet> nouveaute(Integer nbResult);
	
	
	
}

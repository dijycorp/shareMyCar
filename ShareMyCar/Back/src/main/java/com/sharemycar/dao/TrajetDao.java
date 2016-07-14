package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entity.Client;
import com.sharemycar.entity.Reservation;
import com.sharemycar.entity.Trajet;
import com.sharemycar.entity.Voiture;

public interface TrajetDao {

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

package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entities.Client;
import com.sharemycar.entities.Environnement;
import com.sharemycar.entities.Voiture;

public interface UserClientService {
	
//	crud principaux
	public Client insert(Client client);
	public void delete(Client client);
	public Client update(Client client);	
	public Client findById(Integer id);
	
//	link
	public Client linkClientToEnvironnement(Client client, Environnement environnement);
	public Client linkClientToVoiture(Client client, Voiture voiture);
	
	
//	list par type d'user
	public List<Client> findAllClient();
	
	public List<Voiture> listVoitures(Client client);
	public List<Environnement> listEnvironnements(Client client);

}

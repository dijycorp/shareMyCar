package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entities.Paiement;

public interface PaiementService {

//	crud principaux
	public void delete(Paiement paiement);
	public Paiement update(Paiement paiement);	
	public Paiement findById(Integer id);
	public List<Paiement> findAll();
	
}

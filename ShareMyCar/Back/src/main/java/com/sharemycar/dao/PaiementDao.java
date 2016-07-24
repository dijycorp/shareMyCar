package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entities.Paiement;

public interface PaiementDao {

//	crud principaux
	public void delete(Paiement paiement);
	public Paiement update(Paiement paiement);	
	public Paiement findById(Integer id);
	public List<Paiement> findAll();
	
}

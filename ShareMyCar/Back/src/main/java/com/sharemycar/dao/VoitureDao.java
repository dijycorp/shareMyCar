package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entities.PhotosVoiture;
import com.sharemycar.entities.Voiture;

public interface VoitureDao {

//	crud principaux
	public Voiture insert(Voiture voiture);
	public void delete(Voiture voiture);
	public Voiture update(Voiture voiture);	
	public Voiture findById(Integer id);
	public List<Voiture> findAll();
	
	public Voiture LinkVoitureToPhoto(Voiture voiture, PhotosVoiture photoVoiture);
	
}

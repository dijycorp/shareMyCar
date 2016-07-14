package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entity.PhotosVoiture;
import com.sharemycar.entity.Voiture;

public interface VoitureService {

//	crud principaux
	public Voiture insert(Voiture voiture);
	public void delete(Voiture voiture);
	public Voiture update(Voiture voiture);	
	public Voiture findById(Integer id);
	public List<Voiture> findAll();
	
	public Voiture LinkVoitureToPhoto(Voiture voiture, PhotosVoiture photoVoiture);
	
}

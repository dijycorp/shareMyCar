package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.VoitureDao;
import com.sharemycar.entity.PhotosVoiture;
import com.sharemycar.entity.Voiture;
import com.sharemycar.service.VoitureService;

@Service
@Transactional
public class VoitureServiceSpring implements VoitureService {

	@Autowired
	private VoitureDao voitureDao;
	
	@Override
	public Voiture insert(Voiture voiture) {
		// TODO Auto-generated method stub
		return voitureDao.insert(voiture);
	}

	@Override
	public void delete(Voiture voiture) {
		// TODO Auto-generated method stub
		voitureDao.delete(voiture);
	}

	@Override
	public Voiture update(Voiture voiture) {
		// TODO Auto-generated method stub
		return voitureDao.update(voiture);
	}

	@Override
	public Voiture findById(Integer id) {
		// TODO Auto-generated method stub
		return voitureDao.findById(id);
	}

	@Override
	public List<Voiture> findAll() {
		// TODO Auto-generated method stub
		return voitureDao.findAll();
	}

	@Override
	public Voiture LinkVoitureToPhoto(Voiture voiture, PhotosVoiture photoVoiture) {
		// TODO Auto-generated method stub
		return voitureDao.LinkVoitureToPhoto(voiture, photoVoiture);
	}



	

}

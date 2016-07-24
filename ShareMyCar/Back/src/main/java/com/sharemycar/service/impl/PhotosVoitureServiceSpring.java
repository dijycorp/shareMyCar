package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.PhotosVoitureDao;
import com.sharemycar.entities.PhotosVoiture;
import com.sharemycar.service.PhotosVoitureService;

@Service
@Transactional
public class PhotosVoitureServiceSpring implements PhotosVoitureService {

	@Autowired
	private PhotosVoitureDao photosVoitureDao;
	
	@Override
	public PhotosVoiture insert(PhotosVoiture photosVoiture) {
		// TODO Auto-generated method stub
		return photosVoitureDao.insert(photosVoiture);
	}

	@Override
	public void delete(PhotosVoiture photosVoiture) {
		// TODO Auto-generated method stub
		photosVoitureDao.delete(photosVoiture);
	}

	@Override
	public PhotosVoiture update(PhotosVoiture photosVoiture) {
		// TODO Auto-generated method stub
		return photosVoitureDao.update(photosVoiture);
	}

	@Override
	public PhotosVoiture findById(Integer id) {
		// TODO Auto-generated method stub
		return photosVoitureDao.findById(id);
	}

	@Override
	public List<PhotosVoiture> findAll() {
		// TODO Auto-generated method stub
		return photosVoitureDao.findAll();
	}



	

}

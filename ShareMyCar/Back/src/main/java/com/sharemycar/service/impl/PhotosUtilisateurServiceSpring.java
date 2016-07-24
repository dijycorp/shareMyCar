package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.PhotosUtilisateurDao;
import com.sharemycar.entities.PhotosUtilisateur;
import com.sharemycar.service.PhotosUtilisateurService;

@Service
@Transactional
public class PhotosUtilisateurServiceSpring implements PhotosUtilisateurService {

	@Autowired
	private PhotosUtilisateurDao photosUtilisateurDao;
	
	@Override
	public PhotosUtilisateur insert(PhotosUtilisateur photosUtilisateur) {
		// TODO Auto-generated method stub
		return photosUtilisateurDao.insert(photosUtilisateur);
	}

	@Override
	public void delete(PhotosUtilisateur photosUtilisateur) {
		// TODO Auto-generated method stub
		photosUtilisateurDao.delete(photosUtilisateur);
	}

	@Override
	public PhotosUtilisateur update(PhotosUtilisateur photosUtilisateur) {
		// TODO Auto-generated method stub
		return photosUtilisateurDao.update(photosUtilisateur);
	}

	@Override
	public PhotosUtilisateur findById(Integer id) {
		// TODO Auto-generated method stub
		return photosUtilisateurDao.findById(id);
	}

	@Override
	public List<PhotosUtilisateur> findAll() {
		// TODO Auto-generated method stub
		return photosUtilisateurDao.findAll();
	}



	

}

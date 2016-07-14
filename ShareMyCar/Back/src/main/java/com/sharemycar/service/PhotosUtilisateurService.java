package com.sharemycar.service;

import java.util.List;
import com.sharemycar.entity.PhotosUtilisateur;

public interface PhotosUtilisateurService {

	// crud principaux
	public PhotosUtilisateur insert(PhotosUtilisateur photosUtilisateur);
	public void delete(PhotosUtilisateur photosUtilisateur);
	public PhotosUtilisateur update(PhotosUtilisateur photosUtilisateur);
	public PhotosUtilisateur findById(Integer id);
	public List<PhotosUtilisateur> findAll();

}
package com.sharemycar.dao;

import java.util.List;
import com.sharemycar.entity.PhotosUtilisateur;

public interface PhotosUtilisateurDao {

	// crud principaux
	public PhotosUtilisateur insert(PhotosUtilisateur photosUtilisateur);
	public void delete(PhotosUtilisateur photosUtilisateur);
	public PhotosUtilisateur update(PhotosUtilisateur photosUtilisateur);
	public PhotosUtilisateur findById(Integer id);
	public List<PhotosUtilisateur> findAll();

}
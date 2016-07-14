package com.sharemycar.dao;

import java.util.List;
import com.sharemycar.entity.PhotosVoiture;

public interface PhotosVoitureDao {

	// crud principaux
	public PhotosVoiture insert(PhotosVoiture photosVoiture);
	public void delete(PhotosVoiture photosVoiture);
	public PhotosVoiture update(PhotosVoiture photosVoiture);
	public PhotosVoiture findById(Integer id);
	public List<PhotosVoiture> findAll();

}
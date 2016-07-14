package com.sharemycar.service;

import java.util.List;
import com.sharemycar.entity.PhotosVoiture;

public interface PhotosVoitureService {

	// crud principaux
	public PhotosVoiture insert(PhotosVoiture photosVoiture);
	public void delete(PhotosVoiture photosVoiture);
	public PhotosVoiture update(PhotosVoiture photosVoiture);
	public PhotosVoiture findById(Integer id);
	public List<PhotosVoiture> findAll();

}
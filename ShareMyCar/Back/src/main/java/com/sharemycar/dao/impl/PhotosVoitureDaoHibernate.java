package com.sharemycar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sharemycar.dao.PhotosVoitureDao;
import com.sharemycar.entity.PhotosVoiture;

@Transactional
@Repository
public class PhotosVoitureDaoHibernate implements PhotosVoitureDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public PhotosVoiture insert(PhotosVoiture photosVoiture) {
		em.persist(photosVoiture);
		return photosVoiture;
	}

	@Override
	public PhotosVoiture update(PhotosVoiture photosVoiture) {
		return em.merge(photosVoiture);
	}

	@Override
	public void delete(PhotosVoiture photosVoiture) {
		PhotosVoiture env = em.merge(photosVoiture);
		em.remove(env);
	}

	@Override
	public PhotosVoiture findById(Integer id) {
		return em.find(PhotosVoiture.class, id);
	}

	@Override
	public List<PhotosVoiture> findAll() {
		TypedQuery<PhotosVoiture> q = em.createQuery("SELECT pv FROM PhotosVoiture pv", PhotosVoiture.class);
		return q.getResultList();
	}

}

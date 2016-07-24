package com.sharemycar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.VoitureDao;
import com.sharemycar.entities.PhotosVoiture;
import com.sharemycar.entities.Voiture;


@Transactional
@Repository
public class VoitureDaoHibernate implements VoitureDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Voiture insert(Voiture voiture) {
		em.persist(voiture);
		return voiture;
	}
	
	@Override
	public Voiture update(Voiture voiture) {
		return em.merge(voiture);
	}

	@Override
	public void delete(Voiture voiture) {
		Voiture rol = em.merge(voiture);
		em.remove(rol);
	}

	@Override
	public Voiture findById(Integer id) {
		return em.find(Voiture.class, id);
	}

	@Override
	public List<Voiture> findAll() {
		TypedQuery<Voiture> q = em.createQuery("SELECT a FROM Voiture a",Voiture.class);
		return q.getResultList();
	}

	@Override
	public Voiture LinkVoitureToPhoto(Voiture voiture, PhotosVoiture photoVoiture) {
		voiture.getPhotosVoiture().add(photoVoiture);
		photoVoiture.setVoiture(voiture);
		return voiture;
	}

}

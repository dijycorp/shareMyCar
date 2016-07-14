package com.sharemycar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.PhotosUtilisateurDao;
import com.sharemycar.entity.PhotosUtilisateur;

@Transactional
@Repository
public class PhotosUtilisateurDaoHibernate implements PhotosUtilisateurDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public PhotosUtilisateur insert(PhotosUtilisateur photosUtilisateur) {
		em.persist(photosUtilisateur);
		return photosUtilisateur;
	}

	@Override
	public PhotosUtilisateur update(PhotosUtilisateur photosUtilisateur) {
		return em.merge(photosUtilisateur);
	}

	@Override
	public void delete(PhotosUtilisateur photosUtilisateur) {
		PhotosUtilisateur env = em.merge(photosUtilisateur);
		em.remove(env);
	}

	@Override
	public PhotosUtilisateur findById(Integer id) {
		return em.find(PhotosUtilisateur.class, id);
	}

	@Override
	public List<PhotosUtilisateur> findAll() {
		TypedQuery<PhotosUtilisateur> q = em.createQuery("SELECT pu FROM PhotosUtilisateur pu",
				PhotosUtilisateur.class);
		return q.getResultList();
	}

}

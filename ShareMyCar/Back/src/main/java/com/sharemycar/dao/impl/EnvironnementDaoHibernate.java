package com.sharemycar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.EnvironnementDao;
import com.sharemycar.entities.Environnement;

@Transactional // cr�e automatiquement le transcation begin, close, ect...
@Repository // d�clare la class comme �tant une entity d'une base de
			// donn�e
public class EnvironnementDaoHibernate implements EnvironnementDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Environnement insert(Environnement environnement) {
		em.persist(environnement);
		return environnement;
	}

	@Override
	public Environnement update(Environnement environnement) {
		return em.merge(environnement);
	}

	@Override
	public void delete(Environnement environnement) {
		Environnement env = em.merge(environnement);
		em.remove(env);
	}

	@Override
	public Environnement findById(Integer id) {
		return em.find(Environnement.class, id);
	}

	@Override
	public List<Environnement> findAll() {
		TypedQuery<Environnement> q = em.createQuery("SELECT e FROM Environnement e", Environnement.class);
		return q.getResultList();
	}

}

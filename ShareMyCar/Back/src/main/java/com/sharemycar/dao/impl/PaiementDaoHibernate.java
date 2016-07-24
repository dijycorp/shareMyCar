package com.sharemycar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.PaiementDao;
import com.sharemycar.entities.Paiement;

@Transactional
@Repository
public class PaiementDaoHibernate implements PaiementDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Paiement update(Paiement paiement) {
		return em.merge(paiement);
	}

	@Override
	public void delete(Paiement paiement) {
		Paiement rol = em.merge(paiement);
		em.remove(rol);
	}

	@Override
	public Paiement findById(Integer id) {
		return em.find(Paiement.class, id);
	}

	@Override
	public List<Paiement> findAll() {
		TypedQuery<Paiement> q = em.createQuery("SELECT p FROM Paiement p",Paiement.class);
		return q.getResultList();
	}

}

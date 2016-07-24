package com.sharemycar.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sharemycar.dao.VilleDao;
import com.sharemycar.entities.Ville;

@Transactional
@Repository("villeDaoHibernate")
public class VilleDaoHibernate implements VilleDao {

	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Ville insert(Ville ville) {
		em.persist(ville);
		return ville;
	}

	@Override
	public void delete(Ville ville) {
		Ville villeF = em.merge(ville);
		em.remove(villeF);

	}

	@Override
	public Ville update(Ville ville) {
		em.merge(ville);
		return ville;
	}

	@Override
	public Ville findById(Integer id) {
		return em.find(Ville.class, id);
	}

	@Override
	public List<Ville> findAll() {
		TypedQuery<Ville> q = em.createQuery("SELECT v FROM Ville v",Ville.class);
		return q.getResultList() ;
	}

}
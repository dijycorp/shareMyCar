package com.sharemycar.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sharemycar.dao.ArrondissementDao;
import com.sharemycar.entity.Arrondissement;
import com.sharemycar.entity.Ville;

@Transactional
@Repository("arrondissementDaoHibernate")
public class ArrondissementDaoHibernate implements ArrondissementDao {

	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Arrondissement insert(Arrondissement arrondissement) {
		em.persist(arrondissement);
		return arrondissement;
	}

	@Override
	public void delete(Arrondissement arrondissement) {
		Arrondissement arronF = em.merge(arrondissement);
		em.remove(arronF);

	}

	@Override
	public Arrondissement update(Arrondissement arrondissement) {
		em.merge(arrondissement);
		return arrondissement;
	}

	@Override
	public Arrondissement findById(Integer id) {
		return em.find(Arrondissement.class, id);
	}

	@Override
	public List<Arrondissement> findAll() {
		TypedQuery<Arrondissement> q = em.createQuery("SELECT a FROM Arrondissement a",Arrondissement.class);
		return q.getResultList() ;
	}

	@Override
	public Arrondissement LinkArrondissementToVille(Arrondissement arrondissement, Ville ville) {
		arrondissement.getVilles().add(ville);
		ville.setArrondissement(arrondissement);
		return arrondissement;
	}

}

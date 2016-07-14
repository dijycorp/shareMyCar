package com.sharemycar.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sharemycar.dao.PaysDao;
import com.sharemycar.entity.Pays;
import com.sharemycar.entity.Region;

@Transactional
@Repository("paysDaoHibernate")
public class PaysDaoHibernate implements PaysDao {

	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Pays insert(Pays pays) {
		em.persist(pays);
		return pays;
	}

	@Override
	public void delete(Pays pays) {
		Pays paysF = em.merge(pays);
		em.remove(paysF);

	}

	@Override
	public Pays update(Pays pays) {
		em.merge(pays);
		return pays;
	}

	@Override
	public Pays findById(Integer id) {
		return em.find(Pays.class, id);
	}

	@Override
	public List<Pays> findAll() {
		TypedQuery<Pays> q = em.createQuery("SELECT p FROM Pays p",Pays.class);
		return q.getResultList() ;
	}
	@Override
	public Pays LinkPaysToRegion(Pays pays, Region region) {
		pays.addRegion(region);
		region.setPays(pays);
		return pays;
	}
	

}
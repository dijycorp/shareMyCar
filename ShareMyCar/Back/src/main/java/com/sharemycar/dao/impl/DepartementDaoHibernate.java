package com.sharemycar.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sharemycar.dao.DepartementDao;
import com.sharemycar.entities.Arrondissement;
import com.sharemycar.entities.Departement;

@Transactional
@Repository("departementDaoHibernate")
public class DepartementDaoHibernate implements DepartementDao {

	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Departement insert(Departement departement) {
		em.persist(departement);
		return departement;
	}

	@Override
	public void delete(Departement departement) {
		Departement departF = em.merge(departement);
		em.remove(departF);

	}

	@Override
	public Departement update(Departement departement) {
		em.merge(departement);
		return departement;
	}

	@Override
	public Departement findById(Integer id) {
		return em.find(Departement.class, id);
	}

	@Override
	public List<Departement> findAll() {
		TypedQuery<Departement> q = em.createQuery("SELECT d FROM Departement d",Departement.class);
		return q.getResultList() ;
	}
	
	@Override
	public Departement LinkDepartementToArrondissement(Departement departement, Arrondissement arrondissement) {
		departement.addArrondissement(arrondissement);
		arrondissement.setDepartement(departement);
		return departement;
	}
	
}
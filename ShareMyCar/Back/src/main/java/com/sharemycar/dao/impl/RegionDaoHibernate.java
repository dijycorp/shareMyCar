package com.sharemycar.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sharemycar.dao.RegionDao;
import com.sharemycar.entities.Departement;
import com.sharemycar.entities.Region;

@Transactional
@Repository("regionDaoHibernate")
public class RegionDaoHibernate implements RegionDao {

	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Region insert(Region region) {
		em.persist(region);
		return region;
	}

	@Override
	public void delete(Region region) {
		Region regionF = em.merge(region);
		em.remove(regionF);

	}

	@Override
	public Region update(Region region) {
		em.merge(region);
		return region;
	}

	@Override
	public Region findById(Integer id) {
		return em.find(Region.class, id);
	}

	@Override
	public List<Region> findAll() {
		TypedQuery<Region> q = em.createQuery("SELECT r FROM Region r",Region.class);
		return q.getResultList() ;
	}
	
	@Override
	public Region LinkRegionToDepartement(Region region, Departement departement) {
		region.addDepartement(departement);
		departement.setRegion(region);
		return region;
	}
	
}
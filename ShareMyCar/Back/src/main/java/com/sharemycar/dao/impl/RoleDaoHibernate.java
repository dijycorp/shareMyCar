package com.sharemycar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.RoleDao;
import com.sharemycar.entity.Role;

@Transactional
@Repository
public class RoleDaoHibernate implements RoleDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Role insert(Role role) {
		em.persist(role);
		return role;
	}

	@Override
	public Role update(Role role) {
		return em.merge(role);
	}

	@Override
	public void delete(Role role) {
		Role rol = em.merge(role);
		em.remove(rol);
	}

	@Override
	public Role findById(Integer id) {
		return em.find(Role.class, id);
	}

	@Override
	public List<Role> findAll() {
		TypedQuery<Role> q = em.createQuery("SELECT r FROM Role r", Role.class);
		return q.getResultList();
	}

}

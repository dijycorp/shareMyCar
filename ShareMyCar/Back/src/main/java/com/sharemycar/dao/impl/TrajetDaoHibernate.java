package com.sharemycar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.TrajetDao;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Reservation;
import com.sharemycar.entities.Trajet;
import com.sharemycar.entities.Voiture;


@Transactional
@Repository
public class TrajetDaoHibernate implements TrajetDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Trajet insert(Trajet trajet) {
		em.persist(trajet);
		return trajet;
	}
	
	@Override
	public Trajet update(Trajet trajet) {
		return em.merge(trajet);
	}

	@Override
	public void delete(Trajet trajet) {
		Trajet rol = em.merge(trajet);
		em.remove(rol);
	}

	@Override
	public Trajet findById(Integer id) {
		return em.find(Trajet.class, id);
	}

	@Override
	public List<Trajet> findAll() {
		TypedQuery<Trajet> q = em.createQuery("SELECT c FROM Trajet c",Trajet.class);
		return q.getResultList();
	}

	@Override
	public Trajet linkTrajetToChauffeur(Trajet trajet, Client client) {
		trajet.setChauffeur(client);
		client.getTrajetsChauffeur().add(trajet);
		return null;
	}

	@Override
	public Trajet linkTrajetToVoiture(Trajet trajet, Voiture voiture) {
		trajet.setVoiture(voiture);
		voiture.getTrajets().add(trajet);
		return trajet;
	}

	@Override
	public List<Reservation> findReservations(Trajet trajet) {
		Trajet trajetF = em.find(Trajet.class, trajet.getId());
		return trajetF.getReservations();
	}

	@Override
	public List<Trajet> topDestination(Integer nbResult) {
		TypedQuery<Trajet> q = em.createQuery("SELECT t FROM Trajet t", Trajet.class);
		q.setMaxResults(nbResult);
		return q.getResultList();
	}

	@Override
	public List<Trajet> nouveaute(Integer nbResult) {
		TypedQuery<Trajet> q = em.createQuery("SELECT t FROM Trajet t ORDER BY t.datePublication DESC", Trajet.class);
		q.setMaxResults(nbResult);
		return q.getResultList();
	}

}

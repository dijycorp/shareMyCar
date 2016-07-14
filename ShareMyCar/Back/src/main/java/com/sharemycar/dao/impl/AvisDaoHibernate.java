package com.sharemycar.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sharemycar.dao.AvisDao;
import com.sharemycar.entity.Avis;
import com.sharemycar.entity.Client;
import com.sharemycar.entity.Reservation;

@Transactional
@Repository("avisDaoHibernate")
public class AvisDaoHibernate implements AvisDao {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Avis insert(Avis avis) {
		em.persist(avis);
		return avis;
	}

	@Override
	public void delete(Avis avis) {
		Avis avisF = em.merge(avis);
		em.remove(avisF);

	}

	@Override
	public Avis update(Avis avis) {
		em.merge(avis);
		return avis;
	}

	@Override
	public Avis findById(Integer id) {
		return em.find(Avis.class, id);
	}

	@Override
	public List<Avis> findAll() {
		TypedQuery<Avis> q = em.createQuery("SELECT a FROM Avis a",Avis.class);
		return q.getResultList();
	}

	// partie link
	@Override
	public Avis linkAvisToReservation(Avis avis, Reservation reservation) {
		reservation.getAvis().add(avis);
		avis.setReservation(reservation);
		em.merge(avis);
		return avis;
	}

	@Override
	public Avis linkAvisToClient(Avis avis, Client client) {
		client.getAvis().add(avis);
		avis.setClient(client);
		em.merge(avis);
		return avis;
	}

	@Override
	public List<Avis> findAvisByClient(Client client) {
		Client clientF = em.find(Client.class, client.getId());
		return clientF.getAvis();
	}

	@Override
	public List<Avis> findAvisByReservation(Reservation reservation) {
		Reservation reservationF = em.find(Reservation.class, reservation.getId());
		return reservationF.getAvis();
	}

}
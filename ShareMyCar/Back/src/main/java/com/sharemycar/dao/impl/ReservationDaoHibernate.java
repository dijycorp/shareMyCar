package com.sharemycar.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.ReservationDao;
import com.sharemycar.entities.Avis;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Paiement;
import com.sharemycar.entities.Reservation;
import com.sharemycar.entities.Trajet;


@Transactional
@Repository
public class ReservationDaoHibernate implements ReservationDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Reservation insert(Reservation reservation) {
		em.persist(reservation);
		return reservation;
	}
	
	@Override
	public Reservation update(Reservation reservation) {
		return em.merge(reservation);
	}

	@Override
	public void delete(Reservation reservation) {
		Reservation rol = em.merge(reservation);
		em.remove(rol);
	}

	@Override
	public Reservation findById(Integer id) {
		return em.find(Reservation.class, id);
	}

	@Override
	public List<Reservation> findAll() {
		// JPQL => pour hibernate
		// sensible � la case c�t� java pour le nom de la class
		// possible de l'�crire => Query q = em.createQuery("FROM Reservation");
		TypedQuery<Reservation> q = em.createQuery("SELECT r FROM Reservation r",Reservation.class);
		return q.getResultList();
	}

	@Override
	public Reservation linkReservationToPaiement(Reservation reservation, Paiement paiement) {
		reservation.setPaiement(paiement);
		paiement.setReservation(reservation);
		return reservation;
	}

	@Override
	public Reservation linkReservationToAvis(Reservation reservation, Avis avis) {
		reservation.getAvis().add(avis);
		avis.setReservation(reservation);
		return reservation;
	}

	@Override
	public List<Avis> findAvisByReservation(Reservation reservation) {
		Reservation reservationF = em.find(Reservation.class, reservation.getId());
		return reservationF.getAvis();
	}

	@Override
	public Client getPassager(Reservation reservation) {
		Reservation resaF = em.find(Reservation.class, reservation.getId());
		return resaF.getPassager();
	}

	@Override
	public Trajet getTrajet(Reservation reservation) {
		Reservation resaF = em.find(Reservation.class, reservation.getId());
		return resaF.getTrajet();
	}

	@Override
	public Reservation linkReservationToTrajet(Reservation reservation, Trajet trajet) {
		reservation.setTrajet(trajet);
		trajet.getReservations().add(reservation);
		return reservation;
	}

	@Override
	public Reservation accepterReservation(Reservation reservation) {
		reservation.setAccepte(true);
		reservation.setDateAcceptation(new Date());
		return reservation;
	}

}

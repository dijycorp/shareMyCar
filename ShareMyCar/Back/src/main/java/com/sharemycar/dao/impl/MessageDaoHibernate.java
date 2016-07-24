package com.sharemycar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.MessageDao;
import com.sharemycar.entities.Message;

@Transactional // cr�e automatiquement le transcation begin, close, ect...
@Repository // d�clare la class comme �tant une entity d'une base de
			// donn�e
public class MessageDaoHibernate implements MessageDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Message insert(Message message) {
		em.persist(message);
		return message;
	}

	@Override
	public Message update(Message message) {
		return em.merge(message);
	}

	@Override
	public void delete(Message message) {
		Message rol = em.merge(message);
		em.remove(rol);
	}

	@Override
	public Message findById(Integer id) {
		return em.find(Message.class, id);
	}

	@Override
	public List<Message> findAll() {
		TypedQuery<Message> q = em.createQuery("SELECT m FROM Message m", Message.class);
		return q.getResultList();
	}

	@Override
	public Message envoyerMessage(Message message) {
		em.merge(message);
		return message;
	}

	@Override
	public Message repondreMessage(Message message, Message messageReponse) {
		message.getMessageReponses().add(messageReponse);
		em.merge(message);
		return message;
	}

	@Override
	public Message archiverMessage(Message message) {
		message.setEtat(5);
		em.merge(message);
		return message;
	}

}

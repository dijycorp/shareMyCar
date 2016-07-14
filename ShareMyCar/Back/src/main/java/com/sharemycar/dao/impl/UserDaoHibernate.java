package com.sharemycar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.UserDao;
import com.sharemycar.entity.Admin;
import com.sharemycar.entity.Client;
import com.sharemycar.entity.Environnement;
import com.sharemycar.entity.PhotosUtilisateur;
import com.sharemycar.entity.Role;
import com.sharemycar.entity.User;
import com.sharemycar.entity.Voiture;

@Transactional
@Repository
public class UserDaoHibernate implements UserDao {

	private EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory", type=PersistenceContextType.EXTENDED)
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public User insert(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}

	@Override
	public User findById(Integer id) {
		return em.find(User.class, id);
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public User linkUserToRole(User user, Role role) {
		role.getUsers().add(user);
		user.getRoles().add(role);
		return user;
	}
	
	@Override
	public Client linkClientToEnvironnement(Client client, Environnement environnement) {
		client.getEnvironnements().add(environnement);
		environnement.getClients().add(client);
		return client;
	}


	@Override
	public User linkUsertoPhoto(User user, PhotosUtilisateur photosUtilisateur) {
		user.getPhotosUtilisateurs().add(photosUtilisateur);
		photosUtilisateur.setUser(user);
		return user;
	}

	@Override
	public Client linkClientToVoiture(Client client, Voiture voiture) {
		client.getVoitures().add(voiture);
		voiture.setChauffeur(client);
		return client;
	}

	// retourne les users en fonctions du type

	@Override
	public List<User> findAllUser() {
		TypedQuery<User> q = em.createQuery("SELECT u FROM User u",User.class);
		return q.getResultList();
	}

	@Override
	public List<Client> findAllClient() {
		TypedQuery<Client> q = em.createQuery("SELECT c FROM Client c",Client.class);
		return q.getResultList();
	}

	@Override
	public List<Admin> findAllAdmin() {
		TypedQuery<Admin> q = em.createQuery("SELECT a FROM Admin a",Admin.class);
		return q.getResultList();
	}

	@Override
	public User login(String username, String password) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :pass");
		q.setParameter("login", username);
		q.setParameter("pass", password);
		
		try {
			User user = (User) q.getSingleResult();
			return user;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Voiture> findListVoiture(Client client) {
		Client clientFind = em.find(Client.class, client.getId());
		return clientFind.getVoitures();
	}

	@Override
	public List<Environnement> findListEnvironnement(Client client) {
		Client clientFind = em.find(Client.class, client.getId());
		return clientFind.getEnvironnements();
	}
	
	@Override
	public List<Role> findListRole(User user) {
		User userFind = em.find(User.class, user.getId());
		return userFind.getRoles();
	}

	@Override
	public Boolean isUnique(String login, String email) {
		Query q = em.createQuery("SELECT u FROM User u WHERE (u.login = :login) OR (u.email = :email)");
		q.setParameter("login", login);
		q.setParameter("email", email);
		
		try {
			User user = (User) q.getSingleResult();
			System.out.println("existe : " + user);
			return false;
		} catch (Exception e) {
			return true;
	}
	}

	@Override
	public Boolean isUniqueEmail(String email) {
		Query q = em.createQuery("SELECT u FROM User u WHERE (u.email = :email)");
		q.setParameter("email", email);
		
		try {
			User user = (User) q.getSingleResult();
			System.out.println("existe : " + user);
			return false;
		} catch (Exception e) {
			return true;
	}
	}

	@Override
	public Boolean isUniqueLogin(String login) {
		Query q = em.createQuery("SELECT u FROM User u WHERE (u.login = :login)");
		q.setParameter("login", login);
		
		try {
			User user = (User) q.getSingleResult();
			System.out.println("existe : " + user);
			return false;
		} catch (Exception e) {
			return true;
	}
	}

}

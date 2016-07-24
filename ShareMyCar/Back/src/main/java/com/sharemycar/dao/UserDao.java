package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entities.Admin;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Environnement;
import com.sharemycar.entities.PhotosUtilisateur;
import com.sharemycar.entities.Role;
import com.sharemycar.entities.User;
import com.sharemycar.entities.Voiture;

public interface UserDao {
	
//	crud principaux
	public User insert(User user);
	public void delete(User user);
	public User update(User user);	
	public User findById(Integer id);
	
//	authentification
	public User login(String username, String password);
	public Boolean isUnique(String login, String email);
	public Boolean isUniqueEmail(String email);
	public Boolean isUniqueLogin(String login);
	
	
//	link
	public User linkUserToRole(User user, Role role);
	public User linkUsertoPhoto(User user, PhotosUtilisateur photosUtilisateur);
	public Client linkClientToEnvironnement(Client client, Environnement environnement);
	public Client linkClientToVoiture(Client client, Voiture voiture);
	
//	list par type d'user
	public List<User> findAllUser();
	public List<Client> findAllClient();
	public List<Admin> findAllAdmin();
	
	//compléments
	public List<Voiture> findListVoiture(Client client);
	public List<Environnement> findListEnvironnement(Client client);
	public List<Role> findListRole(User user);

}

package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entity.PhotosUtilisateur;
import com.sharemycar.entity.Role;
import com.sharemycar.entity.User;

public interface UserService {
	
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
	
//	list par type d'user
	public List<User> findAllUser();
	public List<Role> findListRole(User user);

}

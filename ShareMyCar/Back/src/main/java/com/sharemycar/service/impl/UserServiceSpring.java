package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.UserDao;
import com.sharemycar.entity.User;
import com.sharemycar.service.UserService;
import com.sharemycar.entity.PhotosUtilisateur;
import com.sharemycar.entity.Role;

@Service
@Transactional
public class UserServiceSpring implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User insert(User user) {
		// TODO Auto-generated method stub
		return (User) userDao.insert(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return (User) userDao.update(user);
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return (User) userDao.findById(id);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.login(username, password);
	}

	@Override
	public User linkUserToRole(User user, Role role) {
		// TODO Auto-generated method stub
		return userDao.linkUserToRole(user, role);
	}

	@Override
	public User linkUsertoPhoto(User user, PhotosUtilisateur photosUtilisateur) {
		// TODO Auto-generated method stub
		return userDao.linkUsertoPhoto(user, photosUtilisateur);
	}

	@Override
	public List<Role> findListRole(User user) {
		// TODO Auto-generated method stub
		return userDao.findListRole(user);
	}

	@Override
	public Boolean isUnique(String login, String email) {
		// TODO Auto-generated method stub
		return userDao.isUnique(login, email);
	}

	@Override
	public Boolean isUniqueEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.isUniqueEmail(email);
	}

	@Override
	public Boolean isUniqueLogin(String login) {
		// TODO Auto-generated method stub
		return userDao.isUniqueLogin(login);
	}

	

}

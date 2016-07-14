package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.UserDao;
import com.sharemycar.entity.Admin;
import com.sharemycar.entity.Client;
import com.sharemycar.entity.User;
import com.sharemycar.service.UserAdminService;

@Service
@Transactional
public class UserAdminServiceSpring implements UserAdminService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public Admin insert(Admin admin) {
		// TODO Auto-generated method stub
		return (Admin) userDao.insert(admin);
	}

	@Override
	public void delete(Admin admin) {
		// TODO Auto-generated method stub
		userDao.delete(admin);
	}

	@Override
	public Admin update(Admin admin) {
		// TODO Auto-generated method stub
		return (Admin) userDao.update(admin);
	}

	@Override
	public Admin findById(Integer id) {
		// TODO Auto-generated method stub
		return (Admin) userDao.findById(id);
	}


	@Override
	public List<Admin> findAllAdmin() {
		// TODO Auto-generated method stub
		return userDao.findAllAdmin();
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return userDao.findAllClient();
	}

	

}

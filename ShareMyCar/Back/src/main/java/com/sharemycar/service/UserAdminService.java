package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entities.Admin;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.User;

public interface UserAdminService {
	
//	crud principaux
	public Admin insert(Admin admin);
	public void delete(Admin admin);
	public Admin update(Admin admin);	
	public Admin findById(Integer id);
	
//	link
	
	
//	list par type d'user
	public List<User> findAll();
	public List<Admin> findAllAdmin();
	public List<Client> findAllClient();

}

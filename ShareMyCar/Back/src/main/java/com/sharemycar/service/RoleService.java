package com.sharemycar.service;

import java.util.List;

import com.sharemycar.entities.Role;

public interface RoleService {

//	crud principaux
	public Role insert(Role role);
	public void delete(Role role);
	public Role update(Role role);	
	public Role findById(Integer id);
	public List<Role> findAll();
	
}

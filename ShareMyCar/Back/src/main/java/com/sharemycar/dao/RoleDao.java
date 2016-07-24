package com.sharemycar.dao;

import java.util.List;

import com.sharemycar.entities.Role;

public interface RoleDao {

//	crud principaux
	public Role insert(Role role);
	public void delete(Role role);
	public Role update(Role role);	
	public Role findById(Integer id);
	public List<Role> findAll();
	
}

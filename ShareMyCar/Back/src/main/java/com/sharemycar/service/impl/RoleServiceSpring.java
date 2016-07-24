package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.RoleDao;
import com.sharemycar.entities.Role;
import com.sharemycar.service.RoleService;

@Service
@Transactional
public class RoleServiceSpring implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role insert(Role role) {
		// TODO Auto-generated method stub
		return roleDao.insert(role);
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		roleDao.delete(role);
	}

	@Override
	public Role update(Role role) {
		// TODO Auto-generated method stub
		return roleDao.update(role);
	}

	@Override
	public Role findById(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}



	

}

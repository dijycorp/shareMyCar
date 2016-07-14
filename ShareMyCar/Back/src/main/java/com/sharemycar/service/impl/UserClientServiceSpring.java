package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.UserDao;
import com.sharemycar.entity.Client;
import com.sharemycar.entity.Environnement;
import com.sharemycar.entity.Voiture;
import com.sharemycar.service.UserClientService;

@Service
@Transactional
public class UserClientServiceSpring implements UserClientService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public Client insert(Client client) {
		// TODO Auto-generated method stub
		return (Client) userDao.insert(client);
	}

	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		userDao.delete(client);
	}

	@Override
	public Client update(Client client) {
		// TODO Auto-generated method stub
		return (Client) userDao.update(client);
	}

	@Override
	public Client findById(Integer id) {
		// TODO Auto-generated method stub
		return (Client) userDao.findById(id);
	}

	@Override
	public Client linkClientToEnvironnement(Client client, Environnement environnement) {
		// TODO Auto-generated method stub
		return (Client) userDao.linkClientToEnvironnement(client, environnement);
	}

	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return userDao.findAllClient();
	}

	@Override
	public Client linkClientToVoiture(Client client, Voiture voiture) {
		// TODO Auto-generated method stub
		return userDao.linkClientToVoiture(client, voiture);
	}

	@Override
	public List<Voiture> listVoitures(Client client) {
		// TODO Auto-generated method stub
		return userDao.findListVoiture(client);
	}

	@Override
	public List<Environnement> listEnvironnements(Client client) {
		// TODO Auto-generated method stub
		return userDao.findListEnvironnement(client);
	}

	

}

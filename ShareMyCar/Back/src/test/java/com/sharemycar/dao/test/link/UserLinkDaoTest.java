package com.sharemycar.dao.test.link;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sharemycar.dao.EnvironnementDao;
import com.sharemycar.dao.PhotosUtilisateurDao;
import com.sharemycar.dao.RoleDao;
import com.sharemycar.dao.UserDao;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/dev-context.xml")
public class UserLinkDaoTest {

	@Autowired
	UserDao userDao;
	@Autowired
	EnvironnementDao environnementDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	PhotosUtilisateurDao photoDao;

	// création des users spévifiques
	Client client1 = new Client("nom-client1", "prenom", "email", "login", "password", true, false, "token");
	Client client2 = new Client("nom-client2", "prenom", "email", "login", "password", true, false, "token");
	Client client3 = new Client("nom-client3", "prenom", "email", "login", "password", true, false, "token");
	Client client4 = new Client("nom-client4", "prenom", "email", "login", "password", true, false, "token");

	Role role1 = new Role("client");
	Role role2 = new Role("Consultation");
	Role role3 = new Role("actif");
	Role role4 = new Role("suspendu");

	@Test
	public void client1() {
		userDao.insert(client1);
		roleDao.insert(role1);
		roleDao.insert(role2);
		roleDao.insert(role3);
		roleDao.insert(role4);
		
		userDao.linkUserToRole(client1, role1);
		userDao.linkUserToRole(client1, role2);
	}

	@Test
	public void client2() {
		userDao.insert(client2);
		roleDao.insert(role1);
		roleDao.insert(role2);
		
		userDao.linkUserToRole(client2, role1);
		userDao.linkUserToRole(client2, role2);
	}
	
	@Test
	public void client3() {
		userDao.insert(client3);
		roleDao.insert(role1);
		roleDao.insert(role2);
		
		userDao.linkUserToRole(client3, role1);
		userDao.linkUserToRole(client3, role2);
	}
	
	@Test
	public void client4() {
		userDao.insert(client4);
		roleDao.insert(role1);
		roleDao.insert(role2);
		
		userDao.linkUserToRole(client4, role1);
		userDao.linkUserToRole(client4, role2);
	}

}

package com.sharemycar.dao.test;


import java.util.ArrayList;
import java.util.List;

import com.sharemycar.entity.User;
import com.sharemycar.entity.Ville;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.UserService;
import com.sharemycar.service.VilleService;

public class findAllLieux {


	public static void main(String[] args) {

		VilleService villeService = FacadeFactory.getInstance().getVilleService();

		List<Ville> villes = new ArrayList<Ville>();
		
		
		UserService userService = FacadeFactory.getInstance().getUserService();
		List<User> users = new ArrayList<User>();
		
		users = userService.findAllUser();
		
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
		
		
		
		
		
		
		
		
		
		villes = villeService.findAll();
		
		
		for (int i = 0; i < villes.size(); i++) {
			System.out.println(villes.get(i));
		}

		
		

		
	}

}

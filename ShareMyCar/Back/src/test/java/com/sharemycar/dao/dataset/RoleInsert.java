package com.sharemycar.dao.dataset;

import org.apache.log4j.Logger;
import com.sharemycar.entity.Role;
import com.sharemycar.facade.FacadeFactory;

public class RoleInsert {

	private static final Logger log = Logger.getLogger(RoleInsert.class);

	public static void main(String[] args) {

		// instanciation des roles
		Role role1 = new Role("client");
		Role role2 = new Role("Consultation");
		Role role3 = new Role("actif");
		Role role4 = new Role("suspendu");



		log.info("insert role");
		FacadeFactory.getInstance().getRoleService().insert(role1);
		FacadeFactory.getInstance().getRoleService().insert(role2);
		FacadeFactory.getInstance().getRoleService().insert(role3);
		FacadeFactory.getInstance().getRoleService().insert(role4);

		
	}

}

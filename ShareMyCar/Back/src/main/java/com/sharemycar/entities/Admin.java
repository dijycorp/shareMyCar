package com.sharemycar.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Admin")
public class Admin extends User {
	
	private Date dateDerniereAction;
	
	public Admin() {}
	

	public Admin(String nom, String prenom, String email, String login, String password, Boolean actif,
			Boolean restraint, String token) {
		super(nom, prenom, email, login, password, actif, restraint, token);
		// TODO Auto-generated constructor stub
	}

	public Admin(Date dateDerniereAction) {
		super();
		this.dateDerniereAction = dateDerniereAction;
	}

	public Date getDateDerniereAction() {
		return dateDerniereAction;
	}

	public void setDateDerniereAction(Date dateDerniereAction) {
		this.dateDerniereAction = dateDerniereAction;
	}

	@Override
	public String toString() {
		return "Admin [dateDerniereAction=" + dateDerniereAction + "]";
	}

	
}
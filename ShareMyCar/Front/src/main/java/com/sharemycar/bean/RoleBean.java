package com.sharemycar.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sharemycar.entities.Role;
import com.sharemycar.facade.FacadeFactory;

@ManagedBean(name = "roleBean")
@SessionScoped
public class RoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Role role;
	
	private List<Role> listRoles;

	/*
	 * m�thodes
	 */
	
	public void ajoutEvent(ActionEvent actionEvent) {
		setRole(new Role());
	}

	public void editEvent(Role role) {
		setRole(FacadeFactory.getInstance().getRoleService().findById(role.getId()));
	}

	public void update(ActionEvent actionEvent) {
		
		try {
			// mise � jour depuis la factory
			FacadeFactory.getInstance().getRoleService().update(role);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Mise � jour effectu�", "Le r�le a �t� mis � jour avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
//			remise � z�ro du role dans le bean
			role= new Role();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre le r�le � jour", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void insert(ActionEvent actionEvent) {

		try {
			// insertion depuis la factory
			FacadeFactory.getInstance().getRoleService().insert(role);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Insertion effectu�", "Le r�le a �t� ajout� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise � z�ro du r�le dans le bean
			role = new Role();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre le r�le � jour", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void delete(ActionEvent actionEvent) {

		try {
			// insertion depuis la factory
			FacadeFactory.getInstance().getRoleService().delete(role);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Suppression effectu�", "Le r�le a �t� supprim� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise � z�ro du r�le dans le bean
			role = new Role();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de supprim� le r�le", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	/*
	 * getter et setter
	 */

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getListRoles() {
		listRoles = FacadeFactory.getInstance().getRoleService().findAll();
		return listRoles;
	}

	public void setListRoles(List<Role> listRoles) {
		this.listRoles = listRoles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

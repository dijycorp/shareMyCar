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
	 * méthodes
	 */
	
	public void ajoutEvent(ActionEvent actionEvent) {
		setRole(new Role());
	}

	public void editEvent(Role role) {
		setRole(FacadeFactory.getInstance().getRoleService().findById(role.getId()));
	}

	public void update(ActionEvent actionEvent) {
		
		try {
			// mise à jour depuis la factory
			FacadeFactory.getInstance().getRoleService().update(role);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Mise à jour effectué", "Le rôle a été mis à jour avec succès");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
//			remise à zéro du role dans le bean
			role= new Role();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre le rôle à jour", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void insert(ActionEvent actionEvent) {

		try {
			// insertion depuis la factory
			FacadeFactory.getInstance().getRoleService().insert(role);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Insertion effectué", "Le rôle a été ajouté avec succès");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise à zéro du rôle dans le bean
			role = new Role();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre le rôle à jour", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void delete(ActionEvent actionEvent) {

		try {
			// insertion depuis la factory
			FacadeFactory.getInstance().getRoleService().delete(role);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Suppression effectué", "Le rôle a été supprimé avec succès");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise à zéro du rôle dans le bean
			role = new Role();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de supprimé le rôle", "erreur : " + e);
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

package com.sharemycar.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.entities.Admin;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.UserAdminService;

@ManagedBean(name = "adminBean")
@SessionScoped
public class AdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// inclut le client qui sera utilisé pour l'inscription
	@ManagedProperty(value = "#{userConnexionBean}")
	private UserConnexionBean userConnexionBean;

	// récupère le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	// recupère le service user client pour le traitement
	UserAdminService UserAdminService = FacadeFactory.getInstance().getUserAdminService();

	private String password;
	private String passwordConfirme;

	
	/*
	 * Méthodes
	 */
	
	public String doChangeMDP() {

		try {
			// recupération de l'utiisateur courant
			Admin admin = (Admin) userConnexionBean.getUser();
			// affectation à l'objet récupéré
			admin.setPassword(password);
			// mise à jour dans la base de données
			UserAdminService.update(admin);

			// génération du message de confirmation
			FacesMessage msg = new FacesMessage("Changement effectué", "tous est OK");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// redirige vers l'espace admin
			return navigationBean.fwAccueilAdmin();

		} catch (Exception e) {

			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Erreur", "le changement du mot de passe a échoué, erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// redirige vers l'espace personnel de l'admin
			return navigationBean.fwAccueilAdmin();
		}

	}

	public String doUpdateAdmin() {

		try {

			// récupération de l'utilisateur courant et mise à jour dans la base
			UserAdminService.update((Admin) userConnexionBean.getUser());

			// génération du message de confirmation
			FacesMessage msg = new FacesMessage("Modifications effectués",
					"L'ensemble des modifications attendus ont été effectués");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// redirige vers l'espace personnel de l'admin
			return navigationBean.fwAccueilAdmin();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Erreur", "Information complémentaire : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// redirige vers l'espace personnel de l'admin
			return navigationBean.fwAccueilAdmin();
		}

	}

	/**
	 * 
	 * getter et setter
	 */

	public UserConnexionBean getUserConnexionBean() {
		return userConnexionBean;
	}

	public void setUserConnexionBean(UserConnexionBean userConnexionBean) {
		this.userConnexionBean = userConnexionBean;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirme() {
		return passwordConfirme;
	}

	public void setPasswordConfirme(String passwordConfirme) {
		this.passwordConfirme = passwordConfirme;
	}

	public UserAdminService getUserAdminService() {
		return UserAdminService;
	}

	public void setUserAdminService(UserAdminService userAdminService) {
		UserAdminService = userAdminService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

package com.sharemycar.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.entities.Admin;
import com.sharemycar.entities.Role;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.UserAdminService;

@ManagedBean(name = "gestionAdminBean")
@SessionScoped
public class GestionAdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Admin admin;
	private List<Admin> listAdmins;

	private String password1;
	private String password2;
	private List<Role> listRolesSelected;

	// recup�re les beans g�rer
	UserAdminService userAdminService = FacadeFactory.getInstance().getUserAdminService();

	// r�cup�re le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	@ManagedProperty(value = "#{roleBean}")
	private RoleBean roleBean;

	/*
	 * methodes
	 */

	public void ajoutEvent(ActionEvent actionEvent) {
		setAdmin(new Admin());
	}

	public void editEvent(Admin admin) {
		setAdmin(admin);
	}

	public void update(ActionEvent actionEvent) {

		try {
			
			// affectation du user aux r�les
			for (Role role : admin.getRoles()) {
				role.getUsers().add(admin);
			}

			// mise � jour du user depuis la factory
			FacadeFactory.getInstance().getUserAdminService().update(admin);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("mise � jour effectu�",
					"La mise � jour de l'admin a �t� effectu� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise � z�ro du admin dans le bean
			admin = new Admin();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre � jour l'admin", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void updateMdp(ActionEvent actionEvent) {

		try {
			// affectation du mot de passe saisie(la correspondance et g�rer
			// dans le xhtml)
			admin.setPassword(password1);

			// mise � jour du user depuis la factory
			FacadeFactory.getInstance().getUserAdminService().update(admin);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("mise � jour effectu�",
					"La mise � jour du mot de passe pour le admin : " + admin.getLogin()
							+ "a �t� effectu� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise � z�ro du admin dans le bean
			admin = new Admin();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre le mot de passe du admin", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void insert(ActionEvent actionEvent) {

		try {
			
			// affectation du user aux r�les
			for (Role role : admin.getRoles()) {
				role.getUsers().add(admin);
			}

			/*
			 * affectation des valeurs par d�faut lors d'une cr�ation de compte
			 */
			
			// mot de passe r�cup�r�, la correspondance est fait par primeface
			admin.setPassword(password1);

			// mise � jour du user depuis la factory
			FacadeFactory.getInstance().getUserAdminService().update(admin);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("Inscription effectu�",
					"Votre demande d'inscription a �t� prise en compte avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise � z�ro du admin dans le bean
			admin = new Admin();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible d'ajouter le admin", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void delete(ActionEvent actionEvent) {
		try {
			// suppression du compte par appel du service
			FacadeFactory.getInstance().getUserAdminService().delete(admin);
			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("Suppression effectu�",
					"Votre demande de suppression du compte de " + admin.getLogin() + " a �t� effectu� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise � z�ro du admin dans le bean
			admin = new Admin();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de supprim� l'utilisateur, erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}
	}

	/*
	 * getter et setter
	 */

	public RoleBean getRoleBean() {
		return roleBean;
	}

	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public List<Admin> getListAdmins() {
		listAdmins = FacadeFactory.getInstance().getUserAdminService().findAllAdmin();
		return listAdmins;
	}

	public void setListAdmins(List<Admin> listAdmins) {
		this.listAdmins = listAdmins;
	}

	public UserAdminService getUserAdminService() {
		return userAdminService;
	}

	public void setUserAdminService(UserAdminService userAdminService) {
		this.userAdminService = userAdminService;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Role> getListRolesSelected() {
		return listRolesSelected;
	}

	public void setListRolesSelected(List<Role> listRolesSelected) {
		this.listRolesSelected = listRolesSelected;
	}

}

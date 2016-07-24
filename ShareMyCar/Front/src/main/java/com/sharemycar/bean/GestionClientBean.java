package com.sharemycar.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.ElementCollection;

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Role;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.UserClientService;

@ManagedBean(name = "gestionClientBean")
@SessionScoped
public class GestionClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Client client;
	@ElementCollection
	private List<Client> listClients;

	private String password1;
	private String password2;
	

	// recup�re le service pour les clients
	UserClientService userClientService = FacadeFactory.getInstance().getUserClientService();

	// r�cup�re le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	@ManagedProperty(value = "#{roleBean}")
	private RoleBean roleBean;

	@ManagedProperty(value = "#{environnementBean}")
	private EnvironnementBean environnementBean;

	/*
	 * m�thodes
	 */

	public void ajoutEvent() {
		setClient(new Client());
	}

	public void editEvent(Client client) {
		setClient(client);
	}

	public void update(ActionEvent actionEvent) {

		try {
			// affectation du user aux r�les
			for (Role role : client.getRoles()) {
				role.getUsers().add(client);
			}

			// mise � jour du user depuis la factory
			FacadeFactory.getInstance().getUserClientService().update(client);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("mise � jour effectu�",
					"La mise � jour du client a �t� effectu� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise � z�ro du client dans le bean
			client = new Client();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre le client", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void updateMdp() {

		try {
			// affectation du mot de passe saisie(la correspondance et g�rer
			// dans le xhtml)
			client.setPassword(password1);

			// mise � jour du user depuis la factory
			FacadeFactory.getInstance().getUserClientService().update(client);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("mise � jour effectu�",
					"La mise � jour du mot de passe pour le client : " + client.getLogin()
							+ "a �t� effectu� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise � z�ro du client dans le bean
			client = new Client();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre � jour le mot de passe du client",
					"erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void insert() {

		try {

			// affectation des r�les aux users
			// affectation du user aux r�les
			for (Role role : client.getRoles()) {
				role.getUsers().add(client);
			}

			/*
			 * affectation des valeurs par d�faut lors d'une cr�ation de compte
			 */
			// date g�n�r� au moment du click
			client.setDateInscription(new Date());
			// mot de passe r�cup�r�, la correspondance est fait par primeface
			client.setPassword(password1);

			// mise � jour du user depuis la factory
			FacadeFactory.getInstance().getUserClientService().update(client);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("Inscription effectu�",
					"Votre demande d'inscription a �t� prise en compte avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise � z�ro du client dans le bean
			client = new Client();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible d'ajouter le client", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void delete() {
		try {
			// suppression du compte par appel du service
			FacadeFactory.getInstance().getUserClientService().delete(client);
			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("Suppression effectu�",
					"Votre demande de suppression du compte de " + client.getLogin() + " a �t� effectu� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise � z�ro du client dans le bean
			client = new Client();
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListClient() {
		try {
			listClients = FacadeFactory.getInstance().getUserClientService().findAllClient();
			return listClients;
		} catch (Exception e) {
			return null;
		}
	}

	public void setListClient(List<Client> listClients) {
		this.listClients = listClients;
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

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}

	public UserClientService getUserClientService() {
		return userClientService;
	}

	public void setUserClientService(UserClientService userClientService) {
		this.userClientService = userClientService;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public EnvironnementBean getEnvironnementBean() {
		return environnementBean;
	}

	public void setEnvironnementBean(EnvironnementBean environnementBean) {
		this.environnementBean = environnementBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

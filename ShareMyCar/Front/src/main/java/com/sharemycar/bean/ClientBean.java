package com.sharemycar.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Environnement;
import com.sharemycar.entities.Reservation;
import com.sharemycar.entities.Trajet;
import com.sharemycar.entities.Voiture;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.UserClientService;

@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// inclut le client qui sera utilisé pour l'inscription
	private Client client = new Client();

	// stokage des mots de passe
	private String password;
	private String passwordConfirme;

	private List<Voiture> listVoitures;
	private List<Environnement> listEnvironnement;
	private List<Reservation> listReservations;
	private List<Trajet> listTrajets;

	// recupère le service user client pour le traitement
	UserClientService userClientService = FacadeFactory.getInstance().getUserClientService();

	// inclut le client qui sera utilisé pour l'inscription
	@ManagedProperty(value = "#{userConnexionBean}")
	private UserConnexionBean userConnexionBean;

	// récupère le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	/*
	 * méthodes
	 */

	public String doInscription() {

		try {
			client.setPassword(password);

			// par défaut, le compte n'est pas actif jusquà la confirmation par
			// mail
			client.setActif(false);
			// le compte n'est pas restraint, c'est une option pour les admins
			// sur
			// les comtpes
			client.setDateInscription(new Date());
			client.setRestraint(false);
			// le token est générer depuis le setter
			// mets comme valeur la date d'action du script, qui correspondant
			// donc
			// à la date d'inscription

			// insert le client préalablement remplis
			client = userClientService.insert(client);

			// génère un nouveau client dans le bean
			client = new Client();

			return navigationBean.fwIndex();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de prendre en compte l'inscription", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// retour à la page d'inscription
			return navigationBean.fwInscription();
		}

	}

	public String doChangeMDP() {

		try {
			// recupération de l'utiisateur courant
			Client client = (Client) userConnexionBean.getUser();
			// affecation du nouveau mot de passe
			client.setPassword(password);
			// mise à jour dans la base
			userClientService.update(client);

			// génération du message de confirmation
			FacesMessage msg = new FacesMessage("Changement effectué", "tous est OK");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			client = new Client();
			
			// redirige vers l'espace client
			return navigationBean.fwAccueilClient();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Erreur", "le changement du mot de passe a échoué, erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// redirige vers l'espace client
			return navigationBean.fwAccueilClient();
		}

	}

	public String doUpdateClient() {

		try {
			// mise à jour du client depuis la factory
			userClientService.update((Client) userConnexionBean.getUser());

			// génération du message de confirmation
			FacesMessage msg = new FacesMessage("Modifications effectués",
					"L'ensemble des modifications attendus ont été effectués");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			client = new Client();
			// retour à l'espace client
			return navigationBean.fwAccueilClient();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Erreur", "Information complémentaire : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// retour à l'espace personnel
			return navigationBean.fwAccueilClient();
		}

	}
	
	

	// getter et setter

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public List<Voiture> getListVoitures() {
		listVoitures = client.getVoitures();
		return listVoitures;
	}

	public void setListVoitures(List<Voiture> listVoitures) {
		this.listVoitures = listVoitures;
	}

	public List<Environnement> getListEnvironnement() {
		listEnvironnement = client.getEnvironnements();
		return listEnvironnement;
	}

	public void setListEnvironnement(List<Environnement> listEnvironnement) {
		this.listEnvironnement = listEnvironnement;
	}

	public UserConnexionBean getUserConnexionBean() {
		return userConnexionBean;
	}

	public void setUserConnexionBean(UserConnexionBean userConnexionBean) {
		this.userConnexionBean = userConnexionBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Reservation> getListReservations() {
		listReservations = client.getTrajetsPassager();
		return listReservations;
	}

	public void setListReservations(List<Reservation> listReservations) {
		this.listReservations = listReservations;
	}

	public List<Trajet> getListTrajets() {
		listTrajets = client.getTrajetsChauffeur();
		return listTrajets;
	}

	public void setListTrajets(List<Trajet> listTrajets) {
		this.listTrajets = listTrajets;
	}

}

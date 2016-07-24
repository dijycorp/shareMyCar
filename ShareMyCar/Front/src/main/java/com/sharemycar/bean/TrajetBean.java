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

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.bean.tools.DateToolsBean;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Trajet;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.TrajetService;

@ManagedBean(name = "trajetBean")
@SessionScoped
public class TrajetBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// stocke les donn�es relativent au trajet � publier
	private Trajet trajet = new Trajet();

	private List<Trajet> listTrajets;
	private List<Trajet> listTrajetsTop;
	private List<Trajet> listTrajetsNew;

	private Date dateDepart;
	private Date heureDepart;

	@ManagedProperty(value = "#{userConnexionBean}")
	private UserConnexionBean userConnexionBean;

	@ManagedProperty(value = "#{voitureBean}")
	private VoitureBean voitureBean;

	// recup�re le service pour traiter les Trajets
	private TrajetService trajetService = FacadeFactory.getInstance().getTrajetService();

	// r�cup�re le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	/*
	 * M�thodes
	 */

	public String publierTrajet() {
		try {
			// r�cup�ration de l'utilisateur connecter pour lui affecter le
			// trajet � publier
			trajet.setChauffeur((Client) userConnexionBean.getUser());

			trajet.setDateDepart(DateToolsBean.additionnerDateAvecHeure(dateDepart, heureDepart));
			
			//date de publication
			trajet.setDatePublication(new Date());

			// ajout du trajet en base
			trajetService.insert(trajet);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("Publication effectu�",
					"Le trajet et � pr�sent disponible en consultation sur le site internet");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// g�n�ration d'un nouveau trajet dans le bean
			trajet = new Trajet();
			dateDepart = null;
			heureDepart = null;

			// redirection vers l'espace client
			return navigationBean.fwAccueilClient();

		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de publier le trajet", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// retour � l'espace client
			return navigationBean.fwAccueilClient();
			
		}
	}

	public String publierTrajetAdmin() {
		try {

			//date de d�part du trajet
			trajet.setDateDepart(DateToolsBean.additionnerDateAvecHeure(dateDepart, heureDepart));
			
			//date de publication du trajet
			trajet.setDatePublication(new Date());


			// ajout du trajet en base
			trajetService.insert(trajet);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("Publication effectu�",
					"Le trajet et � pr�sent disponible en consultation sur le site internet");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// g�n�ration d'un nouveau trajet dans le bean
			trajet = new Trajet();
			dateDepart = null;
			heureDepart = null;

			// redirection vers l'espace client
			return navigationBean.fwAccueilClient();

		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de publier le trajet", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// retour � l'espace client
			return navigationBean.fwAccueilClient();
		}
	}

	public String consulterTrajet(Trajet trajet) {

		try {
			// r�cup�re le trajet en base
			this.trajet = trajet;
			return navigationBean.fwConsulterTrajet();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Trajet introuvable", String.valueOf(e));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return navigationBean.fwIndex();
		}

	}
	
	public String reserverTrajet(Trajet trajet) {
		
		try {
			// r�cup�re le trajet en base
			this.trajet = trajet;
			return navigationBean.fwReserverTrajetClient();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Trajet introuvable", String.valueOf(e));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return navigationBean.fwIndex();
		}
		
	}
	
	public String annulerTrajet(Trajet trajet){
		try {

			trajet.setAnnuler(true);
			// ajout du trajet en base
			trajetService.update(trajet);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("Annulation effectu�",
					"Le trajet et � pr�sent indisponible en consultation sur le site internet");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// g�n�ration d'un nouveau trajet dans le bean
			trajet = new Trajet();
			dateDepart = null;
			heureDepart = null;

			// redirection vers l'espace client
			return navigationBean.fwAccueilClient();

		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible d'annuler le trajet", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// retour � l'espace client
			return navigationBean.fwAccueilClient();
		}
	}
	

	public void ajoutEvent(ActionEvent actionEvent) {
		setTrajet(new Trajet());
	}

	public void editEvent(Trajet trajet) {
		setTrajet(trajet);
	}

	public void update(ActionEvent actionEvent) {

		try {
			// mise � jour depuis la factory
			FacadeFactory.getInstance().getTrajetService().update(trajet);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Mise � jour effectu�", "Le trajet a �t� mis � jour avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise � z�ro du trajet dans le bean
			trajet = new Trajet();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre le trajet � jour", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void delete(ActionEvent actionEvent) {

		try {
			// insertion depuis la factory
			FacadeFactory.getInstance().getTrajetService().delete(trajet);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Suppression effectu�", "Le trajet a �t� supprim� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise � z�ro du trajet dans le bean
			trajet = new Trajet();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de supprim� le trajet", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	/*
	 * getter et setter
	 */

	public UserConnexionBean getUserConnexionBean() {
		return userConnexionBean;
	}

	public void setUserConnexionBean(UserConnexionBean userConnexionBean) {
		this.userConnexionBean = userConnexionBean;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public TrajetService getTrajetService() {
		return trajetService;
	}

	public void setTrajetService(TrajetService trajetService) {
		this.trajetService = trajetService;
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

	public VoitureBean getVoitureBean() {
		return voitureBean;
	}

	public void setVoitureBean(VoitureBean voitureBean) {
		this.voitureBean = voitureBean;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public List<Trajet> getListTrajets() {
		listTrajets = FacadeFactory.getInstance().getTrajetService().findAll();

		return listTrajets;
	}

	public void setListTrajets(List<Trajet> listTrajets) {
		this.listTrajets = listTrajets;
	}

	public List<Trajet> getListTrajetsTop() {
		listTrajetsTop = trajetService.topDestination(100);
		return listTrajetsTop;
	}

	public void setListTrajetsTop(List<Trajet> listTrajetsTop) {
		this.listTrajetsTop = listTrajetsTop;
	}

	public List<Trajet> getListTrajetsNew() {
		listTrajetsNew = trajetService.nouveaute(100);
		return listTrajetsNew;
	}

	public void setListTrajetsNew(List<Trajet> listTrajetsNew) {
		this.listTrajetsNew = listTrajetsNew;
	}

}

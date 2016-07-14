package com.sharemycar.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.entity.Client;
import com.sharemycar.entity.Voiture;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.VoitureService;

@ManagedBean(name = "voitureBean")
@SessionScoped
public class VoitureBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private VoitureService voitureService = FacadeFactory.getInstance().getVoitureService();

	private Voiture voiture = new Voiture();

	private List<Voiture> listVoitures;

	private Voiture voitureSelectionne;

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	@ManagedProperty(value = "#{userConnexionBean}")
	private UserConnexionBean userConnexionBean;

	/*
	 * methodes
	 */

	public String ajouterVoiture() {
		try {
			// r�cup�re le client connecter pour lui affecter la voiture cr�e
			voiture.setChauffeur((Client) userConnexionBean.getUser());

			// ajout de la voiture en base
			voitureService.insert(voiture);

			// g�n�ration du message de confirmation
			FacesMessage msg = new FacesMessage("Voiture ajout� avec succ�s",
					"votre demande pour ajout� une voiture � votre profil � bien �t� trait� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// mise � z�ro de la voiture dans le bean
			voiture = new Voiture();
			// retour � la gestion des voitures
			return navigationBean.fwAccueilClient();

		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Voiture impossible � enregistrer", String.valueOf(e));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// retour � l'espace de gestion des voitures
			return navigationBean.fwGererVoitureClient();
		}

	}

	/*
	 * getter et setter
	 */

	public VoitureService getVoitureService() {
		return voitureService;
	}

	public void setVoitureService(VoitureService voitureService) {
		this.voitureService = voitureService;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public List<Voiture> getListVoitures() {

		listVoitures = voitureService.findAll();
		return listVoitures;
	}

	public void setListVoitures(List<Voiture> listVoitures) {
		this.listVoitures = listVoitures;
	}

	public Voiture getVoitureSelectionne() {
		return voitureSelectionne;
	}

	public void setVoitureSelectionne(Voiture voitureSelectionne) {
		this.voitureSelectionne = voitureSelectionne;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public UserConnexionBean getUserConnexionBean() {
		return userConnexionBean;
	}

	public void setUserConnexionBean(UserConnexionBean userConnexionBean) {
		this.userConnexionBean = userConnexionBean;
	}

}

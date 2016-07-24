package com.sharemycar.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.entities.Trajet;
import com.sharemycar.entities.Ville;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.TrajetService;

@ManagedBean(name = "searchTrajet")
@RequestScoped
public class SearchTrajetBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Trajet> resultatRecherche;

	private Ville villeDepart;
	private Ville villeArrive;

	// recupère le service pour traiter les Trajets
	private TrajetService trajetService = FacadeFactory.getInstance().getTrajetService();

	// récupère le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	/*
	 * méthodes
	 */

	public String rechercheTrajet() {
		try {

			List<Trajet> trajets = trajetService.findAll();
			List<Trajet> trajetsFiltre = new ArrayList<Trajet>();

			for (int i = 0; i < trajets.size(); i++) {
				Trajet trajet = trajets.get(i);

				if ((trajet.getVilleDepart().equals(villeDepart)) && (trajet.getVilleArrive().equals(villeArrive))) {
					trajetsFiltre.add(trajet);
				}
			}
			setResultatRecherche(trajetsFiltre);

			return navigationBean.fwRecherche();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de récupérer les trajets", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
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

	public List<Trajet> getResultatRecherche() {
		return resultatRecherche;
	}

	public void setResultatRecherche(List<Trajet> resultatRecherche) {
		this.resultatRecherche = resultatRecherche;
	}

	public Ville getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(Ville villeDepart) {
		this.villeDepart = villeDepart;
	}

	public Ville getVilleArrive() {
		return villeArrive;
	}

	public void setVilleArrive(Ville villeArrive) {
		this.villeArrive = villeArrive;
	}

}

package com.sharemycar.bean.completion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.entities.Ville;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.VilleService;

@ManagedBean(name = "autoCompleteVilleBean")
@SessionScoped
public class AutoCompleteVilleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * attributs
	 */

	// recupère le service ville pour le traitement
	private VilleService villeService = FacadeFactory.getInstance().getVilleService();

	// récupère le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	/*
	 * méthodes
	 */

	public List<Ville> completeVille(String query) {
		try {

			List<Ville> villes = villeService.findAll();
			List<Ville> villesFiltre = new ArrayList<Ville>();

			for (int i = 0; i < villes.size(); i++) {
				Ville ville = villes.get(i);
				if (ville.getNomVille().toLowerCase().startsWith(query)) {
					villesFiltre.add(ville);
				}
			}
			return villesFiltre;
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de récupérer les villes automatiquement", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	/*
	 * getter et setter
	 */

	public VilleService getVilleService() {
		return villeService;
	}

	public void setVilleService(VilleService villeService) {
		this.villeService = villeService;
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

}

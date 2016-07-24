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
import com.sharemycar.entities.Client;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.UserClientService;

@ManagedBean(name = "autoCompleteClientBean")
@SessionScoped
public class AutoCompleteClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * attributs
	 */

	// recupère le service client pour le traitement
	private UserClientService userClientService = FacadeFactory.getInstance().getUserClientService();

	// récupère le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	/*
	 * méthodes
	 */

	public List<Client> completeClient(String query) {
		try {

			List<Client> clients = userClientService.findAllClient();
			List<Client> clientsFiltre = new ArrayList<Client>();

			for (int i = 0; i < clients.size(); i++) {
				Client client = clients.get(i);
				if (client.getLogin().toLowerCase().startsWith(query)) {
					clientsFiltre.add(client);
				}
			}
			return clientsFiltre;
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de récupérer les clients automatiquement", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	/*
	 * getter et setter
	 */


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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

package com.sharemycar.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.entities.User;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.UserService;

@ManagedBean(name = "userConnexionBean")
@SessionScoped
public class UserConnexionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * attributs
	 */

	// inclut le client qui sera utilis� pour l'inscription
	private User user;

	// stokage de l'identifiant et du mots de passe
	private String login;
	private String password;

	// stoke le statut de la connexion (co/deco)
	private Boolean logguer;

	// recup�re le service user client pour le traitement
	UserService userService = FacadeFactory.getInstance().getUserService();

	// r�cup�re le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	/*
	 * m�thodes
	 */

	public String doConnexion() {

		// fait une recherche de correspondances dans la base de donn�es
		user = userService.login(login, password);

		// si le r�sultat est null, c'est que id /mdp incorrect
		// le type de retour est param�trer dans impl Hibernate
		if (user == null) {
			// on indique que la personne n'est pas connect�
			logguer = false;

			// Set login ERROR
			FacesMessage msg = new FacesMessage("Erreur de connexion",
					"Identifiant et/ou mot de passe incorrect, merci de verifier vos informations de connexion");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// retour � la page de login
			return navigationBean.fwConnexion();

			// sinon on continue et en le passe en connecter
		} else if (user != null) {
			// on indique en session qu'il est connect�
			logguer = true;
			user.setDateDerniereConnexion(new Date());

			// informe que la connexion est effective
			FacesMessage msg = new FacesMessage("Connexion Effectu�", "Bienvenue " + user.getLogin());
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			return navigationBean.fwIndex();

		}

		// on remet la page en cas de soucis dans le calcul
		return navigationBean.fwConnexion();

	}

	public String doDeconnexion() {
		// par default le user n'est pas authentifi�

		try {
			// suppression des traces de la sessions
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			logguer = false;
			user = null;

			// g�n�re le message de confirmation
			FacesMessage msg = new FacesMessage("Deconnexion", "effectue avec succes");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// retour � la page de connexion
			return navigationBean.fwConnexion();

		} catch (Exception e) {
			// g�n�re le message d'erreur
			FacesMessage msg = new FacesMessage("La d�connexion a �choue", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// retour � la page de connexion
			return navigationBean.fwIndex();
		}

	}

	/*
	 * getter et setter
	 */

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLogguer() {
		return logguer;
	}

	public void setLogguer(Boolean logguer) {
		this.logguer = logguer;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

}

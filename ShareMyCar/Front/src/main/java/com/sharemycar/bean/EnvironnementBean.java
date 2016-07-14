package com.sharemycar.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sharemycar.entity.Environnement;
import com.sharemycar.facade.FacadeFactory;


@ManagedBean(name = "environnementBean")
@SessionScoped
public class EnvironnementBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Environnement environnement;
	private List<Environnement> listEnvironnements;

	
	/*
	 * m�thodes
	 */
	
	public void ajoutEvent(ActionEvent actionEvent) {
		setEnvironnement(new Environnement());
	}

	public void editEvent(int idEnvironnement) {
		setEnvironnement(FacadeFactory.getInstance().getEnvironnementService().findById(idEnvironnement));

	}

	public void insert(ActionEvent actionEvent) {

		try {
			// insertion depuis la factory
			FacadeFactory.getInstance().getEnvironnementService().insert(environnement);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Insertion effectu�", "L'environnement a �t� ajout� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise � z�ro de l'environnement dans le bean
			environnement = new Environnement();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre l'environnement � jour", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void delete(ActionEvent actionEvent) {

		try {
			// insertion depuis la factory
			FacadeFactory.getInstance().getEnvironnementService().delete(environnement);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Suppression effectu�", "L'environnement a �t� supprim� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise � z�ro de l'environnement dans le bean
			environnement = new Environnement();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de supprim� l'environnement", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public void update(ActionEvent actionEvent) {

		try {
			// mise � jour depuis la factory
			FacadeFactory.getInstance().getEnvironnementService().update(environnement);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Mise � jour effectu�", "L'environnement a �t� mis � jour avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
//			remise � z�ro de l'environnement dans le bean
			environnement= new Environnement();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre l'environnement � jour", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	/*
	 * getter et setter
	 */
	
	public Environnement getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(Environnement environnement) {
		this.environnement = environnement;
	}

	public List<Environnement> getListEnvironnements() {
		listEnvironnements = FacadeFactory.getInstance().getEnvironnementService().findAll();
		return listEnvironnements;
	}

	public void setListEnvironnements(List<Environnement> listEnvironnements) {
		this.listEnvironnements = listEnvironnements;
	}

}

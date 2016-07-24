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

import org.primefaces.event.FlowEvent;

import com.sharemycar.bean.nav.NavigationBean;
import com.sharemycar.bean.tools.DateToolsBean;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Reservation;
import com.sharemycar.entities.Trajet;
import com.sharemycar.facade.FacadeFactory;
import com.sharemycar.service.ReservationService;
import com.sharemycar.service.TrajetService;

@ManagedBean(name = "reservationBean")
@SessionScoped
public class ReservationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * propri�t�s
	 */

	private Reservation reservation;
	private Integer placeSouhaiter;
	
	private List<Reservation> listReservations;
	
	/*
	 * Beans g�r�s
	 */

	@ManagedProperty(value = "#{userConnexionBean}")
	private UserConnexionBean userConnexionBean;

	// recup�re le service pour traiter les Trajets
	private TrajetService trajetService = FacadeFactory.getInstance().getTrajetService();
	// recup�re le service pour traiter les r�servations
	private ReservationService reservationService = FacadeFactory.getInstance().getReservationService();

	// r�cup�re le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	// r�cup�re le bean de paiement
	@ManagedProperty(value = "#{paiementBean}")
	private PaiementBean paiementBean;

	/*
	 * gestion du flow de saisie de la page de r�servation
	 */
	
    public String onFlowProcess(FlowEvent event) {
            return event.getNewStep();
    }
	
	
	/*
	 * m�thodes
	 */

	public String effectuerReservation(Trajet trajet) {
		// stockage du message de confirmation en fonction du choix
		FacesMessage msg;

		try {
			setReservation(new Reservation());
			
			// mise � jour de la date de r�servation
			reservation.setDateSoumission(new Date());

			// association de la r�servation au trajet
			reservation.setTrajet(trajet);
			
			//indique le nombre de place disponible
			reservation.setNombrePlace(placeSouhaiter);
			

			// ajout du passager � la r�servation (ind�pendant du nombre de
			// place r�serv�) - - concerne les clients connect�
			reservation.setPassager((Client) userConnexionBean.getUser());

			reservation.setAccepte(false);

			// mise � jour depuis la factory
			FacadeFactory.getInstance().getReservationService().update(reservation);

			// ajout du message de confirmation
			msg = new FacesMessage("R�servation effectu�", "La r�servation a �t� effectu� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise � z�ro du reservation dans le bean
			setReservation(new Reservation());
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			msg = new FacesMessage("Impossible d'effectu� la reservation", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return navigationBean.fwAccueilClient();
	}

	public String accepterReservation(Boolean choix) {
		// stockage du message de confirmation en fonction du choix
		FacesMessage msg;

		try {

			// mise � jour du choix dans la r�servation
			reservation.setAccepte(choix);

			// mise � jour de la date d'acceptation/choix dans la r�servation
			reservation.setDateAcceptation(DateToolsBean.additionnerDateAvecHeure(new Date(), new Date()));

			// mise � jour depuis la factory
			FacadeFactory.getInstance().getReservationService().update(reservation);

			// ajout du message de confirmation
			if (choix) {
				// accept�
				msg = new FacesMessage("Acceptation effectu�", "Le reservation a �t� accept� avec succ�s");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else if (!choix) {
				// refus�
				msg = new FacesMessage("Refus effectu�", "Le refus pour cette r�servation a �t� effectu� avec succ�s");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}

			// remise � z�ro du reservation dans le bean
			reservation = new Reservation();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			msg = new FacesMessage("Impossible de mettre � jour la reservation", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return null;
	}
	
	public String consulterReservation(Reservation reservation) {

		try {
			// r�cup�re le trajet en base
			this.reservation = reservation;
			return navigationBean.fwConsulterTrajet();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Trajet introuvable", String.valueOf(e));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return navigationBean.fwIndex();
		}

	}

	/*
	 * m�thodes utilis� pour les popups d'administration
	 */

	public void ajoutEvent(ActionEvent actionEvent) {
		setReservation(new Reservation());
	}

	public void editEvent(Reservation reservation) {
		setReservation(reservation);
	}

	public void update(ActionEvent actionEvent) {

		try {
			// mise � jour depuis la factory
			FacadeFactory.getInstance().getReservationService().update(reservation);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Mise � jour effectu�", "Le reservation a �t� mis � jour avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise � z�ro du reservation dans le bean
			reservation = new Reservation();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre le reservation � jour", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void delete(ActionEvent actionEvent) {

		try {
			// insertion depuis la factory
			FacadeFactory.getInstance().getReservationService().delete(reservation);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Suppression effectu�", "Le reservation a �t� supprim� avec succ�s");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise � z�ro du reservation dans le bean
			reservation = new Reservation();
		} catch (Exception e) {
			// g�n�ration du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de supprim� le reservation", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	/*
	 * getter et setter
	 */

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public UserConnexionBean getUserConnexionBean() {
		return userConnexionBean;
	}

	public void setUserConnexionBean(UserConnexionBean userConnexionBean) {
		this.userConnexionBean = userConnexionBean;
	}

	public TrajetService getTrajetService() {
		return trajetService;
	}

	public void setTrajetService(TrajetService trajetService) {
		this.trajetService = trajetService;
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
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

	public PaiementBean getPaiementBean() {
		return paiementBean;
	}

	public void setPaiementBean(PaiementBean paiementBean) {
		this.paiementBean = paiementBean;
	}


	public Integer getPlaceSouhaiter() {
		return placeSouhaiter;
	}


	public void setPlaceSouhaiter(Integer placeSouhaiter) {
		this.placeSouhaiter = placeSouhaiter;
	}


	public List<Reservation> getListReservations() {
		listReservations = FacadeFactory.getInstance().getReservationService().findAll();
		return listReservations;
	}


	public void setListReservations(List<Reservation> listReservations) {
		this.listReservations = listReservations;
	}

}

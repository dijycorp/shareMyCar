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
	 * propriétés
	 */

	private Reservation reservation;
	private Integer placeSouhaiter;
	
	private List<Reservation> listReservations;
	
	/*
	 * Beans gérés
	 */

	@ManagedProperty(value = "#{userConnexionBean}")
	private UserConnexionBean userConnexionBean;

	// recupère le service pour traiter les Trajets
	private TrajetService trajetService = FacadeFactory.getInstance().getTrajetService();
	// recupére le service pour traiter les réservations
	private ReservationService reservationService = FacadeFactory.getInstance().getReservationService();

	// récupère le bean de navigation
	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	// récupère le bean de paiement
	@ManagedProperty(value = "#{paiementBean}")
	private PaiementBean paiementBean;

	/*
	 * gestion du flow de saisie de la page de réservation
	 */
	
    public String onFlowProcess(FlowEvent event) {
            return event.getNewStep();
    }
	
	
	/*
	 * méthodes
	 */

	public String effectuerReservation(Trajet trajet) {
		// stockage du message de confirmation en fonction du choix
		FacesMessage msg;

		try {
			setReservation(new Reservation());
			
			// mise à jour de la date de réservation
			reservation.setDateSoumission(new Date());

			// association de la réservation au trajet
			reservation.setTrajet(trajet);
			
			//indique le nombre de place disponible
			reservation.setNombrePlace(placeSouhaiter);
			

			// ajout du passager à la réservation (indépendant du nombre de
			// place réservé) - - concerne les clients connecté
			reservation.setPassager((Client) userConnexionBean.getUser());

			reservation.setAccepte(false);

			// mise à jour depuis la factory
			FacadeFactory.getInstance().getReservationService().update(reservation);

			// ajout du message de confirmation
			msg = new FacesMessage("Réservation effectué", "La réservation a été effectué avec succès");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// remise à zéro du reservation dans le bean
			setReservation(new Reservation());
		} catch (Exception e) {
			// génération du message d'erreur
			msg = new FacesMessage("Impossible d'effectué la reservation", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return navigationBean.fwAccueilClient();
	}

	public String accepterReservation(Boolean choix) {
		// stockage du message de confirmation en fonction du choix
		FacesMessage msg;

		try {

			// mise à jour du choix dans la réservation
			reservation.setAccepte(choix);

			// mise à jour de la date d'acceptation/choix dans la réservation
			reservation.setDateAcceptation(DateToolsBean.additionnerDateAvecHeure(new Date(), new Date()));

			// mise à jour depuis la factory
			FacadeFactory.getInstance().getReservationService().update(reservation);

			// ajout du message de confirmation
			if (choix) {
				// accepté
				msg = new FacesMessage("Acceptation effectué", "Le reservation a été accepté avec succès");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else if (!choix) {
				// refusé
				msg = new FacesMessage("Refus effectué", "Le refus pour cette réservation a été effectué avec succès");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}

			// remise à zéro du reservation dans le bean
			reservation = new Reservation();
		} catch (Exception e) {
			// génération du message d'erreur
			msg = new FacesMessage("Impossible de mettre à jour la reservation", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return null;
	}
	
	public String consulterReservation(Reservation reservation) {

		try {
			// récupère le trajet en base
			this.reservation = reservation;
			return navigationBean.fwConsulterTrajet();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Trajet introuvable", String.valueOf(e));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return navigationBean.fwIndex();
		}

	}

	/*
	 * méthodes utilisé pour les popups d'administration
	 */

	public void ajoutEvent(ActionEvent actionEvent) {
		setReservation(new Reservation());
	}

	public void editEvent(Reservation reservation) {
		setReservation(reservation);
	}

	public void update(ActionEvent actionEvent) {

		try {
			// mise à jour depuis la factory
			FacadeFactory.getInstance().getReservationService().update(reservation);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Mise à jour effectué", "Le reservation a été mis à jour avec succès");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise à zéro du reservation dans le bean
			reservation = new Reservation();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de mettre le reservation à jour", "erreur : " + e);
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void delete(ActionEvent actionEvent) {

		try {
			// insertion depuis la factory
			FacadeFactory.getInstance().getReservationService().delete(reservation);
			// ajout du message de confirmation
			FacesMessage msg = new FacesMessage("Suppression effectué", "Le reservation a été supprimé avec succès");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// remise à zéro du reservation dans le bean
			reservation = new Reservation();
		} catch (Exception e) {
			// génération du message d'erreur
			FacesMessage msg = new FacesMessage("Impossible de supprimé le reservation", "erreur : " + e);
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

package com.sharemycar.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Client")
public class Client extends User {

	private Date dateInscription;
	private Date dateDerniereActivite;
	private String telephone;

	//
	// propriete de mapping
	//

	// liste des environnement choisis par la personnes (musiques ect...)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_env", joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "environnement_id") )
	private List<Environnement> environnements = new ArrayList<Environnement>(0);

	// liste des voitures associées aux clients
	@OneToMany(mappedBy = "chauffeur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Voiture> voitures = new ArrayList<Voiture>(0);

	// list des avis associé pour cette personnes
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Avis> avis = new ArrayList<Avis>(0);

	// listes des trajets en tant que chauffeur
	@OneToMany(mappedBy = "chauffeur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Trajet> trajetsChauffeur = new ArrayList<Trajet>(0);

	// liste des trajets en tant que passager
	@OneToMany(mappedBy = "passager", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Reservation> trajetsPassager = new ArrayList<Reservation>(0);

	//
	// gestion des messages
	//

	// messages globaux
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "client_message", joinColumns = @JoinColumn(name = "client_id") , inverseJoinColumns = @JoinColumn(name = "message_id") )
	private List<Message> messages = new ArrayList<Message>(0);

	// messages envoyé
	@OneToMany(mappedBy = "clientExpediteur", cascade = CascadeType.ALL)
	private List<Message> messagesEnvoye = new ArrayList<Message>(0);

	// messages reçus
	@OneToMany(mappedBy = "clientDestinataire", cascade = CascadeType.ALL)
	private List<Message> messagesRecu = new ArrayList<Message>(0);

	//
	// getter + setter + contructeur
	//

	public Client() {
	}


	public Client(String nom, String prenom, String email, String login, String password, Boolean actif,
			Boolean restraint, String token) {
		super(nom, prenom, email, login, password, actif, restraint, token);
		// TODO Auto-generated constructor stub
	}

	public Client(Date dateInscription, Date dateDerniereActivite, String telephone) {
		super();
		this.dateInscription = dateInscription;
		this.dateDerniereActivite = dateDerniereActivite;
		this.telephone = telephone;
	}

	public Client(Date dateInscription, Date dateDerniereActivite, String telephone, List<Environnement> environnements,
			List<Avis> avis, List<Message> messages, List<Message> messagesEnvoye, List<Message> messagesRecu) {
		super();
		this.dateInscription = dateInscription;
		this.dateDerniereActivite = dateDerniereActivite;
		this.telephone = telephone;
		this.environnements = environnements;
		this.avis = avis;
		this.messages = messages;
		this.messagesEnvoye = messagesEnvoye;
		this.messagesRecu = messagesRecu;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Date getDateDerniereActivite() {
		return dateDerniereActivite;
	}

	public void setDateDerniereActivite(Date dateDerniereActivite) {
		this.dateDerniereActivite = dateDerniereActivite;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Trajet> getTrajetsChauffeur() {
		return trajetsChauffeur;
	}

	public void setTrajetsChauffeur(List<Trajet> trajetsChauffeur) {
		this.trajetsChauffeur = trajetsChauffeur;
	}

	public List<Reservation> getTrajetsPassager() {
		return trajetsPassager;
	}

	public void setTrajetsPassager(List<Reservation> trajetsPassager) {
		this.trajetsPassager = trajetsPassager;
	}

	public List<Message> getMessagesEnvoye() {
		return messagesEnvoye;
	}

	public void setMessagesEnvoye(List<Message> messagesEnvoye) {
		this.messagesEnvoye = messagesEnvoye;
	}

	public List<Message> getMessagesRecu() {
		return messagesRecu;
	}

	public void setMessagesRecu(List<Message> messagesRecu) {
		this.messagesRecu = messagesRecu;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Environnement> getEnvironnements() {
		return environnements;
	}

	public void setEnvironnements(List<Environnement> environnements) {
		this.environnements = environnements;
	}

	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	@Override
	public String toString() {
		return "Client [dateInscription=" + dateInscription + ", dateDerniereActivite=" + dateDerniereActivite
				+ ", telephone=" + telephone + "]";
	}
}
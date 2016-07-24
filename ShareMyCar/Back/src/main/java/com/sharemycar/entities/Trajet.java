package com.sharemycar.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="trajet")
public class Trajet {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Double prix;
	private Date dateDepart;
	private Date dureeEstime;
	private Date datePublication;
	private Double distance;
	private Integer placeDisponible;
	private Boolean autoSoumission;
	private Boolean annuler;
	private String infoComplementaire;
	
	@ManyToOne
	private Ville villeDepart;
	
	@ManyToOne
	private Ville villeArrive;
	
	@ManyToOne
	private Client chauffeur;
	
//	trajet donne lui a => soumission->reservation->paiement
	@OneToMany(mappedBy="trajet", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Reservation> reservations  = new ArrayList<Reservation>(0);
	
	
	@ManyToOne
	private Voiture voiture;
	
	
	public Trajet() {
	}

	public Trajet(Ville villeDepart, Ville villeArrive, Double prix, Date dateDepart, Date dureeEstime, Double distance,
			Integer placeDisponible, Boolean autoSoumission, Boolean annuler, String infoComplementaire) {
		super();
		this.villeDepart = villeDepart;
		this.villeArrive = villeArrive;
		this.prix = prix;
		this.dateDepart = dateDepart;
		this.dureeEstime = dureeEstime;
		this.distance = distance;
		this.placeDisponible = placeDisponible;
		this.autoSoumission = autoSoumission;
		this.annuler = annuler;
		this.infoComplementaire = infoComplementaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDureeEstime() {
		return dureeEstime;
	}

	public void setDureeEstime(Date dureeEstime) {
		this.dureeEstime = dureeEstime;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Integer getPlaceDisponible() {
		return placeDisponible;
	}

	public void setPlaceDisponible(Integer placeDisponible) {
		this.placeDisponible = placeDisponible;
	}

	public Boolean getAutoSoumission() {
		return autoSoumission;
	}

	public void setAutoSoumission(Boolean autoSoumission) {
		this.autoSoumission = autoSoumission;
	}

	public Boolean getAnnuler() {
		return annuler;
	}

	public void setAnnuler(Boolean annuler) {
		this.annuler = annuler;
	}

	public String getInfoComplementaire() {
		return infoComplementaire;
	}

	public void setInfoComplementaire(String infoComplementaire) {
		this.infoComplementaire = infoComplementaire;
	}

	@Override
	public String toString() {
		return "Trajet [id=" + id + ", villeDepart=" + villeDepart + ", villeArrive=" + villeArrive + ", prix=" + prix
				+ ", dateDepart=" + dateDepart + ", dureeEstime=" + dureeEstime + ", distance=" + distance
				+ ", placeDisponible=" + placeDisponible + ", autoSoumission=" + autoSoumission + ", annuler=" + annuler
				+ ", infoComplementaire=" + infoComplementaire + "]";
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Client getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Client chauffeur) {
		this.chauffeur = chauffeur;
	}

//	ajout des link
	
	public Trajet addReservation(Reservation reservation){
		this.getReservations().add(reservation);
		reservation.setTrajet(this);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trajet other = (Trajet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	
	
}
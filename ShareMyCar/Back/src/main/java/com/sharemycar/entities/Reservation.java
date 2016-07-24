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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Date dateSoumission;
	private Integer etat;
	private Integer nombrePlace;
	private Boolean accepte;
	private Date dateAcceptation;
	
	@OneToMany(mappedBy="reservation", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Avis> avis = new ArrayList<Avis>(0);

	@OneToOne(mappedBy="reservation", cascade=CascadeType.ALL)
	private Paiement paiement;
	
	@ManyToOne
	private Trajet trajet;
	
	@ManyToOne
	private Client passager;
	
	public Reservation() {
	}
	
	public Reservation(Date dateSoumission, Integer nombrePlace, Trajet trajet, Client passager) {
		super();
		this.dateSoumission = dateSoumission;
		this.nombrePlace = nombrePlace;
		this.trajet = trajet;
		this.passager = passager;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + "]";
	}

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public Integer getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public Boolean getAccepte() {
		return accepte;
	}

	public void setAccepte(Boolean accepte) {
		this.accepte = accepte;
	}

	public Date getDateAcceptation() {
		return dateAcceptation;
	}

	public void setDateAcceptation(Date dateAcceptation) {
		this.dateAcceptation = dateAcceptation;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public Client getPassager() {
		return passager;
	}

	public void setPassager(Client passager) {
		this.passager = passager;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}
	
//	fonction link
	
	public Reservation addAvis(Avis avis){
		this.getAvis().add(avis);
		avis.setReservation(this);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((trajet == null) ? 0 : trajet.hashCode());
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
		Reservation other = (Reservation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (trajet == null) {
			if (other.trajet != null)
				return false;
		} else if (!trajet.equals(other.trajet))
			return false;
		return true;
	}
	
	

}
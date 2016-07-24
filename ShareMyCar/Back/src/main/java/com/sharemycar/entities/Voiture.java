package com.sharemycar.entities;

import java.util.ArrayList;
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
@Table(name="voiture")
public class Voiture {

	@Id
	@GeneratedValue
	private Integer id;
	private String marque;
	private String modele;
	private String infoComplementaire;
	private Integer nombrePlace;
	
//	liste des photos associé à la voiture
	@OneToMany(mappedBy="voiture",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<PhotosVoiture> photosVoiture = new ArrayList<PhotosVoiture>(0);
	
//	liste des trajets effectuer par cette voiture
	@OneToMany(mappedBy="voiture", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Trajet> Trajets = new ArrayList<Trajet>(0);
	
//	chauffeur associé à cette voiture
	@ManyToOne
	private Client chauffeur;
	
	
//	getter + setter + constructeur
	
	public Voiture() {
	}


	public Voiture(String marque, String modele, String infoComplementaire, Integer nombrePlace) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.infoComplementaire = infoComplementaire;
		this.nombrePlace = nombrePlace;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public String getInfoComplementaire() {
		return infoComplementaire;
	}


	public void setInfoComplementaire(String infoComplementaire) {
		this.infoComplementaire = infoComplementaire;
	}


	public Integer getNombrePlace() {
		return nombrePlace;
	}


	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}


	@Override
	public String toString() {
		return "Voiture [id=" + id + ", marque=" + marque + ", modele=" + modele + ", infoComplementaire="
				+ infoComplementaire + ", NombrePlace=" + nombrePlace + "]";
	}


	public List<PhotosVoiture> getPhotosVoiture() {
		return photosVoiture;
	}


	public void setPhotosVoiture(List<PhotosVoiture> photosVoiture) {
		this.photosVoiture = photosVoiture;
	}


	public List<Trajet> getTrajets() {
		return Trajets;
	}


	public void setTrajets(List<Trajet> trajets) {
		Trajets = trajets;
	}


	public Client getChauffeur() {
		return chauffeur;
	}


	public void setChauffeur(Client chauffeur) {
		this.chauffeur = chauffeur;
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
		Voiture other = (Voiture) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
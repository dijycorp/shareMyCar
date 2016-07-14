package com.sharemycar.entity;

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
@Table(name="departement")
public class Departement{

	@Id
	@GeneratedValue
	private Integer id;
	private String nomDepartement;
	
	
	@OneToMany(mappedBy="departement", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Arrondissement> arrondissements = new ArrayList<Arrondissement>(0);
	
	@ManyToOne
	private Region region;
	
	public Departement() {
	}

	public Departement(String nomDepartement) {
		super();
		this.nomDepartement = nomDepartement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	@Override
	public String toString() {
		return "Departement [ nomDepartement=" + nomDepartement + "]";
	}
	
	public List<Arrondissement> getArrondissements() {
		return arrondissements;
	}

	public void setArrondissements(List<Arrondissement> arrondissements) {
		this.arrondissements = arrondissements;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public void addArrondissement(Arrondissement arrondissement){
		arrondissements.add(arrondissement);
		arrondissement.setDepartement(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomDepartement == null) ? 0 : nomDepartement.hashCode());
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
		Departement other = (Departement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomDepartement == null) {
			if (other.nomDepartement != null)
				return false;
		} else if (!nomDepartement.equals(other.nomDepartement))
			return false;
		return true;
	}
	
	
	
}
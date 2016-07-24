package com.sharemycar.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="arrondisement")
public class Arrondissement{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nomArrondissement;
	
	@OneToMany(mappedBy="arrondissement", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Ville> villes = new ArrayList<Ville>(0);
	
	@ManyToOne
	private Departement departement;
	
	public Arrondissement() {
	}
	
	public Arrondissement(String nomArrondissement) {
		super();
		this.nomArrondissement = nomArrondissement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomArrondissement() {
		return nomArrondissement;
	}

	public void setNomArrondissement(String nomArrondissement) {
		this.nomArrondissement = nomArrondissement;
	}

	@Override
	public String toString() {
		return "Arrondissement [ nomArrondissement=" + nomArrondissement + "]";
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public void addVille(Ville ville){
		villes.add(ville);
		ville.setArrondissement(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomArrondissement == null) ? 0 : nomArrondissement.hashCode());
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
		Arrondissement other = (Arrondissement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomArrondissement == null) {
			if (other.nomArrondissement != null)
				return false;
		} else if (!nomArrondissement.equals(other.nomArrondissement))
			return false;
		return true;
	}

	
	
}
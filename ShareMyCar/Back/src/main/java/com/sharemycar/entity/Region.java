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
@Table(name="region")
public class Region{

	@Id
	@GeneratedValue
	private Integer id;
	private String nomRegion;
	
	@OneToMany(mappedBy="region",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Departement> departements = new ArrayList<Departement>(0);
	
	@ManyToOne
	private Pays pays;
	
	public Region() {
	}

	public Region(String nomRegion) {
		super();
		this.nomRegion = nomRegion;
	}

	@Override
	public String toString() {
		return "Region [nomRegion=" + nomRegion + "]";
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	public void addDepartement(Departement departement){
		departements.add(departement);
		departement.setRegion(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomRegion == null) ? 0 : nomRegion.hashCode());
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
		Region other = (Region) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomRegion == null) {
			if (other.nomRegion != null)
				return false;
		} else if (!nomRegion.equals(other.nomRegion))
			return false;
		return true;
	}
	

}
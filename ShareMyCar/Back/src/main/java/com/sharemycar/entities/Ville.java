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
@Table(name="ville")
public class Ville{

	@Id
	@GeneratedValue
	private Integer id;
	private String nomVille;
	
	@OneToMany(mappedBy="villeDepart", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Trajet> departTrajets = new ArrayList<Trajet>(0);
	
	@OneToMany(mappedBy="villeArrive", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Trajet> arriveTrajets = new ArrayList<Trajet>(0);
	
	@ManyToOne
	private Arrondissement arrondissement;
	
	public Ville() {
	}

	public Ville(String nomVille) {
		super();
		this.nomVille = nomVille;
	}

	
	@Override
	public String toString() {
		return "Ville [nomVille=" + nomVille + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public List<Trajet> getDepartTrajets() {
		return departTrajets;
	}

	public void setDepartTrajets(List<Trajet> departTrajets) {
		this.departTrajets = departTrajets;
	}

	public List<Trajet> getArriveTrajets() {
		return arriveTrajets;
	}

	public void setArriveTrajets(List<Trajet> arriveTrajets) {
		this.arriveTrajets = arriveTrajets;
	}

	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
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
		Ville other = (Ville) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	


}
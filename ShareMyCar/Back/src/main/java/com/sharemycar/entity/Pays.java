package com.sharemycar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pays")
public class Pays {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nomPays;
	private Float ratioPrix;
	
	@OneToMany(mappedBy="pays", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Region> regions = new ArrayList<Region>(0);

	public Pays() {
	}

	public Pays(String nomPays, Float ratioPrix) {
		super();
		this.nomPays = nomPays;
		this.ratioPrix = ratioPrix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getRatioPrix() {
		return ratioPrix;
	}

	public void setRatioPrix(Float ratioPrix) {
		this.ratioPrix = ratioPrix;
	}

	public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	
	@Override
	public String toString() {
		return "Pays [id=" + id + ", nomPays=" + nomPays + ", ratioPrix=" + ratioPrix + "]";
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public void addRegion(Region region){
		regions.add(region);
		region.setPays(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomPays == null) ? 0 : nomPays.hashCode());
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
		Pays other = (Pays) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomPays == null) {
			if (other.nomPays != null)
				return false;
		} else if (!nomPays.equals(other.nomPays))
			return false;
		return true;
	}
	
	
	
}
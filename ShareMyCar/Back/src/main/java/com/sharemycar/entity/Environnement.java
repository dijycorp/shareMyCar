package com.sharemycar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "environnement")
public class Environnement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String label;
	private Integer niveauTolerance;

	@ManyToMany(mappedBy = "environnements", fetch = FetchType.EAGER)
	private List<Client> clients = new ArrayList<Client>(0);

	public Environnement() {
	}

	public Environnement(String label) {
		super();
		this.label = label;
	}

	public Environnement(String label, Integer niveauTolerance) {
		super();
		this.label = label;
		this.niveauTolerance = niveauTolerance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	// calculer graduelement, 0 étant le plus bas/pas accepté
	public Integer getNiveauTolerance() {
		return niveauTolerance;
	}

	public void setNiveauTolerance(Integer niveauTolerance) {
		this.niveauTolerance = niveauTolerance;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		String listClient = null;
		for (Client client : clients) {
			listClient = listClient + " " + client.toString() + "\n";
		}

		return "Environnement [id=" + id + ", label=" + label + ", niveauTolerance=" + niveauTolerance + "]"
				+ listClient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Environnement other = (Environnement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
}
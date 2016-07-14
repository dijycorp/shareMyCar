package com.sharemycar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="avis")
public class Avis {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Float note;
	private String commentaire;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Reservation reservation;

	public Avis() {
	}

	public Avis(Float note, String commentaire) {
		super();
		this.note = note;
		this.commentaire = commentaire;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + ", note=" + note + ", commentaire=" + commentaire + "]";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reservation == null) ? 0 : reservation.hashCode());
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
		Avis other = (Avis) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reservation == null) {
			if (other.reservation != null)
				return false;
		} else if (!reservation.equals(other.reservation))
			return false;
		return true;
	}

	

}
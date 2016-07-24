package com.sharemycar.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue
	private Integer id;
	private String message;
	private Integer etat;
	
	@ManyToOne
	private Client clientDestinataire;
	
	@ManyToOne
	private Client clientExpediteur;
	
	@ManyToMany(mappedBy="messages", fetch = FetchType.EAGER)
	private List<Client> messages = new ArrayList<Client>(0);
	
	@ManyToOne
	private Message messageReponse;
	
	@OneToMany(mappedBy="messageReponse", cascade=CascadeType.ALL)
	private List<Message> messageReponses;

	public Message() {
	}

	public Message(String message) {
		super();
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + "]";
	}

	public Client getClientDestinataire() {
		return clientDestinataire;
	}

	public void setClientDestinataire(Client clientDestinataire) {
		this.clientDestinataire = clientDestinataire;
	}

	public Client getClientExpediteur() {
		return clientExpediteur;
	}

	public void setClientExpediteur(Client clientExpediteur) {
		this.clientExpediteur = clientExpediteur;
	}

	public List<Client> getMessages() {
		return messages;
	}

	public void setMessages(List<Client> messages) {
		this.messages = messages;
	}

	public Message getMessageReponse() {
		return messageReponse;
	}

	public void setMessageReponse(Message messageReponse) {
		this.messageReponse = messageReponse;
	}

	public List<Message> getMessageReponses() {
		return messageReponses;
	}

	public void setMessageReponses(List<Message> messageReponses) {
		this.messageReponses = messageReponses;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
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
		Message other = (Message) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
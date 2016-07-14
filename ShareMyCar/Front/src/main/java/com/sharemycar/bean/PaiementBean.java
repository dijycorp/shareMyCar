package com.sharemycar.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sharemycar.entity.Paiement;
import com.sharemycar.entity.Reservation;

@ManagedBean(name = "paiementBean")
@SessionScoped
public class PaiementBean implements Serializable {

	/*
	 * propri�t�
	 */

	private static final long serialVersionUID = 1L;
	private Paiement paiement;

	/*
	 * Beans G�r�s
	 */

	/*
	 * m�thodes
	 */

	public Boolean payerReservation(Reservation reservation) {

		// TODO mettre en place le paiement

		return true;
	}

	/*
	 * Getter et Setter
	 */

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

}

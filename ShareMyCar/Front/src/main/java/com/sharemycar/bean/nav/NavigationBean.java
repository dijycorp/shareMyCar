package com.sharemycar.bean.nav;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class NavigationBean implements Serializable {

	public static final long serialVersionUID = 1L;

	/*
	 * paramètres des routes
	 */
	public String espaceClient = "/secure/client";
	public String espaceAdmin = "/secure/admin";
	public String redirect = "?faces-redirect=true";

	/*
	 * routes principales
	 */
	public String index = "/index";
	public String inscription = "/inscription";
	public String connexion = "/connexion";
	public String recherche = "/recherche";
	public String nouveaute = "/nouveaute";
	public String topDestinations = "/top-destinations";
	public String consulterTrajet = "/consulter-trajet";

	// routes clients
	public String changerMDPClient = "/change-mdp";
	public String accueilClient = "/compte-client";
	public String gererVoitureClient = "/gerer-voiture";
	public String mesReservations = "/mes-reservations";
	public String modifierCompteClient = "/modifier-compte";
	public String proposerTrajetClient = "/proposer-trajet";
	public String reserverTrajetClient = "/reserver-trajet";

	// routes admins
	public String accueilAdmin = "/administration";
	public String changerMDPAdmin = "/change-mdp";
	public String gererUsersAdmins = "/gerer-admins";
	public String gererAvisAdmin = "/gerer-avis";
	public String gererUsersClients = "/gerer-clients";
	public String gererEnvironnementsAdmin = "/gerer-environnements";
	public String gererLieuxAdmin = "/gerer-lieux";
	public String gererMessagesAdmin = "/gerer-messages";
	public String gererPaiementsAdmin = "/gerer-paiements";
	public String gererReservationsAdmin = "/gerer-reservations";
	public String gererRolesAdmin = "/gerer-roles";
	public String gererTrajetsAdmin = "/gerer-trajets";
	public String gererVoituresAdmin = "/gerer-voitures";
	public String modifierCompteAdmin = "/modifier-compte";
	public String publierTrajetAdmin = "/publier-trajet";
	public String reserverTrajetAdmin = "/reserver-trajet";

	/*
	 * redirections (change l'adresse dans la barre de navigation) -- options
	 * redirect Forward des routes (ne change pas l'adresse dans la barre de
	 * navigation)
	 */

	/*
	 * retour des routes générales
	 */

	public String goIndex() {return index + redirect;}
	public String fwIndex(){return index;}
	
	public String goInscription(){return inscription + redirect;}
	public String fwInscription(){return inscription;}
	
	public String goConnexion(){return connexion + redirect;}
	public String fwConnexion(){return connexion;}
	
	public String goRecherche(){return recherche + redirect;}
	public String fwRecherche(){return recherche;}
	
	public String goNouveaute(){return nouveaute + redirect;}
	public String fwNouveaute(){return nouveaute;}
	
	public String goTopDestination(){return topDestinations + redirect;}
	public String fwTopDestination(){return topDestinations;}
	
	public String goConsulterTrajet(){return consulterTrajet + redirect;}
	public String fwConsulterTrajet(){return consulterTrajet;}
	

	/*
	 * retour des routes clients
	 */

	public String goChangerMDPClient(){return espaceClient + changerMDPClient + redirect;}
	public String fwChangerMDPClient(){return espaceClient + changerMDPClient;}
	
	public String goAccueilClient(){return espaceClient + accueilClient + redirect;}
	public String fwAccueilClient(){return espaceClient + accueilClient;}
	
	public String goGererVoitureClient(){return espaceClient + gererVoitureClient + redirect;}
	public String fwGererVoitureClient(){return espaceClient + gererVoitureClient;}
	
	public String goMesReservations(){return espaceClient + mesReservations + redirect;}
	public String fwMesReservations(){return espaceClient + mesReservations;}
	
	public String goModifierCompteClient(){return espaceClient + modifierCompteClient + redirect;}
	public String fwModifierCompteClient(){return espaceClient + modifierCompteClient;}
	
	public String goProposerTrajetClient(){return espaceClient + proposerTrajetClient + redirect;}
	public String fwProposerTrajetClient(){return espaceClient + proposerTrajetClient;}
	
	public String goReserverTrajetClient(){return espaceClient + reserverTrajetClient + redirect;}
	public String fwReserverTrajetClient(){return espaceClient + reserverTrajetClient;}
	
	/*
	 * retour des routes Admins
	 */
	
	public String goAccueilAdmin(){return espaceAdmin + accueilAdmin + redirect;}
	public String fwAccueilAdmin(){return espaceAdmin + accueilAdmin;}
	
	public String goChangerMDPAdmin(){return espaceAdmin + changerMDPAdmin + redirect;}
	public String fwChangerMDPAdmin(){return espaceAdmin + changerMDPAdmin;}
	
	public String goGererUsersAdmins(){return espaceAdmin + gererUsersAdmins + redirect;}
	public String fwGererUsersAdmins(){return espaceAdmin + gererUsersAdmins;}
	
	public String goGererAvis(){return espaceAdmin + gererAvisAdmin + redirect;}
	public String fwGererAvis(){return espaceAdmin + gererAvisAdmin;}
	
	public String goGererUsersClients(){return espaceAdmin + gererUsersClients + redirect;}
	public String fwGererUsersClients(){return espaceAdmin + gererUsersClients;}
	
	public String goGererEnvironnementsAdmin(){return espaceAdmin + gererEnvironnementsAdmin + redirect;}
	public String fwGererEnvironnementsAdmin(){return espaceAdmin + gererEnvironnementsAdmin;}
	
	public String goGererLieuxAdmin(){return espaceAdmin + gererLieuxAdmin + redirect;}
	public String fwGererLieuxAdmin(){return espaceAdmin + gererLieuxAdmin;}
	
	public String goGererMessagesAdmin(){return espaceAdmin + gererMessagesAdmin + redirect;}
	public String fwGererMessagesAdmin(){return espaceAdmin + gererMessagesAdmin;}
	
	public String goGererPaiementsAdmin(){return espaceAdmin + gererPaiementsAdmin + redirect;}
	public String fwGererPaiementsAdmin(){return espaceAdmin + gererPaiementsAdmin;}
	
	public String goGererReservationsAdmin(){return espaceAdmin + gererReservationsAdmin + redirect;}
	public String fwGererReservationsAdmin(){return espaceAdmin + gererReservationsAdmin;}
	
	public String goGererRolesAdmin(){return espaceAdmin + gererRolesAdmin + redirect;}
	public String fwGererRolesAdmin(){return espaceAdmin + gererRolesAdmin;}
	
	public String goGererTrajetsAdmin(){return espaceAdmin + gererTrajetsAdmin + redirect;}
	public String fwGererTrajetsAdmin(){return espaceAdmin + gererTrajetsAdmin;}
	
	public String goGererVoituresAdmin(){return espaceAdmin + gererVoituresAdmin + redirect;}
	public String fwGererVoituresAdmin(){return espaceAdmin + gererVoituresAdmin;}
	
	public String goModifierCompteAdmin(){return espaceAdmin + modifierCompteAdmin + redirect;}
	public String fwModifierCompteAdmin(){return espaceAdmin + modifierCompteAdmin;}
	
	public String goPublierTrajetAdmin(){return espaceAdmin + publierTrajetAdmin + redirect;}
	public String fwPublierTrajetAdmin(){return espaceAdmin + publierTrajetAdmin;}
	
	public String goReserverTrajetAdmin(){return espaceAdmin + reserverTrajetAdmin + redirect;}
	public String fwReserverTrajetAdmin(){return espaceAdmin + reserverTrajetAdmin;}
	
}

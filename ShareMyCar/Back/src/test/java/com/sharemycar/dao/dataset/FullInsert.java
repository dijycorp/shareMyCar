package com.sharemycar.dao.dataset;

import java.util.Date;

import org.apache.log4j.Logger;

import com.sharemycar.entities.Admin;
import com.sharemycar.entities.Arrondissement;
import com.sharemycar.entities.Avis;
import com.sharemycar.entities.Client;
import com.sharemycar.entities.Departement;
import com.sharemycar.entities.Environnement;
import com.sharemycar.entities.Paiement;
import com.sharemycar.entities.Pays;
import com.sharemycar.entities.PhotosUtilisateur;
import com.sharemycar.entities.PhotosVoiture;
import com.sharemycar.entities.Region;
import com.sharemycar.entities.Reservation;
import com.sharemycar.entities.Role;
import com.sharemycar.entities.Trajet;
import com.sharemycar.entities.Ville;
import com.sharemycar.entities.Voiture;
import com.sharemycar.facade.FacadeFactory;

public class FullInsert {

	private static final Logger log = Logger.getLogger(FullInsert.class);

	public static void main(String[] args) {

		//
		// USER
		//

		log.info("début User");

		// instanciation des users spévifiques
		Client client1 = new Client("A- nom-client1", "prenom", "email", "login", "password", true, false, "token");
		client1.setDateInscription(new Date());
		Client client2 = new Client("B - nom-client2", "prenom", "email", "login", "password", true, false, "token");
		Client client3 = new Client("C - nom-client3", "prenom", "email", "login", "password", true, false, "token");
		Client client4 = new Client("D - nom-client4", "prenom", "email", "login", "password", true, false, "token");
		Admin admin1 = new Admin("Z - nom-admin1", "prenom", "email", "login", "password", true, true, "token");

		// instanciation des roles
		Role role1 = new Role("client");
		Role role2 = new Role("Consultation");
		Role role3 = new Role("actif");
		Role role4 = new Role("suspendu");

		// instanciation des environnements
		Environnement env1 = new Environnement("Parler", 0);
		Environnement env2 = new Environnement("Manger", 1);
		Environnement env3 = new Environnement("Chanter", 2);
		Environnement env4 = new Environnement("Parler", 3);

		// instanciation des photos users
		PhotosUtilisateur photo1 = new PhotosUtilisateur("client1");
		PhotosUtilisateur photo11 = new PhotosUtilisateur("client1-1");
		PhotosUtilisateur photo12 = new PhotosUtilisateur("client1-2");
		PhotosUtilisateur photo2 = new PhotosUtilisateur("client2");
		PhotosUtilisateur photo21 = new PhotosUtilisateur("client2-1");
		PhotosUtilisateur photo22 = new PhotosUtilisateur("client2-2");
		PhotosUtilisateur photo3 = new PhotosUtilisateur("client3");
		PhotosUtilisateur photo4 = new PhotosUtilisateur("client4");
		PhotosUtilisateur photoA1 = new PhotosUtilisateur("adm1");
		PhotosUtilisateur photoA2 = new PhotosUtilisateur("adm1-2");

		log.info("insert photos utilisateurs");
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photo1);
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photo11);
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photo12);
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photo2);
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photo21);
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photo22);
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photo3);
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photo4);
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photoA1);
		FacadeFactory.getInstance().getPhotosUtilisateurService().insert(photoA2);

		log.info("insertUser");
		FacadeFactory.getInstance().getUserClientService().insert(client1);
		FacadeFactory.getInstance().getUserClientService().insert(client2);
		FacadeFactory.getInstance().getUserClientService().insert(client3);
		FacadeFactory.getInstance().getUserClientService().insert(client4);
		FacadeFactory.getInstance().getUserAdminService().insert(admin1);

		log.info("insert role");
		FacadeFactory.getInstance().getRoleService().insert(role1);
		FacadeFactory.getInstance().getRoleService().insert(role2);
		FacadeFactory.getInstance().getRoleService().insert(role3);
		FacadeFactory.getInstance().getRoleService().insert(role4);

		log.info("insert environnement");
		FacadeFactory.getInstance().getEnvironnementService().insert(env1);
		FacadeFactory.getInstance().getEnvironnementService().insert(env2);
		FacadeFactory.getInstance().getEnvironnementService().insert(env3);
		FacadeFactory.getInstance().getEnvironnementService().insert(env4);

		log.info("link user to role");
		FacadeFactory.getInstance().getUserService().linkUserToRole(client4, role1);
		FacadeFactory.getInstance().getUserService().linkUserToRole(client4, role2);
		FacadeFactory.getInstance().getUserService().linkUserToRole(client4, role3);
		FacadeFactory.getInstance().getUserService().linkUserToRole(client4, role4);
		FacadeFactory.getInstance().getUserService().linkUserToRole(client3, role1);
		FacadeFactory.getInstance().getUserService().linkUserToRole(client3, role2);
		FacadeFactory.getInstance().getUserService().linkUserToRole(client3, role3);
		FacadeFactory.getInstance().getUserService().linkUserToRole(client2, role1);
		FacadeFactory.getInstance().getUserService().linkUserToRole(client2, role2);
		FacadeFactory.getInstance().getUserService().linkUserToRole(client1, role1);
		FacadeFactory.getInstance().getUserService().linkUserToRole(admin1, role4);

		log.info("link user to envi");
		FacadeFactory.getInstance().getUserClientService().linkClientToEnvironnement(client3, env1);
		FacadeFactory.getInstance().getUserClientService().linkClientToEnvironnement(client3, env2);
		FacadeFactory.getInstance().getUserClientService().linkClientToEnvironnement(client3, env3);
		FacadeFactory.getInstance().getUserClientService().linkClientToEnvironnement(client4, env4);
		FacadeFactory.getInstance().getUserClientService().linkClientToEnvironnement(client4, env2);
		FacadeFactory.getInstance().getUserClientService().linkClientToEnvironnement(client4, env3);
		FacadeFactory.getInstance().getUserClientService().linkClientToEnvironnement(client4, env1);
		
		log.info("link user to photos");
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(admin1, photoA1);
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(admin1, photoA2);
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(client1, photo1);
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(client1, photo11);
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(client1, photo12);
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(client2, photo2);
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(client2, photo21);
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(client2, photo22);
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(client3, photo3);
		FacadeFactory.getInstance().getUserService().linkUsertoPhoto(client4, photo4);

		log.info("debut de voiture");

		// instanciation des voitures
		Voiture voiture1 = new Voiture("renault", "Clio", "belle et spacisuese", 5);
		Voiture voiture2 = new Voiture("peugot", "206", "belle et spacisuese", 5);
		Voiture voiture3 = new Voiture("renault", "Mégane", "belle et spacisuese", 5);

		// instanciation des photos de voitures
		PhotosVoiture photoV1 = new PhotosVoiture("voiture1");
		PhotosVoiture photoV11 = new PhotosVoiture("voiture1-1");
		PhotosVoiture photoV12 = new PhotosVoiture("voiture1-2");
		PhotosVoiture photoV2 = new PhotosVoiture("voiture2");
		PhotosVoiture photoV3 = new PhotosVoiture("voiture3");
		PhotosVoiture photoV31 = new PhotosVoiture("voiture3-1");

		log.info("insert voiture");
		FacadeFactory.getInstance().getVoitureService().insert(voiture1);
		FacadeFactory.getInstance().getVoitureService().insert(voiture2);
		FacadeFactory.getInstance().getVoitureService().insert(voiture3);

		log.info("insert photos voitures");
		FacadeFactory.getInstance().getPhotosVoitureService().insert(photoV1);
		FacadeFactory.getInstance().getPhotosVoitureService().insert(photoV11);
		FacadeFactory.getInstance().getPhotosVoitureService().insert(photoV12);
		FacadeFactory.getInstance().getPhotosVoitureService().insert(photoV2);
		FacadeFactory.getInstance().getPhotosVoitureService().insert(photoV3);
		FacadeFactory.getInstance().getPhotosVoitureService().insert(photoV31);

		log.info("link voiture to photos");
		FacadeFactory.getInstance().getVoitureService().LinkVoitureToPhoto(voiture1, photoV1);
		FacadeFactory.getInstance().getVoitureService().LinkVoitureToPhoto(voiture1, photoV11);
		FacadeFactory.getInstance().getVoitureService().LinkVoitureToPhoto(voiture1, photoV12);
		FacadeFactory.getInstance().getVoitureService().LinkVoitureToPhoto(voiture2, photoV2);
		FacadeFactory.getInstance().getVoitureService().LinkVoitureToPhoto(voiture3, photoV3);
		FacadeFactory.getInstance().getVoitureService().LinkVoitureToPhoto(voiture3, photoV31);

		log.info("link voiture to client");
		FacadeFactory.getInstance().getUserClientService().linkClientToVoiture(client1, voiture1);
		FacadeFactory.getInstance().getUserClientService().linkClientToVoiture(client2, voiture2);
		FacadeFactory.getInstance().getUserClientService().linkClientToVoiture(client3, voiture3);

		log.info("insert link users");
		FacadeFactory.getInstance().getUserClientService().update(client1);
		FacadeFactory.getInstance().getUserClientService().update(client2);
		FacadeFactory.getInstance().getUserClientService().update(client3);
		FacadeFactory.getInstance().getUserClientService().update(client4);
		FacadeFactory.getInstance().getUserAdminService().update(admin1);
		
		log.info("insert link voiture to photo");
		FacadeFactory.getInstance().getVoitureService().update(voiture1);
		FacadeFactory.getInstance().getVoitureService().update(voiture2);
		FacadeFactory.getInstance().getVoitureService().update(voiture3);

		log.info("fin User");

		//
		// lIEUX
		//

		log.info("début Lieux");

		Pays pays = new Pays("Sénégal", 0.01f);
		Region region = new Region("Dakar");
		Departement departement = new Departement("Dakar");
		Arrondissement arr1 = new Arrondissement("Dakar Plateau");
		Arrondissement arr2 = new Arrondissement("Grand Dakar");

		Ville ville1 = new Ville("Dakar");
		Ville ville2 = new Ville("Darou");
		Ville ville3 = new Ville("Thiès");

		log.info("insertion des données");
		FacadeFactory.getInstance().getPaysService().insert(pays);
		FacadeFactory.getInstance().getRegionService().insert(region);
		FacadeFactory.getInstance().getDepartementService().insert(departement);
		FacadeFactory.getInstance().getArrondissementService().insert(arr1);
		FacadeFactory.getInstance().getArrondissementService().insert(arr2);
		FacadeFactory.getInstance().getVilleService().insert(ville1);
		FacadeFactory.getInstance().getVilleService().insert(ville2);
		FacadeFactory.getInstance().getVilleService().insert(ville3);

		log.info("link");
		FacadeFactory.getInstance().getPaysService().LinkPaysToRegion(pays, region);
		FacadeFactory.getInstance().getRegionService().LinkRegionToDepartement(region, departement);
		FacadeFactory.getInstance().getDepartementService().LinkDepartementToArrondissement(departement, arr1);
		FacadeFactory.getInstance().getDepartementService().LinkDepartementToArrondissement(departement, arr2);
		FacadeFactory.getInstance().getArrondissementService().LinkArrondissementToVille(arr1, ville1);
		FacadeFactory.getInstance().getArrondissementService().LinkArrondissementToVille(arr2, ville2);
		FacadeFactory.getInstance().getArrondissementService().LinkArrondissementToVille(arr2, ville3);

		log.info("insert link lieux");

		FacadeFactory.getInstance().getPaysService().update(pays);

		log.info("fin Lieux");
		
		log.info("debut trajet & resa");
		
		Trajet trajet1 = new Trajet(ville1, ville2, 10.1, new Date(), new Date(), 850.1, 2, true, false, "de dakar à darou");
		Trajet trajet2 = new Trajet(ville2, ville1, 10.1, new Date(), new Date(), 850.1, 2, true, false, "darou a dakar");
		Trajet trajet3 = new Trajet(ville3, ville1, 10.1, new Date(), new Date(), 850.1, 2, true, false, "de thies à dakar");
		
		Reservation resa1 = new Reservation(new Date(), 2, trajet1, client1);
		Reservation resa2 = new Reservation(new Date(), 1, trajet1, client2);
		Reservation resa3 = new Reservation(new Date(), 4, trajet2, client3);
		Reservation resa4 = new Reservation(new Date(), 2, trajet3, client2);
		Reservation resa5 = new Reservation(new Date(), 3, trajet3, client3);
		
		Paiement paiement1 = new Paiement("CB", true);
		Paiement paiement2 = new Paiement("Espèce", false);
		Paiement paiement3 = new Paiement("CB", true);
		Paiement paiement4 = new Paiement("CB", true);
		Paiement paiement5 = new Paiement("Virement", true);
		
		
		
		log.info("insert trajets");
		FacadeFactory.getInstance().getTrajetService().insert(trajet1);
		FacadeFactory.getInstance().getTrajetService().insert(trajet2);
		FacadeFactory.getInstance().getTrajetService().insert(trajet3);
		
		log.info("insert resa");
		FacadeFactory.getInstance().getReservationService().insert(resa1);
		FacadeFactory.getInstance().getReservationService().insert(resa2);
		FacadeFactory.getInstance().getReservationService().insert(resa3);
		FacadeFactory.getInstance().getReservationService().insert(resa4);
		FacadeFactory.getInstance().getReservationService().insert(resa5);
		
		log.info("link paiement to resa");
		FacadeFactory.getInstance().getReservationService().linkReservationToPaiement(resa1, paiement1);
		FacadeFactory.getInstance().getReservationService().linkReservationToPaiement(resa2, paiement2);
		FacadeFactory.getInstance().getReservationService().linkReservationToPaiement(resa3, paiement3);
		FacadeFactory.getInstance().getReservationService().linkReservationToPaiement(resa4, paiement4);
		FacadeFactory.getInstance().getReservationService().linkReservationToPaiement(resa5, paiement5);

		log.info("link trajet to chauffeur");
		FacadeFactory.getInstance().getTrajetService().linkTrajetToChauffeur(trajet1, client1);
		FacadeFactory.getInstance().getTrajetService().linkTrajetToChauffeur(trajet2, client1);
		FacadeFactory.getInstance().getTrajetService().linkTrajetToChauffeur(trajet3, client3);
		
		
		log.info("link resa to trajet");
		FacadeFactory.getInstance().getReservationService().linkReservationToTrajet(resa1, trajet1);
		FacadeFactory.getInstance().getReservationService().linkReservationToTrajet(resa2, trajet1);
		FacadeFactory.getInstance().getReservationService().linkReservationToTrajet(resa3, trajet2);
		FacadeFactory.getInstance().getReservationService().linkReservationToTrajet(resa4, trajet3);
		FacadeFactory.getInstance().getReservationService().linkReservationToTrajet(resa5, trajet3);
		
		log.info("link voiture to trajet");
		FacadeFactory.getInstance().getTrajetService().linkTrajetToVoiture(trajet1, voiture1);
		FacadeFactory.getInstance().getTrajetService().linkTrajetToVoiture(trajet2, voiture2);
		FacadeFactory.getInstance().getTrajetService().linkTrajetToVoiture(trajet3, voiture3);
		
		log.info("accepter reservation");
		FacadeFactory.getInstance().getReservationService().accepterReservation(resa1);
		
		log.info("insert link trajet & resa  & chauffeur");
		FacadeFactory.getInstance().getTrajetService().update(trajet1);
		FacadeFactory.getInstance().getTrajetService().update(trajet2);
		FacadeFactory.getInstance().getTrajetService().update(trajet3);
		
		
		log.info("fin trajet & resa");
		
		log.info("début avis");
		Avis avis1 = new Avis(4.1f, "super");
		Avis avis2 = new Avis(0.1f, "nul");
		Avis avis3 = new Avis(4.9f, "génial");
		Avis avis4 = new Avis(3.2f, "normal quoi");
		Avis avis5 = new Avis(2.51f, "change de musique");
		Avis avis6 = new Avis(4.4f, "super");
		
		log.info("insert avis");
		FacadeFactory.getInstance().getAvisService().insert(avis1);
		FacadeFactory.getInstance().getAvisService().insert(avis2);
		FacadeFactory.getInstance().getAvisService().insert(avis3);
		FacadeFactory.getInstance().getAvisService().insert(avis4);
		FacadeFactory.getInstance().getAvisService().insert(avis5);
		FacadeFactory.getInstance().getAvisService().insert(avis6);
		
		log.info("link avis to client");
		FacadeFactory.getInstance().getAvisService().linkAvisToClient(avis1, client1);
		FacadeFactory.getInstance().getAvisService().linkAvisToClient(avis2, client1);
		FacadeFactory.getInstance().getAvisService().linkAvisToClient(avis3, client2);
		FacadeFactory.getInstance().getAvisService().linkAvisToClient(avis4, client2);
		FacadeFactory.getInstance().getAvisService().linkAvisToClient(avis5, client3);
		FacadeFactory.getInstance().getAvisService().linkAvisToClient(avis6, client4);
		
		log.info("link avis to reservation");
		FacadeFactory.getInstance().getAvisService().linkAvisToReservation(avis1, resa1);
		FacadeFactory.getInstance().getAvisService().linkAvisToReservation(avis2, resa2);
		FacadeFactory.getInstance().getAvisService().linkAvisToReservation(avis3, resa3);
		FacadeFactory.getInstance().getAvisService().linkAvisToReservation(avis4, resa4);
		FacadeFactory.getInstance().getAvisService().linkAvisToReservation(avis5, resa5);
		FacadeFactory.getInstance().getAvisService().linkAvisToReservation(avis6, resa5);
		FacadeFactory.getInstance().getAvisService().linkAvisToReservation(avis1, resa1);
		
	}

}

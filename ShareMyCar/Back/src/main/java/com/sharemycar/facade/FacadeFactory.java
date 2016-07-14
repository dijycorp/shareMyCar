package com.sharemycar.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sharemycar.service.ArrondissementService;
import com.sharemycar.service.AvisService;
import com.sharemycar.service.DepartementService;
import com.sharemycar.service.EnvironnementService;
import com.sharemycar.service.PaiementService;
import com.sharemycar.service.PaysService;
import com.sharemycar.service.PhotosUtilisateurService;
import com.sharemycar.service.PhotosVoitureService;
import com.sharemycar.service.RegionService;
import com.sharemycar.service.ReservationService;
import com.sharemycar.service.RoleService;
import com.sharemycar.service.TrajetService;
import com.sharemycar.service.UserAdminService;
import com.sharemycar.service.UserClientService;
import com.sharemycar.service.UserService;
import com.sharemycar.service.VilleService;
import com.sharemycar.service.VoitureService;

public class FacadeFactory {

	private static FacadeFactory instance;

	private ApplicationContext springContext;

	private RoleService roleService;
	private UserService userService;
	private UserClientService userClientService;
	private UserAdminService userAdminService;

	private EnvironnementService environnementService;
	private PhotosUtilisateurService photosUtilisateurService;
	private VoitureService voitureService;
	private PhotosVoitureService photosVoitureService;

	private PaysService paysService;
	private RegionService regionService;
	private DepartementService departementService;
	private ArrondissementService arrondissementService;
	private VilleService villeService;

	private TrajetService trajetService;
	private ReservationService reservationService;
	private PaiementService paiementService;
	private AvisService avisService;

	// constructeur prive pour bloque les instanciations de la classe
	private FacadeFactory() {
		// recupère le bean Spring
		springContext = new ClassPathXmlApplicationContext("META-INF/dev-context.xml");

		// service users
		setUserService(springContext.getBean(UserService.class));
		setUserClientService(springContext.getBean(UserClientService.class));
		setUserAdminService(springContext.getBean(UserAdminService.class));

		// complement user
		setRoleService(springContext.getBean(RoleService.class));
		setEnvironnementService(springContext.getBean(EnvironnementService.class));
		setPhotosUtilisateurService(springContext.getBean(PhotosUtilisateurService.class));

		// voiture
		setVoitureService(springContext.getBean(VoitureService.class));
		setPhotosVoitureService(springContext.getBean(PhotosVoitureService.class));

		// Lieu
		setPaysService(springContext.getBean(PaysService.class));
		setRegionService(springContext.getBean(RegionService.class));
		setDepartementService(springContext.getBean(DepartementService.class));
		setArrondissementService(springContext.getBean(ArrondissementService.class));
		setVilleService(springContext.getBean(VilleService.class));

		// reservation
		setTrajetService(springContext.getBean(TrajetService.class));
		setReservationService(springContext.getBean(ReservationService.class));
		setPaiementService(springContext.getBean(PaiementService.class));
		
//		avis
		setAvisService(springContext.getBean(AvisService.class));
		
	}

	public static FacadeFactory getInstance() {

		if (instance == null) {
			instance = new FacadeFactory();
		}
		return instance;
	}

	public ApplicationContext getSpringContext() {
		return springContext;
	}

	public void setSpringContext(ApplicationContext springContext) {
		this.springContext = springContext;
	}

	public static void setInstance(FacadeFactory instance) {
		FacadeFactory.instance = instance;
	}

	public UserClientService getUserClientService() {
		return userClientService;
	}

	public void setUserClientService(UserClientService userClientService) {
		this.userClientService = userClientService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserAdminService getUserAdminService() {
		return userAdminService;
	}

	public void setUserAdminService(UserAdminService userAdminService) {
		this.userAdminService = userAdminService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public EnvironnementService getEnvironnementService() {
		return environnementService;
	}

	public void setEnvironnementService(EnvironnementService environnementService) {
		this.environnementService = environnementService;
	}

	public PhotosUtilisateurService getPhotosUtilisateurService() {
		return photosUtilisateurService;
	}

	public void setPhotosUtilisateurService(PhotosUtilisateurService photosUtilisateurService) {
		this.photosUtilisateurService = photosUtilisateurService;
	}

	public PaysService getPaysService() {
		return paysService;
	}

	public void setPaysService(PaysService paysService) {
		this.paysService = paysService;
	}

	public RegionService getRegionService() {
		return regionService;
	}

	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	public DepartementService getDepartementService() {
		return departementService;
	}

	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}

	public ArrondissementService getArrondissementService() {
		return arrondissementService;
	}

	public void setArrondissementService(ArrondissementService arrondissementService) {
		this.arrondissementService = arrondissementService;
	}

	public VilleService getVilleService() {
		return villeService;
	}

	public void setVilleService(VilleService villeService) {
		this.villeService = villeService;
	}

	public VoitureService getVoitureService() {
		return voitureService;
	}

	public void setVoitureService(VoitureService voitureService) {
		this.voitureService = voitureService;
	}

	public PhotosVoitureService getPhotosVoitureService() {
		return photosVoitureService;
	}

	public void setPhotosVoitureService(PhotosVoitureService photosVoitureService) {
		this.photosVoitureService = photosVoitureService;
	}

	public TrajetService getTrajetService() {
		return trajetService;
	}

	public void setTrajetService(TrajetService trajetService) {
		this.trajetService = trajetService;
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	public PaiementService getPaiementService() {
		return paiementService;
	}

	public void setPaiementService(PaiementService paiementService) {
		this.paiementService = paiementService;
	}

	public AvisService getAvisService() {
		return avisService;
	}

	public void setAvisService(AvisService avisService) {
		this.avisService = avisService;
	}

}

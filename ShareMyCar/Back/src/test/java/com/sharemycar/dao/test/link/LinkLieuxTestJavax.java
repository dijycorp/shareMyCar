package com.sharemycar.dao.test.link;

import org.apache.log4j.Logger;

import com.sharemycar.entities.Arrondissement;
import com.sharemycar.entities.Departement;
import com.sharemycar.entities.Pays;
import com.sharemycar.entities.Region;
import com.sharemycar.entities.Ville;
import com.sharemycar.facade.FacadeFactory;

public class LinkLieuxTestJavax {

	private static final Logger log = Logger.getLogger(LinkLieuxTestJavax.class);

	public static void main(String[] args) {
		log.info("début");
		
		Pays pays = new Pays("Sénégal", 0.01f);
		Region region = new Region("Dakar");
		Departement departement = new Departement("Dakar");
		Arrondissement arr1 = new Arrondissement("Dakar Plateau");
		Arrondissement arr2 = new Arrondissement("Grand Dakar");
		
		Ville ville1 = new Ville("Dakar-arrPla");
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
		
		
		log.info("sauvegarde");
		
		FacadeFactory.getInstance().getPaysService().update(pays);

		log.info("fin");
		
		
	}
	
	
	

	
}

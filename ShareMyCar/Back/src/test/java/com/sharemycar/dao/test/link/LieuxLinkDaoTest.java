package com.sharemycar.dao.test.link;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sharemycar.dao.ArrondissementDao;
import com.sharemycar.dao.DepartementDao;
import com.sharemycar.dao.PaysDao;
import com.sharemycar.dao.RegionDao;
import com.sharemycar.dao.VilleDao;
import com.sharemycar.entity.Arrondissement;
import com.sharemycar.entity.Departement;
import com.sharemycar.entity.Pays;
import com.sharemycar.entity.Region;
import com.sharemycar.entity.Ville;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/dev-context.xml")
public class LieuxLinkDaoTest {

	@Autowired
	PaysDao paysDao;
	@Autowired
	RegionDao regionDao;
	@Autowired
	DepartementDao departementDao;
	@Autowired
	ArrondissementDao arrondissementDao;
	@Autowired
	VilleDao villeDao;
	
	@Before
	public void insertData(){
		System.out.println("début test");
	}
	
	@After
	public void deleteData(){
		System.out.println("fin test");
	}
	
	@Test
	public void linkPaysToRegion(){
		
		Pays pays1 = new Pays("Mexique", 0.1f);
		Region region1 = new Region("Sonora");
		Pays pays2 = new Pays("France", 10.1f);
		Region region2 = new Region("Ile-De-France");
		
		pays1.addRegion(region1);
		paysDao.LinkPaysToRegion(pays1, region1);
		pays2.addRegion(region2);
		paysDao.LinkPaysToRegion(pays2, region2);
		
		Assert.assertTrue(pays1.getRegions().contains(region1));
		Assert.assertTrue(pays2.getRegions().contains(region2));
	}
	
	@Test
	public void linkRegionToDepartement(){
		Pays pays1 = new Pays("Mexique1", 0.1f);
		paysDao.insert(pays1);
		pays1 = paysDao.findById(pays1.getId());
		Region region1 = new Region("Sonora1");
		regionDao.insert(region1);
		Departement departement1 = new Departement("Capitale1");
		departementDao.insert(departement1);
		
		Pays pays2 = new Pays("France1", 10.1f);
		paysDao.insert(pays2);
		Region region2 = new Region("Ile-De-France1");
		regionDao.insert(region2);
		Departement departement2 = new Departement("Haut-De-Seine1");
		departementDao.insert(departement2);
		
		pays1.addRegion(region1);
		paysDao.LinkPaysToRegion(pays1, region1);
		region1.addDepartement(departement1);
		regionDao.LinkRegionToDepartement(region1, departement1);
		
		pays2.addRegion(region2);
		paysDao.LinkPaysToRegion(pays2, region2);
		region2.addDepartement(departement2);
		regionDao.LinkRegionToDepartement(region2, departement2);
		
		Assert.assertTrue(pays1.getRegions().contains(region1));
		Assert.assertTrue(pays2.getRegions().contains(region2));
		Assert.assertTrue(region1.getDepartements().contains(departement1));
		Assert.assertTrue(region2.getDepartements().contains(departement2));
		
	}
	
	@Test
	public void linkDepartementToArrondissement(){
		Pays pays1 = new Pays("Mexique3", 0.1f);
		paysDao.insert(pays1);
		pays1 = paysDao.findById(pays1.getId());
		Region region1 = new Region("Sonora3");
		regionDao.insert(region1);
		Departement departement1 = new Departement("Capitale3");
		departementDao.insert(departement1);
		Arrondissement arrondissement1 = new Arrondissement("15ème3");
		arrondissementDao.insert(arrondissement1);
		
		Pays pays2 = new Pays("France3", 10.1f);
		paysDao.insert(pays2);
		Region region2 = new Region("Ile-De-France3");
		regionDao.insert(region2);
		Departement departement2 = new Departement("Haut-De-Seine3");
		departementDao.insert(departement2);
		Arrondissement arrondissement2 = new Arrondissement("16ème3");
		arrondissementDao.insert(arrondissement2);
		
		pays1.addRegion(region1);
		paysDao.LinkPaysToRegion(pays1, region1);
		region1.addDepartement(departement1);
		regionDao.LinkRegionToDepartement(region1, departement1);
		departement1.addArrondissement(arrondissement1);
		departementDao.LinkDepartementToArrondissement(departement1, arrondissement1);
		
		pays2.addRegion(region2);
		paysDao.LinkPaysToRegion(pays2, region2);
		region2.addDepartement(departement2);
		regionDao.LinkRegionToDepartement(region2, departement2);
		departement2.addArrondissement(arrondissement2);
		departementDao.LinkDepartementToArrondissement(departement2, arrondissement2);
		
		Assert.assertTrue(pays1.getRegions().contains(region1));
		Assert.assertTrue(pays2.getRegions().contains(region2));
		Assert.assertTrue(region1.getDepartements().contains(departement1));
		Assert.assertTrue(region2.getDepartements().contains(departement2));
		Assert.assertTrue(departement1.getArrondissements().contains(arrondissement1));
		Assert.assertTrue(departement2.getArrondissements().contains(arrondissement2));
		
		
	}
	
	@Test
	public void linkArrondissementToVille(){
		Pays pays1 = new Pays("Mexique4", 0.1f);
		paysDao.insert(pays1);
		pays1 = paysDao.findById(pays1.getId());
		Region region1 = new Region("Sonora4");
		regionDao.insert(region1);
		Departement departement1 = new Departement("Capitale4");
		departementDao.insert(departement1);
		Arrondissement arrondissement1 = new Arrondissement("15ème4");
		arrondissementDao.insert(arrondissement1);
		Ville ville1 = new Ville("Hermossillo");
		villeDao.insert(ville1);
		
		
		Pays pays2 = new Pays("France4", 10.1f);
		paysDao.insert(pays2);
		Region region2 = new Region("Ile-De-France4");
		regionDao.insert(region2);
		Departement departement2 = new Departement("Haut-De-Seine4");
		departementDao.insert(departement2);
		Arrondissement arrondissement2 = new Arrondissement("16ème4");
		arrondissementDao.insert(arrondissement2);
		Ville ville2 = new Ville("Paris");
		villeDao.insert(ville2);
		
		pays1.addRegion(region1);
		paysDao.LinkPaysToRegion(pays1, region1);
		region1.addDepartement(departement1);
		regionDao.LinkRegionToDepartement(region1, departement1);
		departement1.addArrondissement(arrondissement1);
		departementDao.LinkDepartementToArrondissement(departement1, arrondissement1);
		arrondissement1.addVille(ville1);
		arrondissementDao.LinkArrondissementToVille(arrondissement1, ville1);
		
		pays2.addRegion(region2);
		paysDao.LinkPaysToRegion(pays2, region2);
		region2.addDepartement(departement2);
		regionDao.LinkRegionToDepartement(region2, departement2);
		departement2.addArrondissement(arrondissement2);
		departementDao.LinkDepartementToArrondissement(departement2, arrondissement2);
		arrondissement2.addVille(ville2);
		arrondissementDao.LinkArrondissementToVille(arrondissement2, ville2);
		
		Assert.assertTrue(pays1.getRegions().contains(region1));
		Assert.assertTrue(pays2.getRegions().contains(region2));
		Assert.assertTrue(region1.getDepartements().contains(departement1));
		Assert.assertTrue(region2.getDepartements().contains(departement2));
		Assert.assertTrue(departement1.getArrondissements().contains(arrondissement1));
		Assert.assertTrue(departement2.getArrondissements().contains(arrondissement2));
		Assert.assertTrue(arrondissement1.getVilles().contains(ville1));
		Assert.assertTrue(arrondissement2.getVilles().contains(ville2));
		
	}
		
}

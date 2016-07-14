package com.sharemycar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemycar.dao.PaysDao;
import com.sharemycar.entity.Pays;
import com.sharemycar.entity.Region;
import com.sharemycar.service.PaysService;

@Service
@Transactional
public class PaysServiceSpring implements PaysService {

	@Autowired
	private PaysDao paysDao;
	
	@Override
	public Pays insert(Pays pays) {
		// TODO Auto-generated method stub
		return paysDao.insert(pays);
	}

	@Override
	public void delete(Pays pays) {
		// TODO Auto-generated method stub
		paysDao.delete(pays);
	}

	@Override
	public Pays update(Pays pays) {
		// TODO Auto-generated method stub
		return paysDao.update(pays);
	}

	@Override
	public Pays findById(Integer id) {
		// TODO Auto-generated method stub
		return paysDao.findById(id);
	}

	@Override
	public List<Pays> findAll() {
		// TODO Auto-generated method stub
		return paysDao.findAll();
	}

	@Override
	public Pays LinkPaysToRegion(Pays pays, Region region) {

		return paysDao.LinkPaysToRegion(pays, region);
	}



	

}

package com.topera.epoch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topera.epoch.dao.ToperaSearchDAO;
import com.topera.epoch.model.ToperaSearchEntity;

@Service
public class ToperaServiceImpl implements ToperaService {

	@Autowired
	ToperaSearchDAO dao;
	
	
	public Object[] searchMetadata(ToperaSearchEntity searchData) {
		// TODO Auto-generated method stub
		return dao.searchMetadata(searchData);
	}
}

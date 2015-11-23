package com.topera.epoch.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topera.epoch.model.ToperaSearchEntity;

@Repository
@Transactional
public class ToperaSearchDAOImpl implements ToperaSearchDAO 
{
	
	@PersistenceContext
	private EntityManager manager;

	public List<ToperaSearchEntity> searchMetadata1(ToperaSearchEntity searchData) {
		// TODO Auto-generated method stub
		List<ToperaSearchEntity> toperaSerch = manager.createQuery("Select a From ToperaSearchEntity a", ToperaSearchEntity.class).getResultList();
        return toperaSerch;
	}
	
	public Object[] searchMetadata(ToperaSearchEntity searchData) {
		// TODO Auto-generated method stub
		List<String[]> returnData = new ArrayList<String[]>();
		List<ToperaSearchEntity> toperaSerch = manager.createQuery("Select a From ToperaSearchEntity a", ToperaSearchEntity.class).getResultList();
        for (ToperaSearchEntity toperaSearchEntity : toperaSerch) {
			returnData.add(toperaSearchEntity.toArray());
		}
		
		
		return returnData.toArray();
	}
	
	
	
}
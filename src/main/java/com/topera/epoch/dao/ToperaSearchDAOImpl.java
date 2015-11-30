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

	public Object[] searchMetadata(ToperaSearchEntity searchData) {
		// TODO Auto-generated method stub
		String sql = "Select a From ToperaSearchEntity a where 1<>1 "
				+ getSearchString(searchData);
		List<String[]> returnData = new ArrayList<String[]>();
		List<ToperaSearchEntity> toperaSerch = manager.createQuery(sql, ToperaSearchEntity.class).getResultList();
        
		
		System.out.println("ToperaSearchDAOImpl.searchMetadata1()"+sql);
		for (ToperaSearchEntity toperaSearchEntity : toperaSerch) {
			returnData.add(toperaSearchEntity.toArray());
		}
		
		
		return returnData.toArray();
	}
	private String getSearchString(ToperaSearchEntity searchData){
		StringBuffer searchQuery = new StringBuffer();
		if(searchData.getHospital()!=null && searchData.getHospital().trim().length() > 0){
			searchQuery.append(" or hospital like '%"+searchData.getHospital() +"%'");
		}
		
		if(searchData.getWorkstation()!=null && searchData.getWorkstation().trim().length() > 0){
			searchQuery.append(" or workstation like '%"+searchData.getWorkstation() +"%'");
		}
		
		if(searchData.getProcedure_ID()!=null && searchData.getProcedure_ID().trim().length() > 0){
			searchQuery.append(" or workstation like '%"+searchData.getProcedure_ID() +"%'");
		}
		if(searchData.getDatetime()!=null){
			searchQuery.append(" or datetime ='"+searchData.getDatetime() +"'");
		}
		
		return searchQuery.toString();
		
	}
	
	
	
}
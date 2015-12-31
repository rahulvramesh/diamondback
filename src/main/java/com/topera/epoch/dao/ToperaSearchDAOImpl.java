package com.topera.epoch.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topera.epoch.model.KeyToName;
import com.topera.epoch.model.ScheduleEntity;
import com.topera.epoch.model.ToperaSearchEntity;
import com.topera.epoch.model.ZipCronStatus;

@Repository
@Transactional
public class ToperaSearchDAOImpl
  implements ToperaSearchDAO
{
  @PersistenceContext
  private EntityManager manager;
  
  public Object[] searchMetadata(ToperaSearchEntity searchData)
  {
    String sql = "Select a From ToperaSearchEntity a where 1=1 " + getSearchString(searchData);
    List<String[]> returnData = new ArrayList<String[]>();
    List<ToperaSearchEntity> toperaSerch = this.manager.createQuery(sql, ToperaSearchEntity.class).getResultList();
    
    System.out.println("ToperaSearchDAOImpl.searchMetadata1()" + sql);
    for (ToperaSearchEntity toperaSearchEntity : toperaSerch) {
      returnData.add(toperaSearchEntity.toArray());
    }
    return returnData.toArray();
  }
  
  public Object[] listSchedule()
  {
    String sql = "Select a From ScheduleEntity a ";
    
    List<String[]> returnData = new ArrayList<String[]>();
    List<ScheduleEntity> toperaSerch = this.manager.createQuery(sql, ScheduleEntity.class).getResultList();
    
    System.out.println("ToperaSearchDAOImpl.searchMetadata1()" + sql);
    for (ScheduleEntity scheduleEntity : toperaSerch) {
      returnData.add(scheduleEntity.toArray());
    }
    return returnData.toArray();
  }
  
  public Object[] listCronState()
  {
    String sql = "Select a From KeyToName a";
    
    List<String[]> returnData = new ArrayList<String[]>();
    List<KeyToName> toperaSerch = this.manager.createQuery(sql, KeyToName.class).getResultList();
    
    System.out.println("ToperaSearchDAOImpl.searchMetadata1()" + sql);
    for (KeyToName scheduleEntity : toperaSerch) {
      returnData.add(scheduleEntity.toArray());
    }
    return returnData.toArray();
  }
  
  public void saveSchedule(ScheduleEntity schedule)
  {
    this.manager.persist(schedule);
  }
  
  public void saveZipCorn(ZipCronStatus schedule)
  {
    this.manager.persist(schedule);
  }
  
  public void saveKeyToFile(KeyToName keyToName)
  {
    this.manager.persist(keyToName);
  }
  
  private String getSearchString(ToperaSearchEntity searchData)
  {
    StringBuffer searchQuery = new StringBuffer();
    if ((searchData.getHospital() != null) && (searchData.getHospital().trim().length() > 0)) {
      searchQuery.append(" and hospital like '%" + searchData.getHospital() + "%'");
    }
    if ((searchData.getWorkstation() != null) && (searchData.getWorkstation().trim().length() > 0)) {
      searchQuery.append(" and workstation like '%" + searchData.getWorkstation() + "%'");
    }
    if ((searchData.getProcedure_ID() != null) && (searchData.getProcedure_ID().trim().length() > 0)) {
      searchQuery.append(" and Procedure_ID like '%" + searchData.getProcedure_ID() + "%'");
    }
    if ((searchData.getFromDate() != null) && (searchData.getToDate() != null)) {
      searchQuery.append(" and datetime between '" + searchData.getFromDate() + "' and '" + searchData.getToDate() + "'");
    }
    if ((searchData.getFromDate() != null) && (searchData.getToDate() == null)) {
      searchQuery.append(" and date_format(datetime, '%m-%d-%Y') >= '" + searchData.getFromDate() + "'");
    }
    if ((searchData.getFromDate() == null) && (searchData.getToDate() != null)) {
      searchQuery.append(" and date_format(datetime, '%m-%d-%Y') <= '" + searchData.getToDate() + "'");
    }
    return searchQuery.toString();
  }
}

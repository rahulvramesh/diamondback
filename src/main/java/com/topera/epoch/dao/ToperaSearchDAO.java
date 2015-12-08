package com.topera.epoch.dao;

import com.topera.epoch.model.ScheduleEntity;
import com.topera.epoch.model.ToperaSearchEntity;

public interface ToperaSearchDAO 
{
	public Object[] searchMetadata(ToperaSearchEntity searchData);
	
	public void saveSchedule(ScheduleEntity schedule);
	
	public Object[] listSchedule();
	
}
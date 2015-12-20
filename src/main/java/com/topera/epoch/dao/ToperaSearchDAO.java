package com.topera.epoch.dao;

import com.topera.epoch.model.KeyToName;
import com.topera.epoch.model.ScheduleEntity;
import com.topera.epoch.model.ToperaSearchEntity;
import com.topera.epoch.model.ZipCronStatus;

public interface ToperaSearchDAO 
{
	public Object[] searchMetadata(ToperaSearchEntity searchData);
	
	public void saveSchedule(ScheduleEntity schedule);
	
	public Object[] listSchedule();
	
	public void saveZipCorn(ZipCronStatus schedule);
	
	public Object[] listCronState();
	
	public void saveKeyToFile(KeyToName keyToName);
	
}
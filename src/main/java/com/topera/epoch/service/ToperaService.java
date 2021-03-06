package com.topera.epoch.service;

import com.topera.epoch.model.ToperaSearchEntity;
import com.topera.epoch.vo.ScheduleInput;
import com.topera.epoch.vo.SearchInput;

public interface ToperaService 
{
	public Object[] searchMetadata(ToperaSearchEntity searchData);
	
	public ToperaSearchEntity getToperaSearchEntity(SearchInput data);
	
	public void saveSchedule(ScheduleInput schedule);
	
	public void saveZipCron(ScheduleInput schedule);
	
	public Object[] listSchedule();
	
	public Object[] listCronState();
	
	public void saveKeyToFile(String key,String name);
	
}

package com.topera.epoch.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topera.epoch.dao.ToperaSearchDAO;
import com.topera.epoch.model.KeyToName;
import com.topera.epoch.model.ScheduleEntity;
import com.topera.epoch.model.ToperaSearchEntity;
import com.topera.epoch.model.ZipCronStatus;
import com.topera.epoch.vo.ScheduleInput;
import com.topera.epoch.vo.SearchInput;

@Service
public class ToperaServiceImpl implements ToperaService {

	@Autowired
	ToperaSearchDAO dao;

	public Object[] searchMetadata(ToperaSearchEntity searchData) {
		// TODO Auto-generated method stub
		return dao.searchMetadata(searchData);
	}

	public ToperaSearchEntity getToperaSearchEntity(SearchInput data) {
		ToperaSearchEntity searchEntity = new ToperaSearchEntity();
		searchEntity.setHospital(data.getHospital());
		searchEntity.setWorkstation(data.getWorkstation());
		searchEntity.setProcedure_ID(data.getProcedureId());
		if (data.getDateTime() != null && data.getDateTime().isEmpty()) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date date;
			try {
				date = sdf1.parse(data.getDateTime());
				java.sql.Date sqlStartDate = new Date(date.getTime());
				searchEntity.setDatetime(sqlStartDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return searchEntity;

	}

	public void saveSchedule(ScheduleInput schedule) {
		// TODO Auto-generated method stub
		String fileName = schedule.getFileName();
		System.out.println("ToperaServiceImpl.saveSchedule():filename=" + fileName);

		String[] files = fileName.split(",");
		ScheduleEntity scheduleEntity = null;
		for (String file : files) {
			scheduleEntity = new ScheduleEntity();
			scheduleEntity.setFileName(file);
			scheduleEntity.setScriptName(schedule.getScriptName());
			scheduleEntity.setStatus("SCHEDULED");
            try{
			dao.saveSchedule(scheduleEntity);
            } catch(Exception ee){
				ee.printStackTrace();
			}
			
		}

	}

	public void saveKeyToFile(String key, String name) {
		// TODO Auto-generated method stub
		KeyToName keytoname = new KeyToName();
		keytoname.setKeyName(key);
		keytoname.setName(name);

		dao.saveKeyToFile(keytoname);
	}

	public Object[] listSchedule() {
		// TODO Auto-generated method stub
		return dao.listSchedule();
	}

	public Object[] listCronState() {
		// TODO Auto-generated method stub
		return dao.listCronState();
	}

	public void saveZipCron(ScheduleInput schedule) {
		// TODO Auto-generated method stub
		ZipCronStatus zipCronStatus = new ZipCronStatus();
		zipCronStatus.setName(schedule.getFileName());
		zipCronStatus.setStatus("NOT STARTED");
		dao.saveZipCorn(zipCronStatus);

	}
}

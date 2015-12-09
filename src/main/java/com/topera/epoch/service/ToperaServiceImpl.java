package com.topera.epoch.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topera.epoch.dao.ToperaSearchDAO;
import com.topera.epoch.model.ScheduleEntity;
import com.topera.epoch.model.ToperaSearchEntity;
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
		ScheduleEntity scheduleEntity = new ScheduleEntity();
		scheduleEntity.setFileName(schedule.getFileName());
		scheduleEntity.setScriptName(schedule.getScriptName());
		scheduleEntity.setStatus("SCHEDULED");
		
		dao.saveSchedule(scheduleEntity);
	}

	public Object[] listSchedule() {
		// TODO Auto-generated method stub
		return dao.listSchedule();
	}
}

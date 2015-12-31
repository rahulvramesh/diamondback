package com.topera.epoch.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topera.epoch.model.ToperaSearchEntity;
import com.topera.epoch.service.AWSClient;
import com.topera.epoch.service.ToperaService;
import com.topera.epoch.vo.ScheduleInput;
import com.topera.epoch.vo.SearchInput;
import com.topera.epoch.vo.SearchResultVo;

@RestController
public class ToperaSearchController {
	@Autowired
	ToperaService manager;

	@RequestMapping("/search")
	public SearchResultVo processSearch(@RequestBody SearchInput data) {
		System.out.println("ToperaSearchController.readBookmark()" + data);
		System.out.println("ToperaSearchController.processSearch()" + data.toString());
		ToperaSearchEntity searchEntity = new ToperaSearchEntity();
		searchEntity.setHospital(data.getHospital());
		searchEntity.setWorkstation(data.getWorkstation());
		searchEntity.setProcedure_ID(data.getProcedureId());
		if (!data.getFromDate().isEmpty()) {
				searchEntity.setFromDate(data.getFromDate());
			
		}
		
		if (!data.getToDate().isEmpty()) {
				searchEntity.setToDate(data.getToDate());
			
		}

		return new SearchResultVo(this.manager.searchMetadata(searchEntity));
	}
	
	@RequestMapping("/download/{fileName}")
	public void download(@PathVariable String fileName,HttpServletResponse response){
		
		
		try {
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + fileName +".txt\""));
			response.setHeader("Content-Transfer-Encoding", "binary");
			System.out.println("ToperaSearchController.download()filename="+fileName+"!");
			FileCopyUtils.copy(AWSClient.getAwsData(fileName.trim()), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@RequestMapping("/download/{fileName}/bucket/{bucketName}")
	public void download(@PathVariable String fileName,@PathVariable String bucketName,HttpServletResponse response){
		
		
		try {
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + fileName +".txt\""));
			response.setHeader("Content-Transfer-Encoding", "binary");
			System.out.println("ToperaSearchController.download()filename="+fileName+"!");
			FileCopyUtils.copy(AWSClient.getAwsData(fileName.trim(),bucketName), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/download/python/{fileName}/bucket/{bucketName}")
	public void downloadPython(@PathVariable String fileName,@PathVariable String bucketName,HttpServletResponse response){
		
		
		try {
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + fileName +".py\""));
			response.setHeader("Content-Transfer-Encoding", "binary");
			System.out.println("ToperaSearchController.download()filename="+fileName+"!");
			FileCopyUtils.copy(AWSClient.getAwsData(fileName.trim(),bucketName), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/list/script")
	public SearchResultVo listScript(){
		
		
		return new SearchResultVo(AWSClient.getScriptFiles());
		
		
		
	}
	
	@RequestMapping("/list/cron")
	public SearchResultVo listCron(){
		
		
		return new SearchResultVo(manager.listCronState());
		
		
		
	}
	
	@RequestMapping("/save/schedule")
	public void scheduleScript(@RequestBody ScheduleInput data){
		
		manager.saveSchedule(data);
		
		
		
		
	}
	
	@RequestMapping("/save/keytofile/key/{key}/name/{name}")
	public void scheduleScript(@PathVariable String key,@PathVariable String name){
		
		manager.saveKeyToFile(key, name);
		
		
		
		
	}
	
	@RequestMapping("/show/schedule")
	public SearchResultVo showSchedule(){
		
		SearchResultVo vo = new SearchResultVo(manager.listSchedule());
		return vo;
		
		
		
		
		
	}
	
	

}
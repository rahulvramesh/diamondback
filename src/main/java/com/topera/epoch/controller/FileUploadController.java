package com.topera.epoch.controller;

import java.io.File;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.topera.epoch.service.AWSClient;
import com.topera.epoch.service.ToperaService;
import com.topera.epoch.vo.ScheduleInput;

@Controller
public class FileUploadController {
	
	@Autowired
	ToperaService manager;


    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public void handleFileUpload(MultipartHttpServletRequest request){
    	
    	Iterator<String> itr =  request.getFileNames();
    	 
        MultipartFile file = request.getFile(itr.next());
        
        if (!file.isEmpty()) {
            try {
            	File convFile = new File( "/tmp/"+file.getOriginalFilename());
                file.transferTo(convFile);
            	AWSClient.putAwsData(convFile,"analysis-rnd-scripts");
                //return new SearchResultVo(AWSClient.getScriptFiles());
                
                
            } catch (Exception e) {
            	e.printStackTrace();
            }
        } else {
        }
        //return new SearchResultVo(new String[]{""});
    }
    
    
    @RequestMapping(value="/zipupload", method=RequestMethod.POST)
    public void handleZipFileUpload(MultipartHttpServletRequest request){
    	
    	Iterator<String> itr =  request.getFileNames();
    	 
        MultipartFile file = request.getFile(itr.next());
        
        if (!file.isEmpty()) {
            try {
            	File convFile = new File( "/tmp/"+file.getOriginalFilename());
                file.transferTo(convFile);
            	AWSClient.putAwsData(convFile,"diamondback-epocs-zip");
                //return new SearchResultVo(AWSClient.getScriptFiles());
            	ScheduleInput schedule = new ScheduleInput();
            	schedule.setFileName(file.getOriginalFilename());
            	manager.saveZipCron(schedule);
                
                convFile.delete();
            } catch (Exception e) {
            	e.printStackTrace();
            }
        } else {
        }
        //return new SearchResultVo(new String[]{""});
    }

}
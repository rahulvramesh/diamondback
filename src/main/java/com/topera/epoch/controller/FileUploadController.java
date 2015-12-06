package com.topera.epoch.controller;

import java.io.File;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.topera.epoch.service.AWSClient;
import com.topera.epoch.vo.SearchResultVo;

@Controller
public class FileUploadController {
	


    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public SearchResultVo handleFileUpload(MultipartHttpServletRequest request){
    	
    	Iterator<String> itr =  request.getFileNames();
    	 
        MultipartFile file = request.getFile(itr.next());
        
        if (!file.isEmpty()) {
            try {
            	File convFile = new File( file.getOriginalFilename());
                file.transferTo(convFile);
            	AWSClient.putAwsData(convFile);
                return new SearchResultVo(AWSClient.getScriptFiles());
                
                
            } catch (Exception e) {
            	e.printStackTrace();
            }
        } else {
        }
        return new SearchResultVo(new String[]{""});
    }

}
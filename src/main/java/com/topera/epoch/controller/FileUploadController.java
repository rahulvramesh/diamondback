package com.topera.epoch.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.topera.epoch.service.AsynchFileProcess;

@Controller
public class FileUploadController {
	


    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(MultipartHttpServletRequest request){
    	
    	Iterator<String> itr =  request.getFileNames();
    	 
        MultipartFile file = request.getFile(itr.next());
    	String filename = "/tmp/topera/"+file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(filename)));
                stream.write(bytes);
                stream.close();
                //AsynchFileProcess.processFile(new File(filename));
                return "{\"response\":\"You successfully uploaded " + filename + "!\"}";
                
                
            } catch (Exception e) {
                return "{\"response\":\"You failed to upload " + filename + " => " + e.getMessage()+"\"}";
            }
        } else {
            return "You failed to upload " + filename + " because the file was empty.";
        }
    }

}
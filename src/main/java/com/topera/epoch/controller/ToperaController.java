package com.topera.epoch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.topera.epoch.service.ToperaService;

@RestController
public class ToperaController
{
	@Autowired
	ToperaService manager;


	
	@RequestMapping("/index")
	public ModelAndView readBookmark() {
//		System.out.println("ToperaController.readBookmark()"+searchData.toString());
		return new ModelAndView("index");
	}

}
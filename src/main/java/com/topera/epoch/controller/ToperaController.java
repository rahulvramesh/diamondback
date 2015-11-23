package com.topera.epoch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topera.epoch.service.ToperaService;
import com.topera.epoch.vo.SearchResultVo;

@RestController
public class ToperaController
{
	@Autowired
	ToperaService manager;


	
	@RequestMapping("/search")
	public SearchResultVo readBookmark() {
//		System.out.println("ToperaController.readBookmark()"+searchData.toString());
		return new SearchResultVo(this.manager.searchMetadata(null));
	}

}
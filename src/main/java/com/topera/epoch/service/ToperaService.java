package com.topera.epoch.service;

import com.topera.epoch.model.ToperaSearchEntity;
import com.topera.epoch.vo.SearchInput;

public interface ToperaService 
{
	public Object[] searchMetadata(ToperaSearchEntity searchData);
	
	public ToperaSearchEntity getToperaSearchEntity(SearchInput data);
	
}

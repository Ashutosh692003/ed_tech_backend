package com.ashutosh.service;

import java.util.List;

import com.ashutosh.bindinig.courseBinding;
import com.ashutosh.entity.courses;
import com.ashutosh.entity.trending;

public interface trendingFilterService {
	
	
	public List<courseBinding> getTrending();
	
     public String addTrending(Integer id);
     
	 public boolean removeTrending(Integer id);
	 
   public List<courses>  categoryFilter(Integer id );
   
   public List<courses> courseTypeFilter(String type);
   
   public List<courses> searchByName(String name);
}

package com.ashutosh.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.bindinig.courseBinding;
import com.ashutosh.entity.courses;
import com.ashutosh.entity.trending;
import com.ashutosh.service.trendingFilterService;

@RestController
@RequestMapping("/courseApi2")
public class Trending_And_Filter_Controller {
	
	 @Autowired
	 trendingFilterService service;
	
	 @GetMapping("/getTrending")
	public List<courseBinding> getTrending(){
		
		    List<courseBinding>    data =    service.getTrending();
		 return data;
	}
	
	@GetMapping("/addTrending")
	public String  addTrending(@RequestParam("id")Integer id) {
		      String msg = service.addTrending(id);
		      System.out.println(id);
		      return msg;
	}

	 @GetMapping("/removeTrending")
	 public boolean removeTrending(@RequestParam("id") Integer id) {
		   boolean b =    service.removeTrending(id);
		   return b;
	 }
	 
	 @GetMapping("/categoryFilter")
	 public List<courses> categoryFilter(@RequestParam("id") Integer id){
		  List<courses> data = service.categoryFilter(id);
		    return data;
	 }
	 
	 @GetMapping("/typeFilter")
	 public List<courses> courseTypeFilter(String type){
		       List<courses>  data =     service.courseTypeFilter(type);
		       return data;
	 }
	 
	 @GetMapping("/searchByName")
	 public List<courses> searchByName(String name){
		  List<courses> data = service.searchByName(name);
		  return data;
	 }
}

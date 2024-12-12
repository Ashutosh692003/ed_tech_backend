package com.ashutosh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashutosh.AppConstants.AppConstants;
import com.ashutosh.bindinig.courseBinding;
import com.ashutosh.entity.Course_Category;
import com.ashutosh.entity.courses;
import com.ashutosh.entity.trending;
import com.ashutosh.repo.categoryRepo;
import com.ashutosh.repo.courseRepo;
import com.ashutosh.repo.trendingRepo;
@Service
public class trendingFilterImpl  implements trendingFilterService{
	
	@Autowired
	trendingRepo tRepo;
	
	@Autowired
	courseRepo cRepo;
	
	@Autowired
	categoryRepo catRepo;

	@Override
	public List<courseBinding> getTrending() {
		  
		List<trending> trendingList  = tRepo.findAll();
		List<courseBinding> data = new ArrayList<>();
		   for(trending trend : trendingList) {
			   courses c = trend.getCourse();
			   courseBinding course = new courseBinding();
			   BeanUtils.copyProperties(c, course);
			   data.add(course);
		   }
		return  data;
	}

	@Override
	public String addTrending(Integer courseId) {
		         Long count = tRepo.count();
		          if(count>3) {
		        	  return AppConstants.limit_exceeded; 
		          }
		          else {
		        	      courses course = cRepo.findById(courseId).get();
		        	      trending trend = new trending();
		        	      trend.setCourse(course);
		        	      tRepo.save(trend);
		        	      return AppConstants.added_successfully;
		          }
	    
	}

	@Override
	public boolean removeTrending(Integer trendId) {
		   tRepo.deleteById(trendId);
		            
		return true;
	}

	@Override
	public List<courses> categoryFilter(Integer id) {
		        Course_Category category = catRepo.findById(id) .get();
		         List<courses> courses = category.getAllCourses();
		         List<courses> finalList = new ArrayList<>();
		           for(courses c : courses) {
		        	    if(c.getActiveSt()=="Y") {
		        	    	 finalList.add(c);
		        	    }
		           }
		return  finalList;
	}

	@Override
	public List<courses> courseTypeFilter(String type) {
		          List<courses> courses  =       cRepo.findByCourseType(type);
		           
		return courses;
	}

	@Override
	public List<courses> searchByName(String name) {
		 List<courses>   courses =      cRepo.findByCourseName(name);
		return courses;
	}

}

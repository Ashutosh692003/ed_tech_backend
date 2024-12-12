package com.ashutosh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashutosh.AppConstants.AppConstants;
import com.ashutosh.bindinig.courseBinding;
import com.ashutosh.entity.Course_Category;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.courses;
import com.ashutosh.entity.student;
import com.ashutosh.repo.categoryRepo;
import com.ashutosh.repo.courseRepo;
import com.ashutosh.repo.instructorRepo;
import com.ashutosh.repo.studentRepo;
@Service
public class serviceImpl implements service {
	 @Autowired
	 courseRepo cRepo;
	 
	 @Autowired
	 studentRepo sRepo;
	 
	 @Autowired
	 instructorRepo insRepo;
	 
	 @Autowired
	 categoryRepo catRepo;

	@Override
	public List<courseBinding> getAllCourses() {
	 	List<courses> coursesList = cRepo.findAll();
	 	List<courseBinding> data = new ArrayList<>();
	 	
	 	   for(courses course :coursesList) {
	 		          courseBinding cour = new courseBinding();
	 		           
	 		          BeanUtils.copyProperties(course, cour);
	 		          data.add(cour);
	 	   }
	 	return data;
	}

	@Override
	public String  activeStatus(Integer id) {
		
		Optional<courses> opCourse = cRepo.findById(id);
		    courses course  = opCourse.get();
		      if(course.getActiveSt()=="Y") {
		    	  course.setActiveSt("N");
		    	  return AppConstants.activated;
		    	  
		      }
		      else {
		    	    course.setActiveSt("Y");
		    	    return  AppConstants.deactivated;
		      }
		 
	}

	@Override
	public boolean updateCourse(courseBinding data) {
		        courses course=  cRepo.findById(data.getId()).get();
		        BeanUtils.copyProperties(data, course);
		return true;
	}

	@Override
	public boolean createCourse(courseBinding data) {
		       courses course = new courses();
		                    String category = data.getCourseCategoryString();
		                                      Course_Category cat = catRepo.findByName(category);
		        BeanUtils.copyProperties(data, course);
		        course.setCourseCategory(cat);
		        course.setActiveSt("Y");
		        cRepo.save(course);
		
		return true;
	}

	@Override
	public List<courses> enrolled(Integer studentId) {
		            student s =         sRepo.findById(studentId).get(); 
		            List<courses> courses = s.getCourses();
		return courses;
	}

	@Override
	public List<courses> instructCourses(Integer instrcutId) {
		   Instructor ins  = insRepo.findById(instrcutId).get();
		            List<courses> courses  = ins.getCourses();
		
		return courses;
	}

	@Override
	public boolean enroll(Integer studentId, Integer courseId) {
		                        courses course = cRepo.findById(courseId).get();
		                        student s = sRepo.findById(studentId).get();
		                 List<courses> courses = s.getCourses();
		                 courses.add(course);
		return true;
	}

	@Override
	public List<courses> getActiveCourses() {
		List<courses> courses = cRepo.getActiveCourses();
		
		return courses;
	}

}

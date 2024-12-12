package com.ashutosh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashutosh.binding.getFeedBack;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.courses;
import com.ashutosh.entity.feedback_instructor_data;
import com.ashutosh.entity.student;
import com.ashutosh.repo.courseRepo;
import com.ashutosh.repo.feedBackRepo;
import com.ashutosh.repo.instructorRepo;
import com.ashutosh.repo.studentRepo;
@Service
public class serviceImpl implements service {
	      @Autowired
	      studentRepo sRepo;
	      
	      @Autowired
	      courseRepo cRepo;
	      
	      @Autowired
	      instructorRepo insRepo;
	      
	      @Autowired
	      feedBackRepo feedRepo;

	@Override
	public List<student> getEnrolledStudent(Integer courseId) {
		   
		   List<student>     student =      sRepo.findByCoursesContaining(courseId);
		return student;
	}

	@Override
	public List<Instructor> getAllInstructor() {
		    List<Instructor>   instructors=           insRepo.findAll();
		    
		return instructors;
	}

	@Override
	public List<Instructor> getActiveInstructors() {
		 List<Instructor>   instructors=    insRepo.getActiveInsturctor();
		return instructors;
	}

	@Override
	public boolean addFeedback(com.ashutosh.binding.addFeedback data) {
		                feedback_instructor_data finalData= new  feedback_instructor_data();
		                BeanUtils.copyProperties(data, finalData);
		                 feedRepo.save(finalData);
		return true;
	}

	@Override
	public List<getFeedBack> getFeddBack(Integer insId) {
		    List<feedback_instructor_data> data =   feedRepo.findByInstructorId(insId);
		    List<getFeedBack> finalData= new ArrayList<>();
		       for(feedback_instructor_data d : data ) {
		    	    Integer sid = d.getStudentId();
		    	student s =      sRepo.findById(sid).get();
		    	 String name = s.getName();
		    	 getFeedBack getFeed = new getFeedBack();
		    	    getFeed.setStudentName(name);
		    	    getFeed.setStudentId(sid);
		    	    getFeed.setFeedBack(d.getFeedback());
		    	    finalData.add(getFeed);
		       }
		return finalData;
	}

}

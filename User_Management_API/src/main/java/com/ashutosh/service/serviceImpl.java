package com.ashutosh.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashutosh.App_Constants.constants;
import com.ashutosh.binding.forgotPassword;
import com.ashutosh.binding.forgotPasswordStart;
import com.ashutosh.binding.signUpStudent;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.forgotPassword_details;
import com.ashutosh.entity.role;
import com.ashutosh.entity.student;
import com.ashutosh.repo.instructorRepo;
import com.ashutosh.repo.roleRepo;
import com.ashutosh.repo.studentRepo;
import com.ashutosh.util.utility;

@Service
public class serviceImpl implements service {
	
	
	 @Autowired
	  studentRepo sRepo;
	 
	 @Autowired
	 instructorRepo insRepo;
	 
	 @Autowired
	 roleRepo rRepo;
	 
	 

	@Override
	public String forgot(forgotPassword details) {
		    String role = details.getRole();
		       if(role=="Student") {
		    	    if(!details.getNewPassword().equals(details.getConfPassword())) {
		    	    	 return constants.new_conf_not;
		    	    }
		    	         String email = details.getEmail();
		    	         student s = sRepo.findByEmail(email);
		    	         String password = details.getConfPassword();
		    	         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		    	         String newPass = encoder.encode(password);
		    	         s.setPassword(newPass);
		    	         forgotPassword_details forgot = new forgotPassword_details();
		    	         forgot.setNewPassword(details.getNewPassword());
		    	         forgot.setReason(details.getReason());
		    	         forgot.setRequestId(s.getId());
		    	         role r = s.getRole();
		    	         forgot.setRole(role);
		    	         
		    	         return constants.pwd_updated;
		    	         
		       }
		       else {
		    	   if(!details.getNewPassword().equals(details.getConfPassword())) {
		    	    	 return constants.new_conf_not;
		    	    }
		    	   String email = details.getEmail();
	    	         Instructor s = insRepo.findByEmail(email);
	    	         String password = details.getConfPassword();
	    	         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    	         String newPass = encoder.encode(password);
	    	         s.setPassword(newPass);
	    	         forgotPassword_details forgot = new forgotPassword_details();
	    	         forgot.setNewPassword(details.getNewPassword());
	    	         forgot.setReason(details.getReason());
	    	         forgot.setRequestId(s.getId());
	    	         role r = s.getRole();
	    	         forgot.setRole(role);
	    	         return constants.pwd_updated;
	    	         
		       }
	
		 

		
	}

	@Override
	public boolean signUp(signUpStudent details) {
	                  String pass  = details.getPassword();
	                  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	                   String newPass = encoder.encode(pass);
	                   student s = new student();
	                   BeanUtils.copyProperties(details, s);
	                    s.setPassword(newPass);
	                Optional<role> op =  rRepo.findById(3)	  ;  
	                 role r = op.get();
	                 s.setRole(r);
	                 s.setActiveSt("Y");
	                  sRepo.save(s);
		return true;
	}

	@Override
	public boolean updateInstructor(com.ashutosh.binding.updateInstructor details) {
		                   Instructor ins = insRepo.findByEmail(details.getEmail())  ;
		                   BeanUtils.copyProperties(details, ins);
		                   insRepo.save(ins);
		return true;
	}

	@Override
	public boolean updateStudent(com.ashutosh.binding.updateStudent details) {
		student s = sRepo.findByEmail(details.getEmail());
		           BeanUtils.copyProperties(details, s);
		           sRepo.save(s);
		return true;
	}

	@Override
	public String  updatePassword(com.ashutosh.binding.updatePassword details) {
		           if(!details.getNewPassword().equals(details.getConfPassword()))  {
		        	    return constants.new_conf_not;
		           }
		           BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		           String pass  = details.getOldPassword();
		            String oldEncoded = encoder.encode(pass);
		              if(details.getRole().equals("Student")) {
		            	  student s = sRepo.findByEmail(details.getEmail());
		            	   if(!s.getPassword().equals(oldEncoded)) {
		            		  return constants.old_wrong; 
		            	   }
		            	   String newEncoded = encoder.encode(details.getConfPassword());
		            	    s.setPassword(newEncoded);
		            	    sRepo.save(s);
		            	    return constants.pwd_updated;
		              }
		              else {
		            	  Instructor s = insRepo.findByEmail(details.getEmail());
		            	   if(!s.getPassword().equals(oldEncoded)) {
		            		  return constants.old_wrong; 
		            	   }
		            	   String newEncoded = encoder.encode(details.getConfPassword());
		            	    s.setPassword(newEncoded);
		            	    insRepo.save(s);
		            	    return constants.pwd_updated;
		              }
		           
		
	}

	@Override
	public String forgotStart(forgotPasswordStart details) {
		String email  = details.getEmail();
		String role = details.getRole();
		 if(role=="Studnet") {
			     student s = sRepo.findByEmail(email);
			      if(s.equals(null)){
			    	   return  constants.acc_not_exit;
			      }
			 utility  u = new utility()   ;  
			  String to = details.getEmail();
			  String subject="Password Updation";
			  String  body = "Click Here to Reset Password ";
			  
			  u.sendMail(subject, body, to);
			  return constants.email_sended;
			  
		 }
		 else { 
			 Instructor s = insRepo.findByEmail(email);
	      if(s.equals(null)){
	    	   return  constants.acc_not_exit;
	      }
	 utility  u = new utility()   ;  
	  String to = details.getEmail();
	  String subject="Password Updation";
	  String  body = "Click Here to Reset Password ";
	  
	  u.sendMail(subject, body, to);
	  return constants.email_sended;
			 
		 }
		  
		 
		
	}

	@Override
	public String changeVisiblityStudent(Integer id) {
	                   student s   = sRepo.findById(id).get();
	                    if(s.getActiveSt()=="Y") {
	                    	          s.setActiveSt("N");
	                    	          return constants.deactivated;
	                    }
	                    else {
	                    	 s.setActiveSt("Y");
	                    	 return constants.activated;
	                    }
		
	}

	@Override
	public String chnageVisiblityIns(Integer id) {
		               Instructor ins =              insRepo.findById(id).get();
		               if(ins.getActiveSt()=="Y") {
             	          ins.setActiveSt("N");
             	          return constants.deactivated;
             }
             else {
             	 ins.setActiveSt("Y");
             	 return constants.activated;
             }
		
	}

	@Override
	public student getStudentDetail(Integer sid) {
		student data = sRepo.findById(sid).get();
		return data;
	}

	@Override
	public Instructor getInstructorDetail(Integer insId) {
		 Instructor ins = insRepo.findById(insId).get();
		return ins;
	}

}

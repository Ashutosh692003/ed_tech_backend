package com.ashutosh.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashutosh.AppConstants.AppConstants;
import com.ashutosh.binding.adminCreation;
import com.ashutosh.binding.adminUpdate;
import com.ashutosh.binding.communicationBinding;
import com.ashutosh.entity.Admin;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.Transaction;
import com.ashutosh.entity.role;
import com.ashutosh.repo.AdminRepo;
import com.ashutosh.repo.TransRepo;
import com.ashutosh.repo.instructorRepo;
import com.ashutosh.repo.roleRepo;
import com.ashutosh.util.utility;
@Service
public class serviceImpl implements service {
	
	 @Autowired
	 utility util;
	
	
	 @Autowired
	 roleRepo rRepo;
	 
	 @Autowired
	 AdminRepo adRepo;
	 
	 @Autowired
	 instructorRepo insRepo;
	 
	 @Autowired
	 TransRepo tRepo;
	 
	 // same binding class used for both instructor and admin account creation 

	@Override
	public String insAccCreation(adminCreation acc) {
		Instructor i  =  insRepo.findByEmail(acc.getEmail());
		           if(i!=null) {
		        	    return AppConstants.acc_exist;
		           }
		           BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		Instructor ins = new Instructor();
		BeanUtils.copyProperties(acc, ins);
		    ins.setActiveSt("Y");
		    ins.setPassword(passwordEncoder.encode(acc.getPassword()));
		    Integer roleId = acc.getRoleid();
            role r = rRepo.findById(roleId).get();
            ins.setRole(r);
            
            insRepo.save(ins);

		    
	                
		return AppConstants.acc_created;
	}

	@Override
	public String adminAccCreation(adminCreation acc) {
		
		
		              Admin ad  = adRepo.findByEmail(acc.getEmail());
		               if(ad!=null) {
		            	    return AppConstants.acc_exist;
		               }
		
		               BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 Admin data = new Admin();
		            BeanUtils.copyProperties(acc, data);
		             Integer roleId = acc.getRoleid();
		               role r = rRepo.findById(roleId).get();
		               data.setRole(r);
		               data.setActiveSt("Y");
		                String finalPassword = passwordEncoder.encode(acc.getPassword())  ;
		                data.setPassword(finalPassword);
		               adRepo.save(data);
		               
		       
		return AppConstants.acc_created;
	}

	@Override
	public String adminAccUpdate(adminUpdate add) {
		
		 Admin data = adRepo.findByEmail(add.getEmail());
		            BeanUtils.copyProperties(add, data);
		            adRepo.save(data);
		
		return AppConstants.updated;
	}

	@Override
	public String  changeVisibilityAdmin(Integer id) {
		
	Admin acc=  	   adRepo.findById(id).get();
	   if(acc.getActiveSt()=="Y") {
		   acc.setActiveSt("N");
		   return AppConstants.deactivated;
		   
	   }
	   else {
		    acc.setActiveSt("Y");
		    return AppConstants.activated;
	   }
		
		
	}

	@Override
	public boolean communicate(communicationBinding data) {
		            String to = data.getEmail();
		            String body = data.getMsg();
		            String subject = "Message From ed-tech";
		     boolean b =        util.sendMail(subject, body, to);
		            
		            
		return b;
	}

	@Override
	public List<Transaction> getLastTransaction() {
		      List<Transaction>  trans =       tRepo.getLastTransaction();
		return trans;
	}

}

package com.ashutosh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ashutosh.binding.credentialBinding;
import com.ashutosh.config.CustomUserDetails;
import com.ashutosh.entity.Admin;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.student;
import com.ashutosh.repo.adminRepo;
import com.ashutosh.repo.instructorRepo;
import com.ashutosh.repo.studentRepo;

public class CustomUserDetailService implements UserDetailsService {

	           @Autowired
	           studentRepo sRepo;
	           
	           @Autowired
	           instructorRepo insRepo;
	           
	           @Autowired
	           adminRepo adRepo;
	    
	    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                
		            String str [] = getNameAndRole(username);
		            String role = str[0];
		            String name = str[1];
		          
		            
		              if(role.equals("student")) {
		            	  
		            	   Optional<student>  stu=    sRepo.findByEmail(name);
		            	   if(stu.isEmpty()) {
		            	    	 throw new UsernameNotFoundException("User Not found for name "+username);
		            	    }
		            		 else {
		            			
		            			 student cred1= stu.get();
		            			  credentialBinding cred = new credentialBinding();
		            			   cred.setUserName(username);
		            			   cred.setActiveSt(cred1.getActiveSt());
		            			   cred.setPassword(cred1.getPassword());
		            			 return new CustomUserDetails(cred);
		            		 }
		              }
		              else if(role.equals("admin")) {
		            	  Optional<Admin>  stu=    adRepo.findByEmail(name);
		            	   if(stu.isEmpty()) {
		            	    	 throw new UsernameNotFoundException("User Not found for name "+username);
		            	    }
		            		 else {
		            			
		            			 Admin cred1= stu.get();
		            			  credentialBinding cred = new credentialBinding();
		            			   cred.setUserName(username);
		            			   cred.setActiveSt(cred1.getActiveSt());
		            			   cred.setPassword(cred1.getPassword());
		            			 return new CustomUserDetails(cred);
		            		 }
		            	  
		            	  
		              }
		              else {
		            	  
		            	  Optional<Instructor>  stu=    insRepo.findByEmail(name);
		            	   if(stu.isEmpty()) {
		            	    	 throw new UsernameNotFoundException("User Not found for name "+username);
		            	    }
		            		 else {
		            					            			 Instructor cred1= stu.get();
		            			  credentialBinding cred = new credentialBinding();
		            			   cred.setUserName(username);
		            			   cred.setActiveSt(cred1.getActiveSt());
		            			   cred.setPassword(cred1.getPassword());
		            			 return new CustomUserDetails(cred);
		            		 }
		              }
		             
	
	
	}
	
	public String[] getNameAndRole(String name) {
         int index = name.indexOf( '_');

        String  role = name.substring(0, index);
        String name1 = name.substring(index+1);
        
          String str[] = {role,name1};
          return str;
	}

}

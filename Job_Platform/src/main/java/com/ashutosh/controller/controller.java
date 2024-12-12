package com.ashutosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.binding.appBinding;
import com.ashutosh.binding.jobBinding;
import com.ashutosh.entity.Job;
import com.ashutosh.service.service;

@RestController
public class controller {
	
	 @Autowired
	 service serv;
	 
	  
	    @PostMapping("/postJob")
	    public ResponseEntity<String> postJob(jobBinding data) {
	    	 
	    	  String resp =     serv.createJob(data);
	    	  return new ResponseEntity<>(resp,HttpStatus.CREATED);
	    	
	    }
	    @PostMapping("/updateJob")
	    public ResponseEntity<String> updateJob( @RequestParam("jobId") Integer jobId, @RequestBody jobBinding data){
	    	 String resp = serv.updateJob(jobId, data);
	    	 return new ResponseEntity<>(resp,HttpStatus.CREATED);
	    }
	    
	     @GetMapping("/inActiveJob")
	    public boolean inActieJob(@RequestParam("jobId") Integer jobId) {
	    	        boolean b =          serv.inActiveJob(jobId);
	    	        return b;
	    }
	     
	      @GetMapping("getActiveJobs")
	     public List<Job> getActiveJob(){
	    	 List<Job> jobs =     serv.getActiveJob();
	    	 return jobs;
	     }
           
	       @GetMapping("/getAppliedJobData")
	      public List<Job> getAppliedData(@RequestParam("studentId") Integer studentId){
	    	   List<Job>  jobs =       serv.getAppliedJobData(studentId);
	    	   return jobs;
	      }
	       
	       @PostMapping("/apply")
	       public ResponseEntity<String> apply(@RequestBody appBinding data){
	    	   String resp =         serv.apply(data);
	    	   return new ResponseEntity<>(resp,HttpStatus.OK);
	       }
	       
	        @GetMapping("/salaryFitler")
	       public List<Job> salaryFilter(@RequestParam("min") Integer min,@RequestParam("max")Integer max){
	    	       List<Job>     jobs =       serv.salaryFilter(min, max);
	    	       return jobs;
	       }
	        
	        @GetMapping("/empTypeFitler")
		       public List<Job> empTypeFilter(@RequestParam("type")String type){
		    	       List<Job>     jobs =       serv.employmentTypeFilter(type);
		    	       return jobs;
		       }
	        
	        @GetMapping("/domainFitler")
		       public List<Job> domainFilter(@RequestParam("domain")String domain){
		    	       List<Job>     jobs =       serv.domainFilter(domain);
		    	       return jobs;
		       }
		        
}

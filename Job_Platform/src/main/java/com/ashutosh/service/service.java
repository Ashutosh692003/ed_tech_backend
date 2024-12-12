package com.ashutosh.service;

import java.util.List;

import com.ashutosh.binding.appBinding;
import com.ashutosh.binding.jobBinding;
import com.ashutosh.entity.Job;

public interface service {
	
	 public String createJob(jobBinding data);
	 
	 public String updateJob(Integer jobId,jobBinding data );
	 
	 public boolean inActiveJob(Integer jobId);
	 
	 public List<Job> getActiveJob();
	 
	 public List<Job> getAppliedJobData(Integer studentId);
	 
	 public String apply(appBinding data);
	 
	 public List<Job> salaryFilter(Integer minSalary,Integer maxSalary);
	 
	 public List<Job> employmentTypeFilter(String type);
	 
	 public List<Job> domainFilter(String domain);

}

package com.ashutosh.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashutosh.AppConstants.AppConstants;
import com.ashutosh.binding.appBinding;
import com.ashutosh.binding.jobBinding;
import com.ashutosh.entity.Job;
import com.ashutosh.entity.jobApplication;
import com.ashutosh.repo.jobAppRepo;
import com.ashutosh.repo.jobRepo;
@Service
public class serviceImpl implements service {
	
	                  @Autowired
	                  jobRepo jRepo;
	                  
	                  @Autowired
	                  jobAppRepo appRepo;

	@Override
	public String createJob(jobBinding data) {
		          Job j = new Job();
		         BeanUtils.copyProperties(data, j);
		           j.setJobStatus("Active");
		           jRepo.save(j);
		          
		
		return AppConstants.posted;
	}

	@Override
	public String updateJob(Integer jobId,jobBinding data) {
		                 Job j = jRepo.findById(jobId).get();
		                 BeanUtils.copyProperties(data, j);
		                 jRepo.save(j);
		return AppConstants.updated;
	}

	@Override
	public boolean inActiveJob(Integer jobId) {
		            Job j = jRepo.findById(jobId).get();
		            j.setJobStatus("Closed");
		            
		return true;
	}

	@Override
	public List<Job> getActiveJob() {
		     List<Job> jobs = jRepo.getActiveJob();
		return jobs;
	}

	@Override
	public List<Job> getAppliedJobData(Integer studentId) {
		 List<Job> jobs = appRepo.getAppliedJobData(studentId);
		return jobs;
	}

	@Override
	public String apply(appBinding data) {
		              jobApplication appData= new jobApplication();
		              BeanUtils.copyProperties(data, appData);
		              Job j  = jRepo.findById(data.getJobIdInteger()).get();
		              appData.setJobId(j);
		return AppConstants.submited;
	}

	@Override
	public List<Job> salaryFilter(Integer minSalary, Integer maxSalary) {
		            List<Job> jobs= jRepo.findBySalaryRange(minSalary, maxSalary);
		return jobs;
	}

	@Override
	public List<Job> employmentTypeFilter(String type) {
		          List<Job>  jobs =           jRepo.findByEmploymentType(type);
		return jobs;
	}

	@Override
	public List<Job> domainFilter(String domain) {
		     List<Job>  jobs =          jRepo.findByDomain(domain);
		return jobs;
	}

}

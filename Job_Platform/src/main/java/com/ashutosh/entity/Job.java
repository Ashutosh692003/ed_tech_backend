package com.ashutosh.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "Job_Data")
public class Job {
           
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer job_id;
	 private String jobTitle;
	 private String companyName;
	 private String jobDescription;
	 private String location;
	 private String employmentType;
	 private Integer salary;
	 private String experience;
	 private String education;
	 private String skill;
	 @CreationTimestamp
	 private LocalDate postDate;
	 private String contactInfo;
	 private String jobStatus;
	 private String domain;
	
}

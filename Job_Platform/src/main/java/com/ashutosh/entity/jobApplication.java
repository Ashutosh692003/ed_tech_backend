package com.ashutosh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Job Application Data")
public class jobApplication {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	private String name;
	private Integer studentId;
	@ManyToOne
	private Job jobId;
	@Lob
	@Column(length=1000)
	private String coverLetter;
	private String resumeLink;
	private String hiringReason;
	private String githubProjectLink;

}

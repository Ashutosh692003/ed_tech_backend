package com.ashutosh.binding;

import com.ashutosh.entity.Job;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class appBinding {
	
	private String name;
	private Integer studentId;
	private Integer jobIdInteger;
	@Lob
	@Column(length=1000)
	private String coverLetter;
	private String resumeLink;
	private String hiringReason;
	private String githubProjectLink;

}

package com.ashutosh.binding;

import java.time.LocalDate;

import com.ashutosh.entity.role;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
public class adminCreation {
	
	
	   private String name;
	   private String email;
	   private String password;
	   private  Integer roleid;
	   private String img_URL;
	   private String bio;
	   private LocalDate dob;
	   private String specialization;
	   private String experience;
	   private String education;


}

package com.ashutosh.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Admin_Data")
@Data
public class Admin {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
		   private Integer id;
		   private String name;
		   private String email;
		   private String password;
		    @OneToOne(fetch = FetchType.EAGER) 
		   private  role role;
		   private String imgURL;
		   private String bio;
		   private LocalDate dob;
		   private String activeSt;
}

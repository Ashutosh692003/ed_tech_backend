package com.ashutosh.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Admin_Data")
public class Admin {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
		   private Integer id;
		   private String name;
		   private String email;
		   private String password;
		    @OneToOne(fetch = FetchType.EAGER) 
		   private  role role;
		   private String img_URL;
		   private String bio;
		   private LocalDate dob;
		   private String specialization;
		   private String experience;
		   private String education;
		   private String activeSt;
		   @CreationTimestamp
		   @Column(name = "Creation_Date",updatable = false)
		   private LocalDate accCreateDate;
		   @UpdateTimestamp
		   @Column(name = "Update_Date",insertable = false)
		   private LocalDate accUpdateDate;
}

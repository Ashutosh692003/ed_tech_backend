package com.ashutosh.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Course_Category implements Serializable {
	
	
	 @Id
	
   private Integer id;
	 @Column(name = "Category_name")
   private String name;
	 @Column(name = "courses")
   @OneToMany(mappedBy = "courseCategory", fetch = FetchType.EAGER)
   private List<courses> allCourses;
}

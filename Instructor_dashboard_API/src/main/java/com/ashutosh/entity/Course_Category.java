package com.ashutosh.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Course_Category implements Serializable {
	
	
	 @Id
	
   private Integer id;
	 @Column(name = "Category_name")
   private String name;
	 @Column(name = "courses")
   @OneToMany(mappedBy = "courseCategory")
   private List<courses> allCourses;
}

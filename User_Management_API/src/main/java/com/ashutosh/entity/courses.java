package com.ashutosh.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "Course_Data")
public class courses implements Serializable {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String courseName;
	private String description;
	private String deliveryMode;
	private LocalDate startDate;
	private LocalDate endDate;
	private String imgUrl;
	private String activeSt;
	private List<String> content;
	private Integer price;
	private String  courseType;
	@JoinColumn(name="Category", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Course_Category courseCategory;

	@JoinColumn
	@ManyToOne(fetch = FetchType.EAGER)
	private Instructor instructor;

}

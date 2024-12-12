package com.ashutosh.bindinig;

import java.time.LocalDate;
import java.util.List;

import com.ashutosh.entity.Course_Category;
import com.ashutosh.entity.Instructor;

import lombok.Data;
@Data
public class courseBinding {
	private Integer id;
	private String courseName;
	private String description;
	private String deliveryMode;
	private LocalDate startDate;
	private LocalDate endDate;
	private String imgUrl;
	private List<String> content;
	private Integer price;
	private String  courseType;
	private String courseCategoryString;
	private Instructor instructor;
}

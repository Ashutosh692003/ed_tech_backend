package com.ashutosh.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Table(name = "Trending_Courses")
@Entity
public class trending {
    
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trendingId;
	 @Lob
	private courses course;
}

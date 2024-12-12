package com.ashutosh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Post Reaction Data")
public class Reaction {
	@Id
	 @GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer userId;
	private String role;
	@ManyToOne
	private Post post;
	private String type;

}

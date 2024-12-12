package com.ashutosh.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Post Data")
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private Integer userId;
	 private String role;
	 private String title;
	 private String content;
	 @CreationTimestamp
	 private LocalDate createdAt;
	 @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	 List<Comment> comments;
	 @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	 List<Reaction> reactions;
	 
}

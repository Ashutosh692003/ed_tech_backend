package com.ashutosh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.entity.Post;

public interface postRepo  extends JpaRepository<Post,Long>{
	@Query(value = "Select * from Post Data where id = ?1", nativeQuery = true)
	public Post getPostById(Long id);
	
	 @Query(value = "SELECT * FROM Post Data ORDER BY id DESC", nativeQuery = true)
	    List<Post> findAllByOrderByIdDesc();

}

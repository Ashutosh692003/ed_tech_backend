package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.entity.trending;

public interface trendingRepo  extends JpaRepository<trending,Integer>{
	 
}

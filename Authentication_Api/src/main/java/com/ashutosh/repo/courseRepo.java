package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.Admin;
import com.ashutosh.entity.courses;

public interface courseRepo extends JpaRepository<courses,Integer>  {

}

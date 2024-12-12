package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.Admin;

public interface AdminRepo  extends JpaRepository<Admin,Integer>{

	 public Admin findByEmail(String email);
}

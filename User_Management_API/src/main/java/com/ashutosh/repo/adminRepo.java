package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.Admin;

public interface adminRepo extends JpaRepository<Admin,Integer> {

}

package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.forgotPassword_details;

public interface forgotPwdRepo extends JpaRepository<forgotPassword_details,Integer> {

}

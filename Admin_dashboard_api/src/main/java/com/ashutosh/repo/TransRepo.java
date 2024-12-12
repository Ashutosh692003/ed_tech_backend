package com.ashutosh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.entity.Transaction;

public interface TransRepo extends JpaRepository<Transaction,Integer> {
     
@Query(value ="SELECT * FROM Payment_Data ORDER BY id DESC LIMIT 50" ,nativeQuery = true)
	 public List<Transaction> getLastTransaction();
}

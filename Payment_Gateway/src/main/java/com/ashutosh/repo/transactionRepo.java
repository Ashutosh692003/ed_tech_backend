package com.ashutosh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.entity.Transaction;
import com.ashutosh.entity.courses;

public interface transactionRepo extends JpaRepository<Transaction,Integer> {
	
	 
	@Query(value = "SELECT * Payment_Data WHERE orderId = ?1 ", nativeQuery = true)
    Transaction  findByOrderId(String orderId);


}

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
@Table(name = "Payment_Data")
public class Transaction {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer transactionId;
	 private Integer amount;
	 private String receipt;
	 private String orderId;
	 private String status;
	 private String paymentId;
	 @ManyToOne
	 private courses courseId;
	 @ManyToOne
	 private student studentId;
	 
}

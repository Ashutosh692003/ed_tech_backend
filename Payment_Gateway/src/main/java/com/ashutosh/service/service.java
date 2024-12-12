package com.ashutosh.service;

import com.ashutosh.binding.paymentBinding;
import com.razorpay.RazorpayException;

public interface service {
	 
	public String makePayment(Integer amount,Integer courseId,Integer studentId) throws RazorpayException;
	
	public boolean addTransaction(paymentBinding data);

}

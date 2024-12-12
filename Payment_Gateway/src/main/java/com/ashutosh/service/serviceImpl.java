package com.ashutosh.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashutosh.binding.paymentBinding;
import com.ashutosh.entity.Transaction;
import com.ashutosh.entity.courses;
import com.ashutosh.entity.student;
import com.ashutosh.repo.courseRepo;
import com.ashutosh.repo.studentRepo;
import com.ashutosh.repo.transactionRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
@Service
public class serviceImpl implements service {
	
	 @Autowired
	 courseRepo cRepo;
	 
	 @Autowired
	 studentRepo sRepo;
	 
	 @Autowired
	 transactionRepo transRepo;

	@Override
	public String makePayment(Integer amount,Integer courseId,Integer studentId) throws RazorpayException {
RazorpayClient client = new RazorpayClient("rzp_test_XF0SJ3RZkZwtti","bBtQoyaQqnk7MZyeOFOzqK4E");
		
		JSONObject options = new JSONObject();
		options.put("amount", amount);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		Order order = client.orders.create(options);
		          courses course =        cRepo.findById(courseId).get();
		          student stu = sRepo.findById(studentId).get();
		Transaction trans = new Transaction();
		  trans.setAmount(order.get("amount_due"));
		  trans.setCourseId(course);
		  trans.setOrderId(order.get("id"));
		  trans.setReceipt(order.get("receipt"));
		  trans.setStatus(order.get("status"));
		  trans.setStudentId(stu);
		  transRepo.save(trans);
		  
		return order.toString();
		
	}

	@Override
	public boolean addTransaction(paymentBinding data) {
		                 Transaction trans =         transRepo.findByOrderId(data.getOrderId());
		                 trans.setPaymentId(data.getPaymentId());
		                 trans.setStatus(data.getStatus());
		                 transRepo.save(trans);
		return true;
	}

}

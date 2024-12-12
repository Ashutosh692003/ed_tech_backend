package com.ashutosh.service;

import java.util.List;

import com.ashutosh.binding.adminCreation;
import com.ashutosh.binding.adminUpdate;
import com.ashutosh.binding.communicationBinding;
import com.ashutosh.entity.Transaction;

public interface service {
	
	   public String insAccCreation(adminCreation acc);
	   
	   public String adminAccCreation(adminCreation acc);
	   
	   public String adminAccUpdate(adminUpdate acc);
	   
	   public String  changeVisibilityAdmin(Integer id);
	   
	   // Report Generation 
	   
	   public boolean communicate(communicationBinding data);
	   
	   
	   public List<Transaction> getLastTransaction();
	   

}

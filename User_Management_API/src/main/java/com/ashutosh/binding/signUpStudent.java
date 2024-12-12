package com.ashutosh.binding;

import java.time.LocalDate;

import lombok.Data;
@Data
public class signUpStudent {
	
	 private String name;
	 private String email;
	 private String password;
	 private LocalDate dob;
	 private String institute;
	 private String country;
	 private String phoneNum;

}

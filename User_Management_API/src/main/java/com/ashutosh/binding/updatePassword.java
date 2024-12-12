package com.ashutosh.binding;

import lombok.Data;

@Data
public class updatePassword {
	
	 private String email;
	 private String oldPassword;
	 private String newPassword;
	 private String confPassword;
	 private String role;
              
}

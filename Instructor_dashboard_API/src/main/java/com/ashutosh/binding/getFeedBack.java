package com.ashutosh.binding;

import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class getFeedBack {
	 
	 private String studentName;
	 private Integer studentId;
	 @Lob
	 private String feedBack;
	 

}

package com.ashutosh.binding;

import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class communicationBinding {

	 private String email;
	 @Lob
	 private String msg;
}

package com.ashutosh.binding;

import lombok.Data;

@Data
public class commentBinding {

	private Integer userId;
	private String role;
	private String content;
	private Long postId;
}

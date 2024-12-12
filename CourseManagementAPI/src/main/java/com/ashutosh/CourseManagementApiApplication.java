package com.ashutosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CourseManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementApiApplication.class, args);
	}

}
package com.drifai.careproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.drifai.careproject.controller,com.drifai.careproject.service")
public class CareprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareprojectApplication.class, args);
	}

}

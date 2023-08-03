package com.capstone.capstoneproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CapstoneProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProductApplication.class, args);
	}

}

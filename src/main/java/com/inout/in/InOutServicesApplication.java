package com.inout.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InOutServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InOutServicesApplication.class, args);
	}

}

package com.springjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbootSpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootSpringJdbcApplication.class, args);
		
		System.out.println("SpringBoot - Spring JDBC");
	}

}

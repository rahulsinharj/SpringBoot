package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbootJwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootJwtAuthenticationApplication.class, args);
		
		System.out.println("AWT Auth Application Running !");
	}

}

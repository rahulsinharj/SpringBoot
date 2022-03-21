package com.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.securitydemo.service.UserDbService;

@SpringBootApplication
public class SbootSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserDbService userDbService;
	
	public static void main(String[] args) {
		SpringApplication.run(SbootSecurityApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
//		userDbService.createUser();								// On everytime refresh , this line will execute. Better to execute it once. 
		
		System.out.println("Inserting user Credentials into DB");
	}

}

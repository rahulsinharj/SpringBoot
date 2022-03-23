package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.interfaceDemo.InterfaceZ;

@SpringBootApplication
public class FirstSpringBootApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("myImplA")
	private InterfaceZ interfaceZ;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		this.interfaceZ.m1();
		
	}
}

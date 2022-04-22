package com.actuatorDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbootActuator1Application {

	public static void main(String[] args) {
		SpringApplication.run(SbootActuator1Application.class, args);
		
		System.out.println("Spring Actuator Application Running..!");
	}

}

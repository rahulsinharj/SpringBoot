package com.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.interfaceDemo.InterfaceZ;

@SpringBootApplication
public class FirstSpringBootApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("myImplA")
	private InterfaceZ interfaceZ;
	
	@Value("${myNum1}")			// Use $ For values coming dynamically from Application.prop file
	private int num1;
	
	//@Value("#{2+5}")			// Use # For inserting contant literal values
	@Value("#{25}")	
	private int num2;
	
	@Value("${myStr1}")	
	private String str1;

	@Value("${mylist1}")	
	private List<String> list1;				// List of String

	@Value("${mylist2}")	
	private List<String> list2;				
	
	@Value("${mylist3}")	
	private List<Integer> list3;			// List of Integer
	
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		this.interfaceZ.m1();
		
		System.out.println("Fetching values from Application.properties file :: ");
		
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		System.out.println("str1 : "+str1);
		System.out.println("list1 : "+list1);
		System.out.println("list2 : "+list2);
		System.out.println("list3 : "+list3);
		
		
	}
}

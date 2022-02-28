package com.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/about")				// We can also use   @RequestMapping(path = "about", method = RequestMethod.GET)	
	public String about(Model model)
	{
		System.out.println("Inside ABOUT handler");
		model.addAttribute("name","Rahul Sinha");
		model.addAttribute("currentDate", new Date());
		
		return "about";		// returning  "about.html" page
	}

	
	// Handling Iteration in Thymeleaf ::
	@GetMapping("/loop-example")
	public String iterateHandler(Model m)
	{
		List<String> names = List.of("Rahul", "Vikash" , "Shubham" , "Shashank");
		m.addAttribute("names",names);
		
		return "iterate";
	}
	
	
	// Handler for conditional statement :: 
	@GetMapping("/condition")
	public String conditionHandler(Model m)
	{
		System.out.println("Conditional Handler executed..!");
		m.addAttribute("isActive", true);
		m.addAttribute("gender","M");
		
		List<Integer> mylist = List.of(2,5,6,8,9);
		m.addAttribute("mylist",mylist);
		
		return "conditional";
	}
	
	
	@GetMapping("/services")
	public String servicesHandler(Model m)			// For checking REPLACE, INSERT, INCLUDE in Thymeleaf 
	{
		m.addAttribute("mainTitle" , "I LOVE TO DO PROGRAMMING..!");
		m.addAttribute("mainDate" , LocalDateTime.now().toString());
		return "services";
	}
	

	@GetMapping("/inherit")
	public String inheritHandler()			// For checking Inherit functionality in Thymeleaf 
	{
		return "inherit";
	}
	
	@GetMapping("/inheritsec")
	public String inheritSecHandler()			// For checking Inherit functionality in Thymeleaf 
	{
		return "inheritsec";
	}

}

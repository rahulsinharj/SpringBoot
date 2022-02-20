package com.boot.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// @RequestMapping("/project1")		// agar yeha pe bhi URL mapping lagayege to niche ke sare mapping isko relative me hi chalega ;  /project1/home 
@Controller
public class HomeController {		/*			Tomcat will be run on   http://localhost:8080/				*/

	@RequestMapping("/")
	@ResponseBody
	public String demo() {
		return "Welcome, Please use these URLs :  /contact , /contact/{userId} , /home , /about ";
	}
	
	@RequestMapping("/home")							// URL Handler method
	public ModelAndView home()
	{
		System.out.println("This is home page");
		ModelAndView model = new ModelAndView();
		
		//setting data
		model.addObject("name","Rahul Sinha");
		model.addObject("phone",99999);
		
		model.addObject("datetime",LocalDateTime.now());
		
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(20);
		marks.add(30);
		marks.add(40);
		marks.add(50);
		marks.add(60);
		model.addObject("marks",marks);
		
		
		model.setViewName("home");
		return model;
		
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	

	
	
	
	
	
}
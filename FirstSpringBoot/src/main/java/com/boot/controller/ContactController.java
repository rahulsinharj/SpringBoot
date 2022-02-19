package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.dao.UserRepository;
import com.boot.model.User;

@Controller								// Please remember, this @Controller tag is must in this Controller Class - for handling URL mappings  
public class ContactController {

	@Autowired
	private UserRepository userRepo;							// UserRepository obj for performing DB crud operations.
	
	@ModelAttribute
	public void commonDataForModel(Model m) {
		m.addAttribute("header1","USER Registration Application :");
		m.addAttribute("description1","HomePage for User registration");
		System.out.println("Adding common data to model");
	}
	
	@RequestMapping("/contact")
	public String showContactForm(Model m) 						
	{
		System.out.println("Showing user contact form");
		return "contact";					// for this "/contact" api url, we are return "contact.jsp" page to the client
	}
	
	
/*	"HttpServletRequest" is an OLD way of retrieving parameters from client    
 --------------------------------------------------------------------------------------------------------------*/
	
/*	@ResponseBody				// use this annotation when we are returning a text, not a page
	@RequestMapping(path = "/processform2" , method=RequestMethod.POST)
	public String saveFormEntry2(HttpServletRequest req) 			// HttpServletRequest is an old way of retrieving parameters from client
	{
		String uemail = req.getParameter("userEmail");
		System.out.println(uemail);
		return uemail;
	}
*/	
	
	
/*	"RequestParam" is an NEW way of retrieving parameters from client in SPRING , and also sending data to VIEW from Controller    
 --------------------------------------------------------------------------------------------------------------*/	
/*	@RequestMapping(path = "/processform" , method=RequestMethod.POST)
	public String saveFormEntry(@RequestParam("userEmail") String uemail ,				// With RequestParam annotation, We will here map the client form field with here's handler methods parameters  
							 	@RequestParam("userName") String uname, 
							 	@RequestParam(name = "userPassword", required = false) String upassword , 			// "required = false" karne se, ab contant.jsp ka ye field me -> user ke dwara value dena compulsory nhi hai ab 
							 	Model model) 				// iss MODEL obj {ya fir ModelAndView} obj se we will send data from Controller class to view (.jsp) pages		
	{
		System.out.println("UserEmail : "+uemail);
		System.out.println("UserName : "+uname);
		System.out.println("UserPassword : "+upassword);
		
		// here processing any data - if required
		
		model.addAttribute("uemail", uemail);
		model.addAttribute("uname", uname);
		model.addAttribute("upassword", upassword);
		
		return "success";
	}
*/	
	
	
/*	RequestParam se ClientFormFields ko leke, fir ek ek attributes ko khudse modelObj me set karne ke bajaaye, hum direct ClientFormFields entries ke corresponding ek "ENTITY class" 'User' banake -> fir direct only uss Entity obj ko hi insert kar skte hai through Model obj 
 --------------------------------------------------------------------------------------------------------------*/		
/*		
	@RequestMapping(path = "/processform" , method=RequestMethod.POST)
	public String saveFormEntry(@RequestParam("userEmail") String uemail ,				// With RequestParam annotation, We will here map the client form field with here's handler methods parameters  
							 	@RequestParam("userName") String uname, 
							 	@RequestParam(name = "userPassword", required = false) String upassword , 			// "required = false" karne se, ab contant.jsp ka ye field me -> user ke dwara value dena compulsory nhi hai ab 
							 	Model model) 				// iss MODEL obj {ya fir ModelAndView} obj se we will send data from Controller class to view (.jsp) pages		
	{
		User user = new User();
		user.setUserEmail(uemail);
		user.setUserName(uname);
		user.setUserPassword(upassword);
		
		model.addAttribute("user", user);
		return "success";
	}
*/

	
/*	Ab ClientFormFields ke alag-alag parameters ke liye alag-alag @RequestParam lagane ki bhi zarurat nhi => we will now only write @ModelAttribute User user => jisse ki ClientFormFields ke paramters automatically "user" obj se bind ho jayege. Also ab alag se MODEL obj banane ki bhi zarurat nhi. 
	 Only thing we have to sure that ->  ClientFormFields ke alag-alag parameters ke name should be exactly same with the USER class properties {corresponding instance variable names}
 --------------------------------------------------------------------------------------------------------------*/
		
/*	@RequestMapping(path = "/processform" , method=RequestMethod.POST)
	public String saveFormEntry(@ModelAttribute User user) 		
	{
		System.out.println(user);
		// put your DB operation here {like- insert,update, or any Calculation operations}
		
		return "success";						// returning "success.jsp" page to the caller
	}
*/	
	
	
/* Here below, we have also added Model parameter, because if we want to send {to view page} some more attributes other than USER obj 
 --------------------------------------------------------------------------------------------------------------*/
	
	@RequestMapping(path = "/processform" , method=RequestMethod.POST)
	public String saveFormEntry(@ModelAttribute User user , Model m) 				
	{
		if(user.getUserEmail().isBlank() || user.getUserName().isBlank() || user.getUserPassword().isBlank()) {
			System.out.println("Please fill all fields..");
			return "redirect:/contact";											// ReDirecting to other URL {either by redirect-prefix, or by RedirectView }
		}
		
		User savedUser = this.userRepo.save(user);				// Will return the saved user obj {which has been just stored in Database repository}
		System.out.println(user);
		// put your DB operation here {like- insert,update, or any Calculation operations}
		
		m.addAttribute("userResponse", "User created with id : "+ savedUser.getUserId());
		
		return "success";						// returning "success.jsp" page to the caller
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

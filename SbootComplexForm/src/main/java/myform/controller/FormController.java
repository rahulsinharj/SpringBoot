package myform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import myform.entity.StudentForm;

@Controller
public class FormController {

	@ResponseBody
	@RequestMapping("/")
	public String reurl() 
	{
		// Or either we can do this redirection as well =>			return "redirect:complex";
		return "Welcome, please use these URLs : /complex ,  /fileform  ,  /add" ;
	}
	
	
	@RequestMapping("/complex")
	public String showform() {
		return "complexform";
	}
	
	
	@RequestMapping(path = "/handleform" , method = RequestMethod.POST)
	public String handleform(@ModelAttribute("stuform") StudentForm stuform , BindingResult result)
	{
		if(result.hasErrors()) {
			System.out.println("Error redirecting to complexform again..");
			return "complexform" ;
		}
		
		System.out.println(stuform);
		return "success";
	}
	

/*
  Below codes are just for testing Exception Handler ::
 -------------------------------------------------------------------------------------------*/
	
	@RequestMapping("/add")
	public String takeAddition() {
		return "add";
	}
	
	@RequestMapping("/addresult")
	public String calulateAddResult(@RequestParam("num1") String n1, @RequestParam("num2") String n2 , Model m) {
		
		if(n1.isBlank() || n1.isBlank()) {
			return "redirect:add";
		}
		
//		String s1 = null;
//		s1 += s1.charAt(0);
		
		long sum = Long.parseLong(n1)+ Long.parseLong(n2);
		m.addAttribute("addans", sum);
		System.out.println("Addition of "+n1 +" + "+n2 +" = "+sum);
		
		return "add";			// also we can use =>   return "redirect:add" ;
	}

	
	
	
}

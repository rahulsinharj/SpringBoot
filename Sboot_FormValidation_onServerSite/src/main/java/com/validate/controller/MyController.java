package com.validate.controller;



import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validate.entity.LoginData;

@Controller
public class MyController {

	@GetMapping("/form")
	public String openForm(Model model)
	{
		System.out.println("Opening form..!!");
		model.addAttribute("loginData", new LoginData());
		return "form";
	}
	
/*	Here, we also need to add @ModelAttribute  annotation - for saving the form entries into ENTITY class "LoginData"
 *	Here, we also need to add @Valid  annotation - for triggering our Validation work that we have done in Entity class "LoginData" 
	 and them the Validation RESULT will be received into 'BindingResult obj' => BindingResult obj should be after @ModelAttribute. 

	@Valid validator , entity class me lage @NotBlank @Size validators ke help se form filed ko validate kar lega, aur BindingResult me uska result de dega.   
	 
	Form Html page me => #fields.errors('userName') ki madat se partuculary 'userName' filed ki sari errors #fields property ke paas aayegi.
	 
*/	// Handler for processing form ::				
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData , BindingResult result ) 
	{
		System.out.println("Inside Process form..!!");
		if(result.hasErrors()) 
		{
			System.out.println(result);
			return "form";						// redirect karne se URL me bhi '/form' show karega, warna kewal "form" return karte to '/process' me hi "/form" ka content show karne lagta. 
		}
		
		System.out.println(loginData);
		return "success";
	}
	
	
	
	 
	
	
}

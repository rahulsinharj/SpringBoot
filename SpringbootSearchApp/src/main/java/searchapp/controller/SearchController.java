package searchapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller								// Please remember, this @Controller tag is must in this Controller Class - for handling URL mappings  
public class SearchController {

	@RequestMapping("/")												// Ye handler -> "/" blank url agar ho to "/home" handler pe redirect karne ke liye 
	public String rehome() {	
		System.out.println("Redirecting to home view..");
		return "redirect:home";
	}
	
	@RequestMapping("/home")											// Ye handler -> form ko dikhane ke liye
	public String home() {
		return "home";
	}
	
	@RequestMapping("/search")											// Ye handler -> form ko query ko fetch karke, redirect karne ke liye.
	public RedirectView search(@RequestParam("querybox") String query)
	{
		if(query.isBlank()) {
			System.out.println("Please fill all fields..");				
			return new RedirectView("home");							// handling blank queries , and redirecting to "/home" handler.
		}	
		
		String url = "https://www.google.co.in/search?q="+query;
		
		RedirectView rview = new RedirectView();
		rview.setUrl(url);
		return rview;
	}
	
	
}

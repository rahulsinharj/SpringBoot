package myform.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping("/fileform")
	public String showUploadForm() {
		return "fileform";
	}

	@RequestMapping(path = "/uploadimage", method = RequestMethod.POST)
	public String uploadImage(@RequestParam("profile") MultipartFile file, HttpSession ses, Model model ) 
	{
		System.out.println("Inside File upload handler...");

		System.out.println("File size : " +file.getSize()/1024 +" kb");				// Return the size of the file in bytes , now in Kb now
		System.out.println("File content type : " +file.getContentType());			// Return the content type of the file.
		System.out.println("Upload parameter name : " +file.getName());											// Return the name of the parameter in the multipart form.
		System.out.println("OriginalFilename : " +file.getOriginalFilename());		// Return the original filename in the client's filesystem. 
		System.out.println("Current working path : "+ ses.getServletContext().getRealPath("/") );
		System.out.println();
		
		try {
			byte[] data = file.getBytes();											// Getting the Byte data from the uploaded file.											
			String path = ses.getServletContext().getRealPath("/") + "static" + File.separator + "image"
					+ File.separator + file.getOriginalFilename();
			
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);														// Saving the file to the server.
			fos.close();
			System.out.println("File uploaded at location : "+path);
			
			model.addAttribute("filename",file.getOriginalFilename());
			model.addAttribute("msg",file.getOriginalFilename()+" Uploaded Successfully..!!");
			
		
		} catch (IOException e) {
			System.out.println("Error in uploading..");
			model.addAttribute("msg","Error in File uploading..!!");
			e.printStackTrace();
		}

		return "filesuccess";
	}

}

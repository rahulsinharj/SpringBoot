package bookapi.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadService {

	public String uploadImage(String uploadPath, MultipartFile imgfile) 
	{
		// File name
		String imgOriginalName = imgfile.getOriginalFilename();			// abc.png

		try {
			// Setting filename with randomId name
			String randomId = UUID.randomUUID().toString();
			String imgNewName = randomId.concat(imgOriginalName.substring(imgOriginalName.lastIndexOf("."))); 
			
			// Full path
			String filePath = uploadPath + File.separator + imgNewName;

			// Create folder if not created
			File f = new File(uploadPath);
			if (!f.exists()) {
				f.mkdir();
			}

			// File copy
			Files.copy(imgfile.getInputStream(), Paths.get(filePath) , StandardCopyOption.REPLACE_EXISTING);
			System.out.println(imgOriginalName + " image uploaded successfully !");
			return imgOriginalName;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return imgOriginalName;
		}
		

	}
}

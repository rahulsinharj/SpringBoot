package com.springjdbc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springjdbc.entity.Student;
import com.springjdbc.service.StudentService;

@Component			// It's a must to make this class as component , taaki iska obj Spring ko mil sake , aur wo iske run method ko call kar sake 
public class StudentCommandRunner implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			Student s1 = new Student(105, "Rahul" , "Delhi1");
			Student s2 = new Student(106, "Vikas" , "Patna1");
			Student s3 = new Student(107, "Shubham" , "Gaya1");
			Student s4 = new Student(108, "Shashank" , "Bhopal1");
			
			studentService.insert(Arrays.asList(s1,s2,s3,s4));
			
			
			System.out.println("============Fetching Student records from DB :=============");
			List<Student> allStudents = studentService.getAllStudents();
			
			for(Student s : allStudents){
				System.out.println(s);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

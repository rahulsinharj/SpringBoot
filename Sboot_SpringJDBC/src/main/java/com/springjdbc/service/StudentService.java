package com.springjdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springjdbc.entity.Student;

@Service
public class StudentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public int insert(Student student) 
	{	
		// insert query
		String myquery = "insert into student(id,name,city) values(?,?,?) "; 
		int result = this.jdbcTemplate.update(myquery , student.getId(), student.getName(), student.getCity());

		System.out.println("Records inserted : " +result);
		return result;
	}
	
	@Transactional
	public void insert(List<Student> studentList)
	{
		for(Student stu : studentList) {
			System.out.println("Inserting Data for Student : "+stu.getName());
			
			String myquery = "insert into student(id,name,city) values(?,?,?) "; 
			int result = this.jdbcTemplate.update(myquery , stu.getId(), stu.getName(), stu.getCity());
		}
	}
	
/*	public List<Student> getAllStudents() 
	{
		System.out.println("Getting all students through anonymously implementing RowMapper");
		// Selecting multiple students
		String myquery = "select * from student";
		List<Student> students = this.jdbcTemplate.query(myquery, new RowMapper<Student>(){

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				return new Student(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			
		});  // here if want to put some parameter into myquery then we we can put them from our 3rd paramters as well.
		
		return students;
	}
*/	
	public List<Student> getAllStudents() 			
	{
		System.out.println("Getting all students through anonymously implementing RowMapper - By LAMBDA Expression");
		// Selecting multiple students
		String myquery = "select * from student";
		List<Student> studentList = this.jdbcTemplate.query(myquery, (rs,rowNum) -> new Student(rs.getInt(1),rs.getString(2),rs.getString(3)));
			
		return studentList;
	}
	
	/*
	  	RowMapper functional interface hame current C(R)UD READ-transaction me ResultSet ka obj de deta hai, jisse ki hum row ke parameters ko student ke setters ya contructor parameter me daal sake.  
	*/
	
}

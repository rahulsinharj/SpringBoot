package myform.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentForm {

	private String stuname;
	private String stuemail;
	private int sturoll;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date studob;
	
	private List<String> courses;
	private String gender;
	private String type;
	
	private Address address;
	
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStuemail() {
		return stuemail;
	}
	public void setStuemail(String stuemail) {
		this.stuemail = stuemail;
	}
	public int getSturoll() {
		return sturoll;
	}
	public void setSturoll(int sturoll) {
		this.sturoll = sturoll;
	}
	public Date getStudob() {
		return studob;
	}
	public void setStudob(Date studob) {
		this.studob = studob;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentForm [stuname= " + stuname + ", stuemail= " + stuemail + ", sturoll= " + sturoll + ", studob= "
				+ new SimpleDateFormat("dd/MM/yyyy").format(studob) + ", courses= " + courses + ", gender= " + gender + ", type= " + type + ", address= " + address
				+ "]";
	}
	
	
}

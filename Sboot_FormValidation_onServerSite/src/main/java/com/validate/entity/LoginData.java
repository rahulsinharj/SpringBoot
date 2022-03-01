package com.validate.entity;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginData {
	
	@NotBlank(message = "User name cannot be empty  !")
	@Size(min = 3 , max = 12 , message = "User name must be between 3-12 characters !")
	private String userName;
	
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Must be a valid email expression !")			// @Pattern  // 'message' is optional 
	private String email;
	
	@AssertTrue(message = "Must agree terms and conditions  !")							// Data will be accept -> when checkbox is marked {that means when "agreed" is true }
	private boolean agreed;				// For accepting license terms & conditions - agreement checkbox
	
	public LoginData(String userName, String email , boolean agreed) {
		super();
		this.userName = userName;
		this.email = email;
		this.agreed = agreed; 
	}
	public LoginData() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + ", agreed=" + agreed + "]";
	}
	
}

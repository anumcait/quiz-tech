package com.hr.employee.helper;

public class UserFoundException extends Exception{
	
	public UserFoundException() {
		super("User already Exists!! Try with another User");		
	}

	
	public UserFoundException(String msg) {
		super(msg);
		
	}

}

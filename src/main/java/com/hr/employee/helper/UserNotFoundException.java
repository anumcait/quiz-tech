package com.hr.employee.helper;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		super("User does not Exists!!Please verify Username");		
	}

	
	public UserNotFoundException(String msg) {
		super(msg);
		
	}

}

package com.hr.employee.service;

import java.util.Set;


import com.hr.employee.model.User;
import com.hr.employee.model.UserRole;

public interface UserService {
	
	//Creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	
	//get user by username
	public User getUser(String username);
	
	//delete user by userid
	public void delUser(Long userId);
	
	//update user by usrid
	public User updateUser(Long userId);
	
	
	
	

}

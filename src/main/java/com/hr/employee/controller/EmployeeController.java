package com.hr.employee.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.employee.model.Role;
import com.hr.employee.model.User;
import com.hr.employee.model.UserRole;
import com.hr.employee.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@GetMapping("/test")
	public String Test() {
		return "Welcome to backend api of examportal";
	}
	
	@PostMapping("/")
	
	public User createUser(@RequestBody User user) throws Exception{
		
		//password encode using bcryptpassword encoder
		
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		
		
		Set<UserRole> roles = new HashSet<>();
		
		Role role2 =new Role();
		role2.setRoleId(45L);
		role2.setRoleName("Normal");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role2);
		userRole.setUser(user);
		
		roles.add(userRole);	
		
		
		return this.userService.createUser(user,roles);
	
		
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		return this.userService.getUser(username);
	
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.delUser(userId);
	}
	
	
}

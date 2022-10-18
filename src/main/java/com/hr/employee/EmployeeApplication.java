package com.hr.employee;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hr.employee.helper.UserFoundException;
import com.hr.employee.model.Role;
import com.hr.employee.model.User;
import com.hr.employee.model.UserRole;
import com.hr.employee.service.UserService;


@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner{
	@Autowired
	UserService userService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting Code");
	
try {
		
		User user = new User();
		
		user.setFirstName("D");
		user.setLastName("Aliveni");
		user.setUsername("anumcait");
		user.setPassword(bcryptPasswordEncoder.encode("abc"));
		user.setEmail("anumcait@gmail.com");
		user.setProfile("default.png");
		
		Role role1 = new Role();
		role1.setRoleId(44L);
		role1.setRoleName("Admin");
		
		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		
		User user1 = this.userService.createUser(user,userRoleSet);
		System.out.println(user1.getUsername());
}catch(UserFoundException e){
	e.printStackTrace();
	
}
		
		
	}

}

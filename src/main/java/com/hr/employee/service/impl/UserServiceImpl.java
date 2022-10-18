package com.hr.employee.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hr.employee.helper.UserFoundException;
import com.hr.employee.model.User;
import com.hr.employee.model.UserRole;
import com.hr.employee.repo.RoleRepository;
import com.hr.employee.repo.UserRepository;
import com.hr.employee.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
public User createUser(User user, Set<UserRole> userRoles) throws Exception {
	user.setProfile("default.png");
	User local = this.userRepository.findByUsername(user.getUsername());
	if (local!=null)
	{
		System.out.println("User is already there!!");
		throw new UserFoundException();
	} else {
		//create user
		for(UserRole ur : userRoles) {
			roleRepository.save(ur.getRole());
		}
		
		user.getUserRoles().addAll(userRoles);
		local  = this.userRepository.save(user);
		
	}
	return local;
}
	
	
	
	
	//Get user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}
	
	//delete user by userid
	
	@Override
	public void delUser(Long userId) {
		// TODO Auto-generated method stub
	this.userRepository.deleteById(userId);	
	}
	
	@Override
	public User updateUser(Long userId) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
}

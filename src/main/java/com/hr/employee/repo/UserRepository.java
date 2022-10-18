package com.hr.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.employee.model.User;

public interface UserRepository extends JpaRepository<User,Long> 
{
	public User findByUsername(String username);
	
	

}

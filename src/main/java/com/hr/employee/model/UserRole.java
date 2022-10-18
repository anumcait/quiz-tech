package com.hr.employee.model;

import javax.persistence.*;


@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userRoleId;
	
	//Users Many to 1 relationship
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	@ManyToOne(fetch= FetchType.EAGER)
	
	private Role role;
	
	
	public UserRole() {
	}

	public UserRole(Long userRoleId, User user) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}

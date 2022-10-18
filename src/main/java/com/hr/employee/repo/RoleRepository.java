package com.hr.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.employee.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{

}

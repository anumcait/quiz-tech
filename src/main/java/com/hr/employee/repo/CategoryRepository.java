package com.hr.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.employee.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

package com.hr.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.employee.model.exam.Category;
import com.hr.employee.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	public List<Quiz> findBycategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category category, Boolean b);
	
	

}

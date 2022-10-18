package com.hr.employee.service;

import java.util.List;
import java.util.Set;

import com.hr.employee.model.exam.Category;
import com.hr.employee.model.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();

	public Quiz getQuizById(Long qId);
	
	public List<Quiz> getQuizzesByCategory(Category category);
	
	public List<Quiz> getActiveQuizzes();
	
	public List<Quiz> getQuizzesByCategoryAndActive(Category category);
	
	public void deleteQuiz(Long qId);
	
	

}

package com.hr.employee.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.employee.model.exam.Category;
import com.hr.employee.model.exam.Quiz;
import com.hr.employee.repo.QuizRepository;
import com.hr.employee.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private	QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {

		return quizRepository.save(quiz) ;
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		return new HashSet<>(quizRepository.findAll());
	}

	@Override
	public Quiz getQuizById(Long qId) {
		return quizRepository.findById(qId).get();
	}

	@Override
	public void deleteQuiz(Long qId) {
		quizRepository.deleteById(qId);
		
	}

@Override
public List<Quiz> getQuizzesByCategory(Category category) {
	// TODO Auto-generated method stub
	return this.quizRepository.findBycategory(category);
}
@Override
public List<Quiz> getActiveQuizzes() {

	return this.quizRepository.findByActive(true);
}

@Override
public List<Quiz> getQuizzesByCategoryAndActive(Category category) {
	return this.quizRepository.findByCategoryAndActive(category,true);
}
	


}

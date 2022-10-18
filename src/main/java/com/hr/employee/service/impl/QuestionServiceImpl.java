package com.hr.employee.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.employee.model.exam.Question;
import com.hr.employee.model.exam.Quiz;
import com.hr.employee.repo.QuestionRepository;
import com.hr.employee.repo.QuizRepository;
import com.hr.employee.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		
		return questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {

		return new HashSet<Question>(questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long qnId) {
		
		return questionRepository.findById(qnId).get();
	}

	@Override
	public Question getQuestionByQuiz(Quiz quiz) {

		return questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long qnId) {
		
		Question question = new Question();
		question.setQnId(qnId);
		
		questionRepository.delete(question);
	
	}

}

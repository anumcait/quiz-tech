package com.hr.employee.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.employee.model.exam.Question;
import com.hr.employee.model.exam.Quiz;
import com.hr.employee.service.QuestionService;
import com.hr.employee.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(questionService.addQuestion(question));
		
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(questionService.updateQuestion(question));
	}
	
	@GetMapping("/")
	public Set<Question> getQuestions(){
		return this.questionService.getQuestions();
	}
	
	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable("questionId") Long questionId) {
		
		return this.questionService.getQuestion(questionId);
		
	}
	
	@GetMapping("/quiz/{quizId}")
	
	public ResponseEntity<?> getQuistionByQuizId(@PathVariable("quizId") Long quizId) {
		
		Quiz quiz = this.quizService.getQuizById(quizId);
		
	Set<Question> questions = quiz.getQuestions();
		
		List<Question> list = new ArrayList<>(questions);
		
		int no_of_questions = Integer.parseInt(quiz.getNoOfQtns());
		
		if(list.size()>no_of_questions) {
			list = list.subList(0, no_of_questions+1);
		}
		
//		list.forEach((q)->{
//			q.setAnswer("");
//		});
		
		Collections.shuffle(list);
		
		return ResponseEntity.ok(list);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@DeleteMapping("/{questionId}")
	
	public void DeleteMapping(@PathVariable("questinId") Long questionId) {
		
			this.questionService.deleteQuestion(questionId);
	}
	
	
	
	
	
	
}

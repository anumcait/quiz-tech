package com.hr.employee.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.employee.model.exam.Category;
import com.hr.employee.model.exam.Quiz;
import com.hr.employee.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/add")
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return quizService.addQuiz(quiz);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes() {
		return ResponseEntity.ok(this.quizService.getQuizzes());
		
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable("quizId") Long quizId){
		return ResponseEntity.ok(quizService.getQuizById(quizId));

	}
	
	@GetMapping("/category/{catId}")
	public List<Quiz> getQuizzesByCategory(@PathVariable("catId") Long catId){
		Category category = new Category();
		category.setCid(catId);
		return quizService.getQuizzesByCategory(category);
	}
	
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes(){
		
		return quizService.getActiveQuizzes();
	}
	
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getQuizzesByCategoryAndActive(@PathVariable("cid") Long cid){
		Category c = new Category();
		c.setCid(cid);
		return quizService.getQuizzesByCategoryAndActive(c);
	}
	
	
	
	@PutMapping("/")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return quizService.updateQuiz(quiz);
	}
	
	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable("quizId") Long quizId) {
		quizService.deleteQuiz(quizId);
		
	}
	
	
	

}

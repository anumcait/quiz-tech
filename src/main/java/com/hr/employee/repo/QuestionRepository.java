package com.hr.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.employee.model.exam.Question;
import com.hr.employee.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Question findByQuiz(Quiz quiz);

}

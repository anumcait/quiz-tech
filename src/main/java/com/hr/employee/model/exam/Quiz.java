package com.hr.employee.model.exam;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long qid;
	
	private String name;
	private String description;
	private String maxMarks;
	private String noOfQtns;
	private boolean active=false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	@OneToMany(mappedBy="quiz" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	Set<Question> questions = new HashSet<>();
	
public Quiz() {
	// TODO Auto-generated constructor stub
}


public long getQid() {
	return qid;
}


public void setQid(long qid) {
	this.qid = qid;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getMaxMarks() {
	return maxMarks;
}


public void setMaxMarks(String maxMarks) {
	this.maxMarks = maxMarks;
}


public String getNoOfQtns() {
	return noOfQtns;
}


public void setNoOfQtns(String noOfQtns) {
	this.noOfQtns = noOfQtns;
}


public boolean isActive() {
	return active;
}


public void setActive(boolean active) {
	this.active = active;
}


public Category getCategory() {
	return category;
}


public void setCategory(Category category) {
	this.category = category;
}


public Set<Question> getQuestions() {
	return questions;
}


public void setQuestions(Set<Question> questions) {
	this.questions = questions;
}


	
	
	
	
}

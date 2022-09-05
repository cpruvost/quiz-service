package com.quizforevent.microservices.quizservice.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "V_QUIZ")
public class Quiz {

	@Id
	@SequenceGenerator(name="SEQ_GEN_QUIZ", sequenceName="seq_quiz", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN_QUIZ")
	private Integer Id;
	private String name;
	
	@Transient
	private String environment;
	
	@ManyToMany()
	@Fetch(FetchMode.JOIN)
	@JoinTable(name = "quizquestion", joinColumns = @JoinColumn(name = "quiz_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"))
	private Set<Question> questions = new HashSet<Question>();
	
	public Quiz() {
		super();
	}
	
	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "Quiz [Id=" + Id + ", name=" + name + ", environment=" + environment + ", questions=" + questions + "]";
	}
	
}

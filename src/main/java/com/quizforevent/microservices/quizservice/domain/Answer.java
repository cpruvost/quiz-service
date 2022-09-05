package com.quizforevent.microservices.quizservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "V_ANSWER")
public class Answer {
	
	@Id
	@SequenceGenerator(name="SEQ_GEN_ANSWER", sequenceName="seq_answer", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN_ANSWER")
	private Integer Id;
	private Integer question_id;
	private String text;
	
	public Answer() {
		super();
	}

	public Answer(Integer Id, Integer question_id, String text) {
		super();
		this.Id = Id;
		this.question_id = question_id;
		this.text = text;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Answer [Id=" + Id + ", question_id=" + question_id + ", text=" + text + "]";
	}

}

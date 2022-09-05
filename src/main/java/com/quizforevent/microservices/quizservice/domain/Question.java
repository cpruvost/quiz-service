package com.quizforevent.microservices.quizservice.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "V_QUESTION")
public class Question implements Serializable {
	
	private static final long serialVersionUID = 5333692081609424580L;
	
	public static String TYPE_OPEN="Ouverte";
	public static String TYPE_CLOSED="Fermée";
	
	@Id
	@SequenceGenerator(name="SEQ_GEN_QUESTION", sequenceName="seq_question", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN_QUESTION")
	private Integer Id;
	private String type;
	private String text;
	@JsonIgnore
	private Long open_answer;
	@JsonIgnore
	private String closed_answer;
	
	@OneToMany()
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="QUESTION_ID", referencedColumnName="ID")
	private Set<Answer> answers = new HashSet<Answer>();

	public Question() {
		super();
	}
	
	public Question(Integer Id, String type, String text, Long open_answer, String closed_answer) {
		super();
		this.Id = Id;
		this.type = type;
		this.text = text;
		this.open_answer = open_answer;
		this.closed_answer = closed_answer;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getOpen_answer() {
		return open_answer;
	}

	public void setOpen_answer(Long open_answer) {
		this.open_answer = open_answer;
	}

	public String getClosed_answer() {
		return closed_answer;
	}

	public void setClosed_answer(String closed_answer) {
		this.closed_answer = closed_answer;
	}
	
	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [Id=" + Id + ", type=" + type + ", text=" + text + ", open_answer=" + open_answer
				+ ", closed_answer=" + closed_answer + ", answers=" + answers.size() + "]";
	}

}

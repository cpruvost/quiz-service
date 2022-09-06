package com.quizforevent.microservices.quizservice.domain;

public class QuizAggregator {
	private int nbQuiz;
	private int nbQuestions;
	private String environment;
	
	public QuizAggregator(int nbQuiz, int nbQuestions, String environment) {
		super();
		this.nbQuiz = nbQuiz;
		this.nbQuestions = nbQuestions;
		this.environment = environment;
	}

	public QuizAggregator() {
		super();
	}

	public int getNbQuiz() {
		return nbQuiz;
	}

	public void setNbQuiz(int nbQuiz) {
		this.nbQuiz = nbQuiz;
	}

	public int getNbQuestions() {
		return nbQuestions;
	}

	public void setNbQuestions(int nbQuestions) {
		this.nbQuestions = nbQuestions;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "QuizResume [nbQuiz=" + nbQuiz + ", nbQuestions=" + nbQuestions + ", environment=" + environment + "]";
	}

}

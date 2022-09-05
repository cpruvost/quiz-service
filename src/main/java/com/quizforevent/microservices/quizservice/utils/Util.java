package com.quizforevent.microservices.quizservice.utils;

public class Util {
	private String edition;

	public Util(){}
	
	public Util(String edition) {
		super();
		this.edition = edition;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Util [edition=" + edition + "]";
	}
}

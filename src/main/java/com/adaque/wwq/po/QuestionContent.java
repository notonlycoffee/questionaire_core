package com.adaque.wwq.po;

import java.io.Serializable;

public class QuestionContent implements Serializable {
	private static final long serialVersionUID = 5153218097126559426L;
	
	private String id;
	private String question_content;
	private Question question;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	

}

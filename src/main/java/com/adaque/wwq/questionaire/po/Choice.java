package com.adaque.wwq.questionaire.po;

import java.io.Serializable;

public class Choice implements Serializable{
	private static final long serialVersionUID = 8907896383806841922L;
	private String id;
	private String question;
	private String select;
	private int question_type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public int getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(int question_type) {
		this.question_type = question_type;
	}
	
}

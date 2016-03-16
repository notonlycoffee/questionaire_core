package com.adaque.wwq.questionaire.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exam implements Serializable{
	private static final long serialVersionUID = 6935577605122546562L;
	
	private String id;
	private String type;
	private List<Answer> answerList = new ArrayList();
	private List<Question> questionList = new ArrayList();
	private List<Choice> choiceList = new ArrayList();
	private String name;
	private String author;
	private String exam_identity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getExam_identity() {
		return exam_identity;
	}
	public void setExam_identity(String exam_identity) {
		this.exam_identity = exam_identity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public List<Choice> getChoiceList() {
		return choiceList;
	}
	public void setChoiceList(List<Choice> choiceList) {
		this.choiceList = choiceList;
	}
	
	
	
	
}


package com.adaque.wwq.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable{
	private static final long serialVersionUID = -6003221473686532360L;
	private String id;
	private String question_name;
	private List<QuestionContent> questionContentList = new ArrayList();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public List<QuestionContent> getQuestionContentList() {
		return questionContentList;
	}
	public void setQuestionContentList(List<QuestionContent> questionContentList) {
		this.questionContentList = questionContentList;
	}
	
	
}

package com.adaque.wwq.questionaire.model.easyuimodel;

import java.util.ArrayList;
import java.util.List;

public class StuQuestion {
	
	private List<String []> multiList = new ArrayList();  //多选题
	private List<String> question1;
	private List<String> question2;
	private List<String> question3;
	private List<String> question4;
	private List<String> question5;
	
	private List<String> question_id1;
	private List<String> question_id2;
	private List<String> question_id3;
	private List<String> question_id4;
	private List<String> question_id5;
	
	
	
	
	public List<String> getQuestion_id1() {
		return question_id1;
	}
	public void setQuestion_id1(List<String> question_id1) {
		this.question_id1 = question_id1;
	}
	public List<String> getQuestion_id2() {
		return question_id2;
	}
	public void setQuestion_id2(List<String> question_id2) {
		this.question_id2 = question_id2;
	}
	public List<String> getQuestion_id3() {
		return question_id3;
	}
	public void setQuestion_id3(List<String> question_id3) {
		this.question_id3 = question_id3;
	}
	public List<String> getQuestion_id4() {
		return question_id4;
	}
	public void setQuestion_id4(List<String> question_id4) {
		this.question_id4 = question_id4;
	}
	public List<String> getQuestion_id5() {
		return question_id5;
	}
	public void setQuestion_id5(List<String> question_id5) {
		this.question_id5 = question_id5;
	}
	
	
	public List<String[]> getMultiList() {
		return multiList;
	}
	public void setMultiList(List<String[]> multiList) {
		this.multiList = multiList;
	}
	public List<String> getQuestion1() {
		return question1;
	}
	public void setQuestion1(List<String> question1) {
		this.question1 = question1;
	}
	public List<String> getQuestion2() {
		return question2;
	}
	public void setQuestion2(List<String> question2) {
		this.question2 = question2;
	}
	public List<String> getQuestion3() {
		return question3;
	}
	public void setQuestion3(List<String> question3) {
		this.question3 = question3;
	}
	public List<String> getQuestion4() {
		return question4;
	}
	public void setQuestion4(List<String> question4) {
		this.question4 = question4;
	}
	public List<String> getQuestion5() {
		return question5;
	}
	public void setQuestion5(List<String> question5) {
		this.question5 = question5;
	}
	
	
	
}

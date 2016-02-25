package com.adaque.wwq.questionaire.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class College implements Serializable  {
	private static final long serialVersionUID = -3310485139543785992L;
	private String id;
	private String num;
	private String name;
	private List<Student> studentList = new ArrayList();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}

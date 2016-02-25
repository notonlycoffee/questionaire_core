package com.adaque.wwq.questionaire.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchoolClass implements Serializable  {
	private static final long serialVersionUID = 6635333893183445897L;
	
	private String id;
	private String code;
	private List<Student> studentList = new ArrayList();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}

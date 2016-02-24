package com.adaque.wwq.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Major implements Serializable {
	private static final long serialVersionUID = -4365029176321550566L;
	
	
	private String id;
	private String code;
	private String name;
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

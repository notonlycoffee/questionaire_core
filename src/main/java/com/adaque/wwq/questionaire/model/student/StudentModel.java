package com.adaque.wwq.questionaire.model.student;

import java.io.Serializable;

public class StudentModel implements Serializable {
	private static final long serialVersionUID = 3376665373103457524L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

package com.adaque.wwq.questionaire.model.teacher;

import java.io.Serializable;

public class TeacherModel implements Serializable {
	private static final long serialVersionUID = -2251296394218120738L;
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

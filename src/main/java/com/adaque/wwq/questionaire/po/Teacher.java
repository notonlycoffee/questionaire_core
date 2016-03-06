package com.adaque.wwq.questionaire.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Teacher implements Serializable {
	private static final long serialVersionUID = 7698805235268237982L;
	
	private String id;
	private String num;
	private String name;
	private String password;
	private String sex;
	int type;
	private List<Role> roleList = new ArrayList();
	private List<Exam_plan> exam_planList = new ArrayList();
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public List<Exam_plan> getExam_planList() {
		return exam_planList;
	}
	public void setExam_planList(List<Exam_plan> exam_planList) {
		this.exam_planList = exam_planList;
	}
	
	
}

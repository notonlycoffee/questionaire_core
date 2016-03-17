package com.adaque.wwq.questionaire.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exam_plan implements Serializable{
	private static final long serialVersionUID = 8776011871343734030L;
	
	private String id;
	private Date opentime;
	private Date closetime;     //试卷关闭时间
	private Date publishtime;   //试卷推出时间
	private Teacher teacher;   //改卷老师
	private String teacher_id;
	private Exam exam;   
	private String exam_identity;   //试卷编号
	private String name;    //试卷名称
	private String teacher_name;
	private String exam_id;
	private String closetime_str;
	private String publishtime_str;
	
	
	public String getClosetime_str() {
		return closetime_str;
	}
	public void setClosetime_str(String closetime_str) {
		this.closetime_str = closetime_str;
	}
	public String getPublishtime_str() {
		return publishtime_str;
	}
	public void setPublishtime_str(String publishtime_str) {
		this.publishtime_str = publishtime_str;
	}
	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getOpentime() {
		return opentime;
	}
	public void setOpentime(Date opentime) {
		this.opentime = opentime;
	}
	public Date getClosetime() {
		return closetime;
	}
	public void setClosetime(Date closetime) {
		this.closetime = closetime;
	}
	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public String getExam_identity() {
		return exam_identity;
	}
	public void setExam_identity(String exam_identity) {
		this.exam_identity = exam_identity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	
	
	
	
	
	
}

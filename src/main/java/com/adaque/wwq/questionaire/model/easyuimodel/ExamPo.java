package com.adaque.wwq.questionaire.model.easyuimodel;

public class ExamPo {
	
	private String exam_id;
	private String choice_id;
	private String question_id;
	private String status;
	private String plan_id;
	private String question_type;
	
	
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	public String getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public String getChoice_id() {
		return choice_id;
	}
	public void setChoice_id(String choice_id) {
		this.choice_id = choice_id;
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	
}

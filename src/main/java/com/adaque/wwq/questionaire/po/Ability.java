package com.adaque.wwq.questionaire.po;

import java.io.Serializable;

public class Ability implements Serializable {
	private static final long serialVersionUID = -7173533151480806248L;
	
	private String id;
	private String score;
	private String major_ability;
	private String foreign_language;
	private String other_ysl;
	private String reward;
	private String rgpzxy;
	private String sxjktj;
	private String gtjjnl;
	private String wthdnl;
	private String other_rsl;
	private Student student;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getMajor_ability() {
		return major_ability;
	}
	public void setMajor_ability(String major_ability) {
		this.major_ability = major_ability;
	}
	public String getForeign_language() {
		return foreign_language;
	}
	public void setForeign_language(String foreign_language) {
		this.foreign_language = foreign_language;
	}
	public String getOther_ysl() {
		return other_ysl;
	}
	public void setOther_ysl(String other_ysl) {
		this.other_ysl = other_ysl;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getRgpzxy() {
		return rgpzxy;
	}
	public void setRgpzxy(String rgpzxy) {
		this.rgpzxy = rgpzxy;
	}
	public String getSxjktj() {
		return sxjktj;
	}
	public void setSxjktj(String sxjktj) {
		this.sxjktj = sxjktj;
	}
	public String getGtjjnl() {
		return gtjjnl;
	}
	public void setGtjjnl(String gtjjnl) {
		this.gtjjnl = gtjjnl;
	}
	public String getWthdnl() {
		return wthdnl;
	}
	public void setWthdnl(String wthdnl) {
		this.wthdnl = wthdnl;
	}
	public String getOther_rsl() {
		return other_rsl;
	}
	public void setOther_rsl(String other_rsl) {
		this.other_rsl = other_rsl;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}

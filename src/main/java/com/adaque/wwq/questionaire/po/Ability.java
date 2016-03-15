package com.adaque.wwq.questionaire.po;

import java.io.Serializable;

public class Ability implements Serializable {
	private static final long serialVersionUID = -7173533151480806248L;
	
	private String id;
	private String score;  //学业成绩
	private String major_ability;  //专业技能能力
	private String foreign_language;//外语能力
	private String other_ysl;//其他能力(硬实力)
	private String reward;//获奖情况
	private String rgpzxy;//人格品质修养
	private String sxjktj;//身心健康调节
	private String gtjjnl;//沟通交际能力
	private String wthdnl;//文体活动能力
	private String other_rsl;//其他能力(软实力)
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

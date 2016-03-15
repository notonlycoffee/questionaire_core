package com.adaque.wwq.questionaire.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student implements Serializable {
	private static final long serialVersionUID = -57713854303179894L;
	private String id;
	private String num;
	private String name;
	private String password;
	private College college;
	private Major major;
	private SchoolClass schoolClass;
	private String sex;
	private Date birthday;
	private String qq;
	private String majorstr;
	private String mobile;
	private String address;
	private String people;
	private String family_work;
	private String hoby;
	private String advantage;
	private String specialty;
	private String shortcoming;
	private String photo;
	private String rich_poor;
	private String family_education;
	private String ability_id;
	private Date study_time;
	private Ability ability;
	private List<Message> messageList = new ArrayList();
	private List<Role> roleList = new ArrayList();
	private List<Answer> answerList = new ArrayList();
	
	public String getAbility_id() {
		return ability_id;
	}
	public void setAbility_id(String ability_id) {
		this.ability_id = ability_id;
	}
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public List<Message> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
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
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMajorstr() {
		return majorstr;
	}
	public void setMajorstr(String majorstr) {
		this.majorstr = majorstr;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getFamily_work() {
		return family_work;
	}
	public void setFamily_work(String family_work) {
		this.family_work = family_work;
	}
	public String getHoby() {
		return hoby;
	}
	public void setHoby(String hoby) {
		this.hoby = hoby;
	}
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getShortcoming() {
		return shortcoming;
	}
	public void setShortcoming(String shortcoming) {
		this.shortcoming = shortcoming;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRich_poor() {
		return rich_poor;
	}
	public void setRich_poor(String rich_poor) {
		this.rich_poor = rich_poor;
	}
	public String getFamily_education() {
		return family_education;
	}
	public void setFamily_education(String family_education) {
		this.family_education = family_education;
	}
	public Date getStudy_time() {
		return study_time;
	}
	public void setStudy_time(Date study_time) {
		this.study_time = study_time;
	}
	public Ability getAbility() {
		return ability;
	}
	public void setAbility(Ability ability) {
		this.ability = ability;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}

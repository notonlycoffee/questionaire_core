package com.adaque.wwq.questionaire.service.teacher.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaque.wwq.questionaire.dao.teacher.TeacherMapper;
import com.adaque.wwq.questionaire.model.teacher.TeacherModel;
import com.adaque.wwq.questionaire.po.Teacher;
import com.adaque.wwq.questionaire.service.teacher.TeacherService;


public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	public Teacher getTeacherById(String id) {
		Teacher teacher = teacherMapper.getTeacherById(id);
		return teacher;
	}

	public Teacher getTeacherByNameAndPassword(TeacherModel teacherModel) {
		Teacher teacher = teacherMapper.getTeacherByNameAndPassword(teacherModel);
		return teacher;
	}

	public List<Teacher> getAllTeacher() {
		List<Teacher> teacherList = teacherMapper.getAllTeacher();
		return teacherList;
	}

	public void updateTeacherById(String id) {
		teacherMapper.updateTeacherById(id);
	}

	public void addTeacher(Teacher teacher) {
		teacherMapper.addTeacher(teacher);
	}

	public void deleteTeacherById(String id) {
		teacherMapper.deleteTeacherById(id);
	}
	
}
 
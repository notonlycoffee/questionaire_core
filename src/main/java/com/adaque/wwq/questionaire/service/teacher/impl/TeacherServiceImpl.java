package com.adaque.wwq.questionaire.service.teacher.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaque.wwq.questionaire.dao.teacher.TeacherMapper;
import com.adaque.wwq.questionaire.model.easyuimodel.UserForm;
import com.adaque.wwq.questionaire.model.easyuimodel.UserRole;
import com.adaque.wwq.questionaire.model.teacher.TeacherModel;
import com.adaque.wwq.questionaire.po.Teacher;
import com.adaque.wwq.questionaire.service.teacher.TeacherService;

@Service
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

	public String getTeacherRoleId(String teacherId) {
		return teacherMapper.getTeacherRoleId(teacherId);
	}

	public List<Teacher> getTeacherByNumAndName(UserForm userForm) {
		return teacherMapper.getTeacherByNumAndName(userForm);
	}

	@Override
	public void addTeacherRole(UserRole userRole) {
		teacherMapper.addTeacherRole(userRole);
	}

	@Override
	public Teacher getTeacherByNum(String num) {
		return teacherMapper.getTeacherByNum(num);
	}

	@Override
	public void updatePasswordById(UserForm userForm) {
		teacherMapper.updatePasswordById(userForm);
	}
	
}
 
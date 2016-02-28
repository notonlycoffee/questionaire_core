package com.adaque.wwq.questionaire.service.teacher;

import java.util.List;

import com.adaque.wwq.questionaire.model.teacher.TeacherModel;
import com.adaque.wwq.questionaire.po.Teacher;

public interface TeacherService {
	public Teacher getTeacherById(String id);

	public Teacher getTeacherByNameAndPassword(TeacherModel teacherModel);

	public List<Teacher> getAllTeacher();

	public void updateTeacherById(String id);

	public void addTeacher(Teacher teacher);

	public void deleteTeacherById(String id);
}

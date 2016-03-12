package com.adaque.wwq.questionaire.service.student;

import java.util.List;

import com.adaque.wwq.questionaire.model.easyuimodel.UserForm;
import com.adaque.wwq.questionaire.model.easyuimodel.UserRole;
import com.adaque.wwq.questionaire.model.student.StudentModel;
import com.adaque.wwq.questionaire.po.Student;

public interface StudentServie {
	
public Student getStudentById(String id);
	
	public Student getStduentByNameAndPwd(StudentModel studentModel);
	
	public List<Student> getAllStudent();
	
	public void deleteStudentById(String id);
	
	public void updateStudentById(Student student);
	
	public void addFormStudent(Student student);
	
	public List<Student> getStudentByNumAndName(UserForm userForm);
	
	public void addStudentRole(UserRole userRole);
	
	public Student getStudentByNum(String num);
	
}

package com.adaque.wwq.questionaire.service.student.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaque.wwq.questionaire.dao.student.StudentMapper;
import com.adaque.wwq.questionaire.model.student.StudentModel;
import com.adaque.wwq.questionaire.po.Student;
import com.adaque.wwq.questionaire.service.student.StudentServie;

public class StudentServieImpl implements StudentServie {

	@Autowired
	private StudentMapper studentMapper;
	
	public Student getStudentById(String id) {
		Student student = studentMapper.getStudentById(id);
		return student;
	}

	public Student getStduentByNameAndPwd(StudentModel studentModel) {
		Student student = studentMapper.getStduentByNameAndPwd(studentModel);
		return student;
	}

	public List<Student> getAllStudent() {
		List<Student> studentList = studentMapper.getAllStudent();
		return studentList;
	}

	public void deleteStudentById(String id) {
		studentMapper.deleteStudentById(id);
	}

	public void updateStudentById(Student student) {
		studentMapper.updateStudentById(student);
	}

	public void addStudent(Student student) {
		studentMapper.addStudent(student);
	}
	
	
	
}

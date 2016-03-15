package com.adaque.wwq.questionaire.web.student;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adaque.wwq.questionaire.po.Ability;
import com.adaque.wwq.questionaire.po.Student;
import com.adaque.wwq.questionaire.service.student.StudentServie;

@Controller
@RequestMapping("studentoperation")
public class StudentController {

	@Autowired
	private StudentServie studentService;
	
	
	@RequestMapping("studentinfoedit.xhtml")
	public String studentinfoedit() {
		return "/student/studentinfoedit";
	}
	
	@RequestMapping("studentinfoall.xhtml")
	public String studentinfoall(Student student,Ability ability,HttpServletRequest request) {
		
		ability.setId(student.getAbility_id());
		student.setAbility(ability);
		ability.setStudent(student);
		
		//先添加能力表,再添加学生信息
		
		studentService.updateAbilityByAbilityId(ability);
		
		studentService.updateStudentInfoById(student);
		
		
		Student s = studentService.getStudentById(student.getId());
		Ability a = studentService.getStudentAbilityByAbilityId(ability.getId());
		request.getSession().setAttribute("user", s);
		request.getSession().setAttribute("ability", a);
		
		return "/student/studentinfoedit";
	}
	
}

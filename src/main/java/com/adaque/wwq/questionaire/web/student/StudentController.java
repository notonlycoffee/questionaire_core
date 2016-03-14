package com.adaque.wwq.questionaire.web.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adaque.wwq.questionaire.po.Student;

@Controller
@RequestMapping("studentoperation")
public class StudentController {

	
	
	@RequestMapping("studentinfoedit.xhtml")
	public String studentinfoedit() {
		return "/student/studentinfoedit";
	}
	
	@RequestMapping("studentinfoall.xhtml")
	public void studentinfoall(Student student) {
		
		System.out.println();
	}
	
}

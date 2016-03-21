package com.adaque.wwq.questionaire.web.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/studentexam")
public class StudentExamController {

	@RequestMapping("checkExamPlan.xhtml")
	public String checkExamPlan() {
		return "/student/stucheckexamplanpage";
	}
	
	@RequestMapping("getOpenExam.xhtml")
	public String getOpenExam(String exam_id) {
		
		return "/student/stuexamfix";
	}
}
 
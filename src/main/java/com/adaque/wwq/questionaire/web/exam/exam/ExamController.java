package com.adaque.wwq.questionaire.web.exam.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.po.ResultMessage;
import com.adaque.wwq.questionaire.service.exam.ExamService;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	private ExamService examService;

	@RequestMapping("/addExamPage.xhtml")
	public void addExam() {
		
		System.out.println();
	}
	
	@RequestMapping("/checkExam.xhtml")
	public String checkExam() {
		return "/exam/checkexampage";
	}
	
	@RequestMapping("addExamPlan.xhtml")
	public void addExamPlan() {
		
	}
	
	@RequestMapping("checkExamPlan.xhtml")
	public void checkExamPlan() {
		
	}
	
	@RequestMapping("getAllExam.xhtml")
	public @ResponseBody List getAllExam() {
		
		List list = examService.getAllExam();
		
		return list;
		
	}
	
	@RequestMapping("deleteexam.xhtml")
	public @ResponseBody ResultMessage deleteexam(String id) {
		ResultMessage message = new ResultMessage();
		
		examService.deleteExamById(id);
		message.setMessage("删除成功");
		
		return message;
	}
	
	@RequestMapping("checkDetailExam.xhtml")
	public String checkDetailExam() {
		return "/exam/createexampage";
	}
	
}

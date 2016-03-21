package com.adaque.wwq.questionaire.web.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adaque.wwq.questionaire.model.easyuimodel.AnswerVo;
import com.adaque.wwq.questionaire.service.exam.ExamService;

@Controller
@RequestMapping("/studentexam")
public class StudentExamController {
	
	@Autowired
	private ExamService examService;

	@RequestMapping("checkExamPlan.xhtml")
	public String checkExamPlan() {
		return "/student/stucheckexamplanpage";
	}
	
	@RequestMapping("getOpenExam.xhtml")
	public String getOpenExam(String exam_id) {
		
		List<AnswerVo> choiceList = examService.getStudentFixAnswerChoice(exam_id);  //获取试卷id对应的所有选择题
		List<AnswerVo> contentList = examService.getStudentFixAnswerContent(exam_id);//获取试卷id对应的所有解答题
		
		return "/student/stuexamfix";
	}
}
 
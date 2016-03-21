package com.adaque.wwq.questionaire.web.exam.answer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.model.easyuimodel.AnswerVo;
import com.adaque.wwq.questionaire.service.exam.ExamService;

@Controller
@RequestMapping("answer")
public class AnswerController {
	
	@Autowired
	private ExamService examService;
	
	@RequestMapping("checkstudentexampage.xhtml")
	public String checkstudentexampage(String id,ModelMap model) {
		model.addAttribute("exam_id", id);
		return "/answer/studentanswerpage";
	}
	
	@RequestMapping("getAnswerStudents.xhtml")
	public @ResponseBody List getAnswerStudents(String id) {
		List<AnswerVo> voList = examService.getAnswerStudents(id);
		return voList;
	}
	

	@RequestMapping("getStudentAnswerTable.xhtml")
	public @ResponseBody List<AnswerVo> getStudentAnswerTable(AnswerVo vo) {
		List<AnswerVo> voList = examService.getStudentAnswer(vo);
		System.out.println();
		return voList;
	}
	
	
	@RequestMapping("getStudentAnswerTableQuestion.xhtml")
	public @ResponseBody List getStudentAnswerTableQuestion(AnswerVo vo) {
		List list = examService.getStudentAnswerQuestions(vo);
		System.out.println();
			
		return list;
	}
	
}

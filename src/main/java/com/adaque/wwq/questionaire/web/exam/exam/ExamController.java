package com.adaque.wwq.questionaire.web.exam.exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.model.easyuimodel.ExamPo;
import com.adaque.wwq.questionaire.po.Choice;
import com.adaque.wwq.questionaire.po.Exam;
import com.adaque.wwq.questionaire.po.Exam_plan;
import com.adaque.wwq.questionaire.po.Question;
import com.adaque.wwq.questionaire.po.ResultMessage;
import com.adaque.wwq.questionaire.po.Teacher;
import com.adaque.wwq.questionaire.service.exam.ChoiceService;
import com.adaque.wwq.questionaire.service.exam.ExamService;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private ChoiceService choiceService;

	@RequestMapping("/addExamPage.xhtml")
	public void addExam() {
		
		System.out.println();
	}
	
	@RequestMapping("/checkExam.xhtml")
	public String checkExam() {
		return "/exam/checkexampage";
	}
	

	
	@RequestMapping("getAllExam.xhtml")
	public @ResponseBody List getAllExam() {
		
		List list = examService.getAllExam();
		
		return list;
		
	}
	
	@RequestMapping("deleteexam.xhtml")
	public @ResponseBody ResultMessage deleteexam(String id) {
		ResultMessage message = new ResultMessage();
		
		examService.deleteChoice2Exam(id);
		examService.deleteQuestion2Exam(id);
		examService.deleteExamById(id);
		
		message.setMessage("删除成功");
		
		return message;
	}
	
	@RequestMapping("checkDetailExam.xhtml")
	public String checkDetailExam() {
		return "/exam/createexampage";
	}
	
	@RequestMapping("getAllChoice.xhtml")
	public @ResponseBody List getAllChoice() {
		//0代表单选选择题类型
		List<Choice> list = choiceService.getChoiceByQuestionType("0");
		return list;
	}
	
	@RequestMapping("getAllMulChoice.xhtml")
	public @ResponseBody List getAllMulChoice() {
		//1代表多选选择题
		List<Choice> list = choiceService.getChoiceByQuestionType("1");
		return list;
	}
	
	@RequestMapping("addExam.xhtml")
	public @ResponseBody ResultMessage addExam(Exam exam, String single_ids,String mult_ids) {
		
		exam.setId(UUID.randomUUID().toString());
		examService.addExam(exam);
		
		String single_id[] = single_ids.split(",");
		String mult_id[] = mult_ids.split(",");
		
		for(String id : single_id) {
			ExamPo po = new ExamPo();
			po.setChoice_id(id);
			po.setExam_id(exam.getId());
			examService.addExamQuestionTable(po);
		}
		
		System.out.println();
		
		for(String id : mult_id) {
			ExamPo po = new ExamPo();
			po.setChoice_id(id);
			po.setExam_id(exam.getId());
			examService.addExamQuestionTable(po);
		}
		
		List<Question> questionList = examService.getAllQuestion();
		for(Question q : questionList) {
			ExamPo po = new ExamPo();
			po.setExam_id(exam.getId());
			po.setQuestion_id(q.getId());
			examService.addQuestion2Exam(po);
		}
		
		ResultMessage message = new ResultMessage();
		message.setMessage("添加成功");
		
		return message;
	}
	
	
	
	@RequestMapping("addExamPlan.xhtml")
	public void addExamPlan() {
		
	}
	
	@RequestMapping("checkExamPlan.xhtml")
	public String checkExamPlan() {
		return "/exam/checkexamplan";
	}
	
	@RequestMapping("getAllExamPlan.xhtml")
	public @ResponseBody List<Exam_plan> getAllExamPlan() {
		System.out.println();
		List<Exam_plan> exam_planList = examService.getAllExamPlan();
		
		for(Exam_plan p : exam_planList) {
			p.setExam_identity(p.getExam().getExam_identity());
			p.setName(p.getExam().getName());
			p.setTeacher_name(p.getTeacher().getName());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
			p.setClosetime_str(df.format(p.getClosetime()));
			p.setPublishtime_str(df.format(p.getPublishtime()));
		}
		
		System.out.println();
		return exam_planList;
	}
	
	@RequestMapping("createexamplanpage.xhtml")
	public String createexamplanpage() {
		
		return "/exam/createexamplanpage";
	}
	
	
	@RequestMapping("addExamPlanLast.xhtml")
	public @ResponseBody ResultMessage addExamPlanLast(String publishtimetime,String closetimetime, @RequestParam("id")String exam_id,HttpServletRequest request) {
		ResultMessage message = new ResultMessage();
		
		Exam_plan examPlan = new Exam_plan();
		examPlan.setId(UUID.randomUUID().toString());
		examPlan.setClosetime_str(closetimetime);
		examPlan.setPublishtime_str(publishtimetime);
		Teacher t = (Teacher)(request.getSession().getAttribute("user"));
		examPlan.setTeacher_id(t.getId());
		examPlan.setStatus("关闭");
		examPlan.setExam_id(exam_id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date closetime = df.parse(closetimetime);
			Date publishtime = df.parse(publishtimetime);
			examPlan.setClosetime(closetime);
			examPlan.setPublishtime(publishtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println();
		
		examService.addExamPlan(examPlan);
		
		message.setMessage("添加成功");
		return message;
	}
	
	@RequestMapping("deleteExamPlan.xhtml")
	public @ResponseBody ResultMessage deleteExamPlan(String id) {
		System.out.println();
		examService.deleteExamPlanById(id);
		ResultMessage message = new ResultMessage();
		message.setMessage("删除成功");
		return message;
	}
	
	@RequestMapping("changeStatusExamPlan.xhtml")
	public @ResponseBody ResultMessage changeStatusExamPlan(String status,String plan_id) {
		ExamPo po = new ExamPo();
		po.setPlan_id(plan_id);
		if("开放".equals(status)) {
			po.setStatus("关闭");
		} else {
			po.setStatus("开放");
		}
		
		examService.updateExamPlanStatus(po);
		
		ResultMessage message = new ResultMessage();
		message.setMessage("修改成功");
		return message;
	}
	
	@RequestMapping("getDetailExamPage.xhtml")
	public String getDetailExamPage(String id,ModelMap model) {
		model.addAttribute("exam_id", id);
		return "/exam/examdetail";
	}
	
}

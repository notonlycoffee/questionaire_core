package com.adaque.wwq.questionaire.web.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adaque.wwq.questionaire.model.easyuimodel.AnswerVo;
import com.adaque.wwq.questionaire.model.easyuimodel.ExamPo;
import com.adaque.wwq.questionaire.model.easyuimodel.StuQuestion;
import com.adaque.wwq.questionaire.po.Student;
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
	public String getOpenExam(String exam_id,ModelMap model) {
		String single = "0";
		String multi = "1";
		ExamPo po = new ExamPo();
		po.setExam_id(exam_id);
		po.setQuestion_type(single);
		List<AnswerVo> choiceList = examService.getStudentFixAnswerChoice(po);  //获取试卷id对应的所有单项选择题
		for(AnswerVo vo: choiceList) {
			String select = vo.getSelect();
			String [] selects = select.split("##");
			for(String sestr : selects) {
				String num = sestr.substring(0, 1);
				String quse = sestr.substring(1);
				String result = num+".   "+quse;
				vo.getSelectList().add(result);
			}
		}
		model.addAttribute("choiceList", choiceList);
		
		po.setQuestion_type("1");
		List<AnswerVo> multiList = examService.getStudentFixAnswerChoice(po);
		for(AnswerVo vo: multiList) {
			String select = vo.getSelect();
			String [] selects = select.split("##");
			for(String sestr : selects) {
				String num = sestr.substring(0, 1);
				String quse = sestr.substring(1);
				String result = num+".   "+quse;
				vo.getSelectList().add(result);
			}
		}
		
		model.addAttribute("multiList", multiList);
		
		List<AnswerVo> contentList = examService.getStudentFixAnswerContent(exam_id);//获取试卷id对应的所有解答题
		
		Map<String,Object> contentMap = new HashMap<String,Object>();
		
		List<String> strList = examService.getAllAnswerQuestion();
		
		for(String name : strList) {
			contentMap.put(name+"##", new ArrayList());
		}
		
		for(AnswerVo vo: contentList) {
			String name = vo.getQuestion_name();
			List list = (List) contentMap.get(name+"##");
			list.add(vo.getQuestion_content()+"##"+vo.getContent_id());
		}
		
		model.addAttribute("contentMap", contentMap);
		
		return "/student/stuexamfix";
	}
	
	@RequestMapping("getStudentAnswerHot.xhtml")
	public String getStudentAnswerHot(AnswerVo vo,StuQuestion questionList,HttpServletRequest request) {
		Student t = (Student) request.getSession().getAttribute("user");
		String exam_id = vo.getExam_id();
		//vo 存放选择题答案内容      questionList存放
		List<String> singlechoiceL = vo.getSelectList();
		for(String re : singlechoiceL) {
			String [] rearray = re.split("##");
			AnswerVo revo = new AnswerVo();
			revo.setChoice_id(rearray[0]);
			revo.setAnswer(rearray[1]);
			revo.setStudent_id(t.getId());
			revo.setExam_id(exam_id);
			revo.setId(UUID.randomUUID().toString());
			examService.addStudentAnswer(revo);
		}
		
		List<String []> multiList = questionList.getMultiList();
		
		for(String [] remul: multiList) {
			String multi_id = remul[0].split("##")[0];
			String answer = "";
			for(String resu : remul) {
				answer += resu.split("##")[1] + "##";
			}
			AnswerVo vomul = new AnswerVo();
			vomul.setId(UUID.randomUUID().toString());
			vomul.setExam_id(exam_id);
			vomul.setStudent_id(t.getId());
			vomul.setAnswer(answer);
			vomul.setChoice_id(multi_id);
			examService.addStudentAnswer(vomul);
		}
		
		List<String> questionstr=new ArrayList();
		for(int i = 0 ; i < (questionstr=questionList.getQuestion1()).size();i++) {
			String questioncontent = questionstr.get(i);
			String question_id = questionList.getQuestion_id1().get(i);
			AnswerVo questionvo = new AnswerVo();
			questionvo.setId(UUID.randomUUID().toString());
			questionvo.setExam_id(exam_id);
			questionvo.setStudent_id(t.getId());
			questionvo.setChoice_id(question_id);
			questionvo.setAnswer(questioncontent);
			examService.addStudentAnswer(questionvo);
		}
		
		for(int i = 0 ; i < (questionstr=questionList.getQuestion2()).size();i++) {
			String questioncontent = questionstr.get(i);
			String question_id = questionList.getQuestion_id2().get(i);
			AnswerVo questionvo = new AnswerVo();
			questionvo.setId(UUID.randomUUID().toString());
			questionvo.setExam_id(exam_id);
			questionvo.setStudent_id(t.getId());
			questionvo.setChoice_id(question_id);
			questionvo.setAnswer(questioncontent);
			examService.addStudentAnswer(questionvo);
		}
		
		for(int i = 0 ; i < (questionstr=questionList.getQuestion3()).size();i++) {
			String questioncontent = questionstr.get(i);
			String question_id = questionList.getQuestion_id3().get(i);
			AnswerVo questionvo = new AnswerVo();
			questionvo.setId(UUID.randomUUID().toString());
			questionvo.setExam_id(exam_id);
			questionvo.setStudent_id(t.getId());
			questionvo.setChoice_id(question_id);
			questionvo.setAnswer(questioncontent);
			examService.addStudentAnswer(questionvo);
		}
		
		for(int i = 0 ; i < (questionstr=questionList.getQuestion4()).size();i++) {
			String questioncontent = questionstr.get(i);
			String question_id = questionList.getQuestion_id4().get(i);
			AnswerVo questionvo = new AnswerVo();
			questionvo.setId(UUID.randomUUID().toString());
			questionvo.setExam_id(exam_id);
			questionvo.setStudent_id(t.getId());
			questionvo.setChoice_id(question_id);
			questionvo.setAnswer(questioncontent);
			examService.addStudentAnswer(questionvo);
		}
		for(int i = 0 ; i < (questionstr=questionList.getQuestion5()).size();i++) {
			String questioncontent = questionstr.get(i);
			String question_id = questionList.getQuestion_id5().get(i);
			AnswerVo questionvo = new AnswerVo();
			questionvo.setId(UUID.randomUUID().toString());
			questionvo.setExam_id(exam_id);
			questionvo.setStudent_id(t.getId());
			questionvo.setChoice_id(question_id);
			questionvo.setAnswer(questioncontent);
			examService.addStudentAnswer(questionvo);
		}
		
		
		
		request.setAttribute("message", "试卷填写完成,请等待分析结果");
		return "success";
	}
	
	
}
 
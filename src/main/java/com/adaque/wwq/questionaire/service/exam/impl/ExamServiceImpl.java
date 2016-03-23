package com.adaque.wwq.questionaire.service.exam.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaque.wwq.questionaire.dao.exam.ExamMapper;
import com.adaque.wwq.questionaire.model.easyuimodel.AnswerVo;
import com.adaque.wwq.questionaire.model.easyuimodel.ExamPo;
import com.adaque.wwq.questionaire.model.easyuimodel.QuestionVo;
import com.adaque.wwq.questionaire.po.Choice;
import com.adaque.wwq.questionaire.po.Exam;
import com.adaque.wwq.questionaire.po.Exam_plan;
import com.adaque.wwq.questionaire.po.Question;
import com.adaque.wwq.questionaire.service.exam.ExamService;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamMapper examMapper;
	@Override
	public List<Exam> getAllExam() {
		List<Exam> examList = examMapper.getAllExam();
		return examList;
	}
	@Override
	public void deleteExamById(String id) {
		examMapper.deleteExamById(id);
	}
	@Override
	public void addExam(Exam exam) {
		examMapper.addExam(exam);
	}
	@Override
	public void addExamQuestionTable(ExamPo examPo) {
		examMapper.addExamQuestionTable(examPo);
	}
	@Override
	public void addQuestion2Exam(ExamPo examPo) {
		examMapper.addQuestion2Exam(examPo);
	}
	
	@Override
	public List<Question> getAllQuestion() {
		return examMapper.getAllQuestion();
	}
	@Override
	public void deleteQuestion2Exam(String exam_id) {
		examMapper.deleteQuestion2Exam(exam_id);
	}
	@Override
	public void deleteChoice2Exam(String exam_id) {
		examMapper.deleteChoice2Exam(exam_id);
	}
	@Override
	public List<Exam_plan> getAllExamPlan() {
		return examMapper.getAllExamPlan();
	}
	@Override
	public void addExamPlan(Exam_plan examPlan) {
		examMapper.addExamPlan(examPlan);
	}
	@Override
	public void deleteExamPlanById(String id) {
		examMapper.deleteExamPlanById(id);
	}
	@Override
	public void updateExamPlanStatus(ExamPo po) {
		examMapper.updateExamPlanStatus(po);
		
	}
	@Override
	public List<Choice> getExamDetailChoice(String id) {
		return examMapper.getExamDetailChoice(id);
	}
	@Override
	public List<QuestionVo> getExamDetailQuestion(String id) {
		return examMapper.getExamDetailQuestion(id);
	}
	
	@Override
	public List<AnswerVo> getAnswerStudents(String id) {
		List list = examMapper.getAnswerStudents(id);
		return list;
	}
	@Override
	public List<AnswerVo> getStudentAnswer(AnswerVo vo) {
		return examMapper.getStudentAnswer(vo);
	}
	@Override
	public List<AnswerVo> getStudentAnswerQuestions(AnswerVo vo) {
		return examMapper.getStudentAnswerQuestions(vo);
	}
	@Override
	public List<Exam_plan> getAllExamPlanOpen() {
		List<Exam_plan> list = examMapper.getAllExamPlanOpen();
		return list;
	}
	@Override
	public List<AnswerVo> getStudentFixAnswerChoice(ExamPo po) {
		List<AnswerVo> voList = examMapper.getStudentFixAnswerChoice(po);
		return voList;
	}
	@Override
	public List<AnswerVo> getStudentFixAnswerContent(String id) {
		List<AnswerVo> voList = examMapper.getStudentFixAnswerContent(id);
		return voList;
	}
	@Override
	public List<String> getAllAnswerQuestion() {
		return examMapper.getAllAnswerQuestion();
	}
	@Override
	public void addStudentAnswer(AnswerVo vo) {
		examMapper.addStudentAnswer(vo);
	}

}

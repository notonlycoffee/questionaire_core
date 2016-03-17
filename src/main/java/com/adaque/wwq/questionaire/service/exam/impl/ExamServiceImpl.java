package com.adaque.wwq.questionaire.service.exam.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaque.wwq.questionaire.dao.exam.ExamMapper;
import com.adaque.wwq.questionaire.model.easyuimodel.ExamPo;
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

}

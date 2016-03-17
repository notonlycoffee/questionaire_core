package com.adaque.wwq.questionaire.service.exam;

import java.util.List;

import com.adaque.wwq.questionaire.model.easyuimodel.ExamPo;
import com.adaque.wwq.questionaire.po.Exam;
import com.adaque.wwq.questionaire.po.Exam_plan;
import com.adaque.wwq.questionaire.po.Question;

public interface ExamService {
	public List<Exam> getAllExam();

	public void deleteExamById(String id);

	public void addExam(Exam exam);

	public void addExamQuestionTable(ExamPo examPo);
	
	public void addQuestion2Exam(ExamPo examPo);
	
	public List<Question> getAllQuestion();
	
	public void deleteQuestion2Exam(String exam_id);
	
	public void deleteChoice2Exam(String exam_id);
	
	public List<Exam_plan> getAllExamPlan();
}

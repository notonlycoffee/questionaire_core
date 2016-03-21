package com.adaque.wwq.questionaire.dao.exam;

import java.util.List;

import com.adaque.wwq.questionaire.model.easyuimodel.AnswerVo;
import com.adaque.wwq.questionaire.model.easyuimodel.ExamPo;
import com.adaque.wwq.questionaire.model.easyuimodel.QuestionVo;
import com.adaque.wwq.questionaire.po.Choice;
import com.adaque.wwq.questionaire.po.Exam;
import com.adaque.wwq.questionaire.po.Exam_plan;
import com.adaque.wwq.questionaire.po.Question;

public interface ExamMapper {

	public List<Exam> getAllExam();

	public void deleteExamById(String id);

	public void addExam(Exam exam);

	public void addExamQuestionTable(ExamPo examPo);

	public void addQuestion2Exam(ExamPo examPo);

	public List<Question> getAllQuestion();

	public void deleteQuestion2Exam(String exam_id);

	public void deleteChoice2Exam(String exam_id);

	public List<Exam_plan> getAllExamPlan();

	public void addExamPlan(Exam_plan examPlan);

	public void deleteExamPlanById(String id);

	public void updateExamPlanStatus(ExamPo po);

	public List<Choice> getExamDetailChoice(String id);

	public List<QuestionVo> getExamDetailQuestion(String id);
	
	public List<AnswerVo> getStudentAnswer(AnswerVo vo);
	
	public List<AnswerVo> getAnswerStudents(String id);
	
	public List<AnswerVo> getStudentAnswerQuestions(AnswerVo vo);
	
	public List<Exam_plan> getAllExamPlanOpen();
	
	public List<AnswerVo> getStudentFixAnswerChoice(String id);
	
	public List<AnswerVo> getStudentFixAnswerContent(String id);
}

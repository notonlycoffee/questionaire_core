package com.adaque.wwq.questionaire.dao.exam;

import java.util.List;

import com.adaque.wwq.questionaire.po.Exam;

public interface ExamMapper {
	
	public List<Exam> getAllExam();
	
	public void deleteExamById(String id);

}

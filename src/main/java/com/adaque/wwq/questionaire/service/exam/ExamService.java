package com.adaque.wwq.questionaire.service.exam;

import java.util.List;

import com.adaque.wwq.questionaire.po.Exam;

public interface ExamService {
	public List<Exam> getAllExam();
	public void deleteExamById(String id);
}

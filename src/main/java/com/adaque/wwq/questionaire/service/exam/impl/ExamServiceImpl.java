package com.adaque.wwq.questionaire.service.exam.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaque.wwq.questionaire.dao.exam.ExamMapper;
import com.adaque.wwq.questionaire.po.Exam;
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

}

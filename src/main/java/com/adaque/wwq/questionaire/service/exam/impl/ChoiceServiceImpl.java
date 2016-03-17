package com.adaque.wwq.questionaire.service.exam.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaque.wwq.questionaire.dao.exam.ChoiceMapper;
import com.adaque.wwq.questionaire.po.Choice;
import com.adaque.wwq.questionaire.service.exam.ChoiceService;

@Service
public class ChoiceServiceImpl implements ChoiceService {

	@Autowired
	private ChoiceMapper choiceMapper;
	
	@Override
	public void addChoice(Choice choice) {
		choiceMapper.addChoice(choice);
	}

	@Override
	public List<Choice> getAllChoice() {
		List<Choice> choiceList = choiceMapper.getAllChoice();
		return choiceList;
	}

	@Override
	public void deleteChoiceById(String id) {
		choiceMapper.deleteChoiceById(id);
	}

	@Override
	public List<Choice> getChoiceByQuestionType(String type) {
		return choiceMapper.getChoiceByQuestionType(type);
	}

}

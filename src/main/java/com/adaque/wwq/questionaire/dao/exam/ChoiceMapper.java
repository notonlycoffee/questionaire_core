package com.adaque.wwq.questionaire.dao.exam;

import java.util.List;

import com.adaque.wwq.questionaire.po.Choice;

public interface ChoiceMapper {

	public void addChoice(Choice choice);
	
	public List<Choice> getAllChoice();
	
	public void deleteChoiceById(String id);
	
}

package com.adaque.wwq.questionaire.service.exam;

import java.util.List;

import com.adaque.wwq.questionaire.po.Choice;

public interface ChoiceService {
	
	public void addChoice(Choice choice);
	
	public List<Choice> getAllChoice();
	
	public void deleteChoiceById(String id);

}

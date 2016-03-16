package com.adaque.wwq.questionaire.web.exam.choice;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.po.Choice;
import com.adaque.wwq.questionaire.po.ResultMessage;
import com.adaque.wwq.questionaire.service.exam.ChoiceService;

@Controller
@RequestMapping("/choice")
public class ChoiceController {
	@Autowired
	private ChoiceService choiceService;

	@RequestMapping("addchoice.xhtml")
	public String addchoice() {
		return "/exam/addchoicepage";
	}
	
	@RequestMapping("checkchoice.xhtml")
	public String checkchoice() {
		return "/exam/checkchoicepage";
	}
	
	@RequestMapping("addChoice.xhtml")
	public @ResponseBody ResultMessage addChoice(Choice choice) {
		ResultMessage message = new ResultMessage();
		
		choice.setId(UUID.randomUUID().toString());
		
		choiceService.addChoice(choice);
		
		message.setMessage("添加成功");
		
		return message;
	}
	
	@RequestMapping("getAllChoice.xhtml")
	public @ResponseBody List getAllChoice() {
		
		List<Choice> choiceList = choiceService.getAllChoice();
		
		return choiceList;
	}
	
	
	@RequestMapping("deleteChoice.xhtml")
	public @ResponseBody ResultMessage deleteChoice(String id) {
		choiceService.deleteChoiceById(id);
		ResultMessage message = new ResultMessage();
		message.setMessage("删除成功");
		return message;
	}
	
	
}

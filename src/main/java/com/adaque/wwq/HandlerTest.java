package com.adaque.wwq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HandlerTest {

	@RequestMapping(value="/queryone.xhtml")
	public String qq(ModelMap model) throws Exception {
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("ffff");
		
		
		model.addAttribute("list", list);
		return "one";
	}
	

}

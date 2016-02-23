package com.adaque.wwq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adaque.wwq.po.User;
import com.adaque.wwq.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="getUser.xhtml")
	public String getUser(ModelMap modelMap) {
		User user = userService.getUserById(4);
		System.out.println();
		modelMap.addObject("user", user);
		return "getuser";
	}
	
}

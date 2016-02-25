package com.adaque.wwq.webkit.web.action;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexAction {
	
	
	
	
	@RequestMapping(value="gotologin.xhtml")
	public String gotologin() {
		return "/login";
	}
	
	@RequestMapping(value="login.xhtml")
	public String login(String username,String password) {
		
		
		
		return null;
	}
}

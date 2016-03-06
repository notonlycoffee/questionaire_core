package com.adaque.wwq.questionaire.web.privilege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adaque.wwq.questionaire.service.privilege.PrivilegeService;


@Controller
public class PrivilegeController {
	
	@Autowired
	private PrivilegeService privilegeService;
	
	
	@RequestMapping(value="/usermanage.xhtml")
	public String usermanage() {
		return "/privilege/usermanage";
	}
	
	@RequestMapping(value="/rolemanage.xhtml")
	public String rolemanage() {
		return "/privilege/rolemanage";
	}
	
	@RequestMapping(value="/privilegemanage.xhtml")
	public String privilegemanage() {
		return "/privilege/privilegemanage";
	}
	
	@RequestMapping(value="/resourcemanage.xhtml")
	public String resourcemanage() {
		return "/privilege/resourcemanage";
	}
	
	
	
	
}

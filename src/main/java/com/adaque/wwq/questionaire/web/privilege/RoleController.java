package com.adaque.wwq.questionaire.web.privilege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.model.easyuimodel.UserRole;
import com.adaque.wwq.questionaire.po.ResultMessage;
import com.adaque.wwq.questionaire.service.privilege.RoleService;

@Controller
@RequestMapping("/rolemanager")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("assignRole.xhtml")
	public @ResponseBody ResultMessage assignRole(String role_id,String re_ids) {
		
		ResultMessage message = new ResultMessage();
		
		roleService.deleteRoleResource(Integer.valueOf(role_id));
		
		UserRole userRole = new UserRole();
		userRole.setRole_id(Integer.valueOf(role_id));
		
		String re_id [] = re_ids.split(",");
		for(String resource_id: re_id) {
			userRole.setResource_id(Integer.valueOf(resource_id));
			roleService.addRoleResourceByBothId(userRole);
		}
		message.setMessage("授权成功");
		return message;
	}
}

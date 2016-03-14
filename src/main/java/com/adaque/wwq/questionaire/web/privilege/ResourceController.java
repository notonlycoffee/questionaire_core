package com.adaque.wwq.questionaire.web.privilege;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.model.easyuimodel.Attribute;
import com.adaque.wwq.questionaire.model.easyuimodel.MenuTreeModel;
import com.adaque.wwq.questionaire.po.Privilege;
import com.adaque.wwq.questionaire.po.Resource;
import com.adaque.wwq.questionaire.po.ResultMessage;
import com.adaque.wwq.questionaire.service.privilege.PrivilegeService;
import com.adaque.wwq.questionaire.service.privilege.ResourceService;

@Controller
@RequestMapping("/resourcemanage")
public class ResourceController {

	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("resourcetree.xhtml")
	public @ResponseBody List resourcetree() {
		
		List<Privilege> pri_list = privilegeService.getAllPrivilege();
		List<MenuTreeModel> menu_list = new ArrayList();
		
		for(Privilege p : pri_list) {
			List<MenuTreeModel> re_menu_list = privilegeService.getPrivilegeResourceById(p.getId());
			for(MenuTreeModel rem : re_menu_list) {
				rem.setIconCls("");
				Attribute a = new Attribute();
				a.setUrl(rem.getUrl());
				rem.setAttributes(a);
			}
			MenuTreeModel pri_menu = new MenuTreeModel();
			pri_menu.setId(p.getId());
			pri_menu.setText(p.getName());
			pri_menu.getChildren().addAll(re_menu_list);
			menu_list.add(pri_menu);
			
		}
		
		return menu_list;
	}
	
	
	@RequestMapping("getResourceTable.xhtml")
	public @ResponseBody List getResourceTable(String resourceid) {
		
		Resource r = resourceService.getResourceById(Integer.valueOf(resourceid));
		List<Resource> re_list = new ArrayList();
		re_list.add(r);
		
		
		return re_list;
		
	}
	
	@RequestMapping("addResourcePage.xhtml")
	public String addResourcePage() {
		return "/privilege/addresourcepage";
	}
	
	@RequestMapping("getAllPrivilege.xhtml")
	public @ResponseBody List getAllPrivilege() {
		List list = new ArrayList();
		List<Privilege> pre_list = privilegeService.getAllPrivilege();
		for(Privilege p : pre_list) {
			Map map = new HashMap();
			map.put("id", p.getId());
			map.put("text",p.getName());
			list.add(map);
		}
		return list;
	}
	
	
	@RequestMapping("addresourcesub.xhtml")
	public void addresourcesub(String name,String path,String privilege_id) {
		Resource resource = new Resource();
		int id = resourceService.getMaxid();
		resource.setId((id+1));
		resource.setName(name);
		resource.setPath(path);
		Privilege privilege = new Privilege();
		privilege.setId(Integer.valueOf(privilege_id));
		resource.setFunction(privilege);
		System.out.println();
		resourceService.addResource(resource);
		System.out.println();
		
	}
	
	
	@RequestMapping("deleteResource.xhtml")
	public @ResponseBody ResultMessage deleteResource(String id) {
		ResultMessage message = new ResultMessage();
		Resource resource = resourceService.getResourceById(Integer.valueOf(id));
		if(resource == null) {
			message.setMessage("删除的资源不存在");
		} else {
			resourceService.deleteResourceById(resource.getId());
			message.setMessage("删除成功");
		}
		return message;
	}
	
	
//	@RequestMapping("updateResource.xhtml")
	
}

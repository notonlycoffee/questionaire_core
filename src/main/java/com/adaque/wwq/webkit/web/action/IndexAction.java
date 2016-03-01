package com.adaque.wwq.webkit.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.model.easyuimodel.Attribute;
import com.adaque.wwq.questionaire.model.easyuimodel.MenuTreeModel;
import com.adaque.wwq.questionaire.model.privilege.QueryPrivilegeModel;
import com.adaque.wwq.questionaire.model.student.StudentModel;
import com.adaque.wwq.questionaire.model.teacher.TeacherModel;
import com.adaque.wwq.questionaire.po.Role;
import com.adaque.wwq.questionaire.po.Student;
import com.adaque.wwq.questionaire.po.Teacher;
import com.adaque.wwq.questionaire.service.privilege.RoleService;
import com.adaque.wwq.questionaire.service.student.StudentServie;
import com.adaque.wwq.questionaire.service.teacher.TeacherService;


@Controller
public class IndexAction {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private StudentServie studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value="include.xhtml")
	public String include() {
		return "include";
	}
	
	@RequestMapping(value="gotologin.xhtml")
	public String gotologin() {
		
		return "/login";
	}
	
	@RequestMapping(value="login.xhtml")
	public String login(String username,String password,String userroleid,HttpServletRequest request) {
		
		if(StringUtils.isNotBlank(userroleid)) {
			Role role = roleService.getRoleById(Integer.valueOf(userroleid));
			
			if(role.getName().equals("学生")) {
				StudentModel studentModel = new StudentModel();
				studentModel.setUsername(username);
				studentModel.setPassword(password);
				Student student = studentService.getStduentByNameAndPwd(studentModel);
				student.getRoleList().add(role);
				if(student == null) {
					request.setAttribute("errormessage", "帐户名或密码出错,请重新输入");
					return "/login";
				} else {
					request.getSession().setAttribute("user", student);
					request.setAttribute("ctx", request.getContextPath());
					return "index";
				}
			} else {
				TeacherModel teacherModel = new TeacherModel();
				teacherModel.setPassword(password);
				teacherModel.setUsername(username);
				Teacher teacher = teacherService.getTeacherByNameAndPassword(teacherModel);
				teacher.getRoleList().add(role);
				if(teacher == null) {
					request.setAttribute("errormessage", "帐户名或密码出错,请重新输入");
					return "/login";
				} else {
					String roleId = teacherService.getTeacherRoleId(teacher.getId());
					if(userroleid.equals(roleId)) {
						request.getSession().setAttribute("user", teacher);
						request.setAttribute("ctx", request.getContextPath());
						return "index";
					} else {
						request.setAttribute("errormessage", "帐户名或密码出错,请重新输入");
						return "/login";
					}
					
					
				}
				
			}
		}
		
		return null;
	}
	
	@RequestMapping(value="getAllRole.xhtml")
	public @ResponseBody List getAllRole(String username) {
		List<Role> roleList = roleService.getAllRole();
		
		List list = new ArrayList();
		for(Role r : roleList) {
			int id=r.getId();
			String name = r.getName();
			HashMap map = new HashMap();
			map.put("id", id);
			map.put("text",name);
			list.add(map);
		}
		
		return list;
		
		
	}


	@RequestMapping(value="north.xhtml")
	public String north(){
		System.out.println();
		return "layout/north";
	}
	
	@RequestMapping(value="south.xhtml")
	public String south(){
		return "layout/south";
	}
	
	@RequestMapping(value="west.xhtml")
	public String west() {
		return "layout/west";
	}
	
	@RequestMapping(value="getTree.xhtml")
	public @ResponseBody List getTree(ModelMap modelMap,HttpServletRequest request){
		
		List<Role> roleList = null;
		
		Object obj = request.getSession(false).getAttribute("user");
		if(obj instanceof Teacher) {
			Teacher t = (Teacher) obj;
			roleList = t.getRoleList();
		} else if(obj instanceof Student) {
			Student s = (Student) obj;
			roleList = s.getRoleList();
		}
		
		
		List<MenuTreeModel> pri_List = null;
		for(Role role: roleList) {
			pri_List = roleService.getUserRoleMenu(role.getId());
			System.out.println();
			for(MenuTreeModel pri: pri_List) {
				List<MenuTreeModel> resour_list = roleService.getUserRoleLeave(pri.getId());
				for(MenuTreeModel model : resour_list) {
					Attribute attribute = new Attribute();
					attribute.setUrl(model.getUrl());
					model.setAttributes(attribute);
				}
				pri.getChildren().addAll(resour_list);
				System.out.println();
			}
		}
		
		System.out.println();
		//roleService.getUserRoleMenu(roleid);
		
		return pri_List;
	}


}

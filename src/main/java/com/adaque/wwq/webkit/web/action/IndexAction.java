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
import com.adaque.wwq.questionaire.model.easyuimodel.UserRole;
import com.adaque.wwq.questionaire.model.student.StudentModel;
import com.adaque.wwq.questionaire.model.teacher.TeacherModel;
import com.adaque.wwq.questionaire.po.Role;
import com.adaque.wwq.questionaire.po.Student;
import com.adaque.wwq.questionaire.po.Teacher;
import com.adaque.wwq.questionaire.service.privilege.ResourceService;
import com.adaque.wwq.questionaire.service.privilege.RoleService;
import com.adaque.wwq.questionaire.service.student.StudentServie;
import com.adaque.wwq.questionaire.service.teacher.TeacherService;
import com.adaque.wwq.questionaire.utils.MD5Util;


@Controller
public class IndexAction {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private StudentServie studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value="include.xhtml")
	public String include() {
		return "include";
	}
	
	@RequestMapping(value="gotologin.xhtml")
	public String gotologin(HttpServletRequest request) {
		if(request.getSession().getAttribute("user") != null) {
			return "index";
		} else {
			return "/login";
		}
		
	}
	
	@RequestMapping(value="login.xhtml")
	public String login(String username,String password,String userroleid,HttpServletRequest request) {
		
		Object obj = request.getSession().getAttribute("user");
		if(obj != null) {
			return "index";
		} else if(obj == null && username == null) {
			return "login";
		}
		
		if(StringUtils.isNotBlank(userroleid)) {
			Role role = roleService.getRoleById(Integer.valueOf(userroleid));
			
			if(role.getName().equals("学生")) {
				StudentModel studentModel = new StudentModel();
				studentModel.setUsername(username);
				password = MD5Util.string2MD5(password);  //设置密码加密
				studentModel.setPassword(password);
				Student student = studentService.getStduentByNameAndPwd(studentModel);
				if(student == null) {
					request.setAttribute("errormessage", "帐户名或密码出错,请重新输入");
					return "/login";
				} else {
					student.getRoleList().add(role);
					request.getSession().setAttribute("user", student);
					return "/index";
				}
			} else {
				TeacherModel teacherModel = new TeacherModel();
				password = MD5Util.string2MD5(password);  //设置密码加密
				teacherModel.setPassword(password);
				teacherModel.setUsername(username);
				Teacher teacher = teacherService.getTeacherByNameAndPassword(teacherModel);
				if(teacher == null) {
					request.setAttribute("errormessage", "帐户名或密码出错,请重新输入");
					return "/login";
				} else {
					String roleId = teacherService.getTeacherRoleId(teacher.getId());
					teacher.getRoleList().add(role);
					if(userroleid.equals(roleId)) {
						request.getSession().setAttribute("user", teacher);
						return "index";
					} else {
						request.setAttribute("errormessage", "帐户名或密码出错,请重新输入");
						return "/login";
					}
					
					
				}
				
			}
		} else {
			request.setAttribute("errormessage", "帐户名或密码出错,请重新输入");
			return "/login";
		}
		
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
		
		List<MenuTreeModel> pri_List = new ArrayList();
		
		Role role = roleList.get(0);
		
		
		

		List<MenuTreeModel> resourceList = roleService.getRoleResourceByRoleId(Integer.valueOf(role.getId())); //获取所有的资源
		for(MenuTreeModel remcheck: resourceList) {
			remcheck.setChecked(true);
			Attribute a = new Attribute();
			a.setUrl(remcheck.getUrl());
			remcheck.setAttributes(a);
		}
		List<MenuTreeModel> privilegeList = new ArrayList(); //总的目录 
		
		for(MenuTreeModel rem : resourceList) { //遍历所有的资源文件,获得权限目录,将资源添加到权限目录中,最后返回整个权限目录
			
			UserRole userRole = new UserRole();
			userRole.setResource_id(rem.getId());
			userRole.setPrivilege_id(rem.getC_id());
			MenuTreeModel privilege_menu = resourceService.getPrivilegeByResourceId(userRole);
			
			if(privilegeList.contains(privilege_menu)) {
				//当前的list已经拥有这个权限目录,则直接将该资源加入到这个权限目录下面
				for(MenuTreeModel pri_m: privilegeList) {
					if(pri_m.equals(privilege_menu)) {
						pri_m.getChildren().add(rem);
					}
				}
			} else {
				//当前list没有这个权限目录,则先将该资源加入到权限目录,再将权限目录加入到list中
				privilege_menu.getChildren().add(rem);
				privilegeList.add(privilege_menu);
				
			}
		}
		
		
		
		return privilegeList;
	}
	
	@RequestMapping(value="logout.xhtml")
	public String logout(HttpServletRequest request) {
		Object obj = request.getSession(false).getAttribute("user");
		if(obj != null) {
			request.getSession(false).removeAttribute("user");
		}
		return "redirect:/";
	}

}

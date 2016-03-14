package com.adaque.wwq.questionaire.web.privilege;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.model.easyuimodel.Attribute;
import com.adaque.wwq.questionaire.model.easyuimodel.EasyUIDataGradOutputModel;
import com.adaque.wwq.questionaire.model.easyuimodel.MenuTreeModel;
import com.adaque.wwq.questionaire.model.easyuimodel.UserForm;
import com.adaque.wwq.questionaire.model.easyuimodel.UserRole;
import com.adaque.wwq.questionaire.po.Privilege;
import com.adaque.wwq.questionaire.po.ResultMessage;
import com.adaque.wwq.questionaire.po.Role;
import com.adaque.wwq.questionaire.po.Student;
import com.adaque.wwq.questionaire.po.Teacher;
import com.adaque.wwq.questionaire.service.privilege.PrivilegeService;
import com.adaque.wwq.questionaire.service.privilege.ResourceService;
import com.adaque.wwq.questionaire.service.privilege.RoleService;
import com.adaque.wwq.questionaire.service.student.StudentServie;
import com.adaque.wwq.questionaire.service.teacher.TeacherService;
import com.adaque.wwq.questionaire.utils.MD5Util;


@Controller
@RequestMapping(value="/usermanage")
public class UserController {

	@Autowired
	private StudentServie studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value="getUser.xhtml")
	public @ResponseBody EasyUIDataGradOutputModel getUser(UserForm userForm) {
		
		EasyUIDataGradOutputModel model = new EasyUIDataGradOutputModel();
		if(!StringUtils.isNotBlank(userForm.getNum()) && !StringUtils.isNotBlank(userForm.getName())) {
			List<Student> studentList = studentService.getAllStudent();
			List<Teacher> teacherList = teacherService.getAllTeacher();
			List allList = new ArrayList();
			allList.addAll(studentList);
			allList.addAll(teacherList);
			model.getRows().addAll(allList);
		} else if(StringUtils.isNotBlank(userForm.getNum()) && !StringUtils.isNotBlank(userForm.getName())) {
			//学号或者工号不为空,但是姓名为空
			if(userForm.getNum().length() == 4) {
				//号码是4位的代表为工号,查询教师表
				List teacherList = teacherService.getTeacherByNumAndName(userForm);
				model.getRows().addAll(teacherList);
			} else {
				//号码不是4为,代表是学号,查询学生表
				List studentList = studentService.getStudentByNumAndName(userForm);
				model.getRows().addAll(studentList);
				
			}
		} else if(!StringUtils.isNotBlank(userForm.getNum()) && StringUtils.isNotBlank(userForm.getName())) {
			//姓名不为空但是学号或者工号为空
			List teacherList = teacherService.getTeacherByNumAndName(userForm);
			List studentList = studentService.getStudentByNumAndName(userForm);
			List allList = new ArrayList();
			allList.addAll(teacherList);
			allList.addAll(studentList);
			model.getRows().addAll(allList);
		} else if(StringUtils.isNotBlank(userForm.getNum()) && StringUtils.isNotBlank(userForm.getName())) {
			//姓名和工号或者学号不为空
			if(userForm.getNum().length() == 4) {
				List teacherList = teacherService.getTeacherByNumAndName(userForm);
				model.getRows().addAll(teacherList);
			} else if(userForm.getNum().length() > 4) {
				List studentList = studentService.getStudentByNumAndName(userForm);
				model.getRows().addAll(studentList);
			}
		}
		
		System.out.println();
		
		return model;
	}
	
	@RequestMapping(value="/addUser.xhtml")
	public @ResponseBody ResultMessage toAdd(UserForm userForm) {
		ResultMessage message = new ResultMessage();
		String num = userForm.getNum();
		if(num.length() == 4&&!userForm.getType().equals("学生")) {
			//工号/教师
			List<Teacher> teacherList = teacherService.getTeacherByNumAndName(userForm);
			Teacher already_teacher = teacherService.getTeacherByNum(userForm.getNum());
			if(teacherList.size()>0) {
				//说明添加的用户已经存在
				message.setMessage("您添加的用户已经存在");
			} else if(already_teacher != null){
				message.setMessage("您添加的工号已经存在");
			} else {
				//添加的用户不存在
			Teacher t = new Teacher();
			t.setName(userForm.getName());
			t.setNum(userForm.getNum());
			t.setPassword(MD5Util.string2MD5(userForm.getPassword()));
			t.setSex(userForm.getSex());
			t.setId(UUID.randomUUID().toString());
			switch(userForm.getType()) {
			case "任课教师":t.setType(0);break;
			case "普通教师":t.setType(1);break;
			case "管理员":t.setType(2);break;
			}
			teacherService.addTeacher(t);
			Role role = roleService.getRoleByName(userForm.getType());
			
			UserRole userRole = new UserRole();
			userRole.setUser_id(t.getId());
			userRole.setRole_id(role.getId());
			teacherService.addTeacherRole(userRole);
			
			message.setMessage("添加成功");
			}
		} else if(num.length()==10&&userForm.getType().equals("学生")) {
			//学号/学生
			List<Student> studentList = studentService.getStudentByNumAndName(userForm);
			Student already_student = studentService.getStudentByNum(userForm.getNum());
			if(studentList.size() > 0) {
				//学生已经存在
				message.setMessage("您添加的用户已经存在");
			} else if(already_student != null) {
				message.setMessage("您添加的学号已经存在");
			} else {
				Student s = new Student();
				s.setName(userForm.getName());
				s.setNum(userForm.getNum());
				s.setPassword(MD5Util.string2MD5(userForm.getPassword()));
				s.setSex(userForm.getSex());
				s.setId(UUID.randomUUID().toString());
				studentService.addFormStudent(s);
				Role role = roleService.getRoleByName(userForm.getType());
				UserRole userRole = new UserRole();
				userRole.setUser_id(s.getId());
				userRole.setRole_id(role.getId());
				studentService.addStudentRole(userRole);
				message.setMessage("添加成功");
			}
			
		}
		return message;
	}
	
	@RequestMapping(value="/assignRole.xhtml")
	public String assignRole() {
		
		
		return "/privilege/allofrole";
	}
	
	@RequestMapping(value="/allPrivilege.xhtml")
	public String allPrivilege() {
		return "/privilege/allprivilege";
	}
	
	@RequestMapping("getAllRoleDialog.xhtml")
	public @ResponseBody EasyUIDataGradOutputModel getAllRoleDialog() {
		List roleList = roleService.getAllRole();
		EasyUIDataGradOutputModel model = new EasyUIDataGradOutputModel();
		model.getRows().addAll(roleList);
		return model;
	}
	
	
	@RequestMapping("getRolePrivilege2assign.xhtml")
	public @ResponseBody List getRolePrivilege2assign(String id) {
		
//		List<MenuTreeModel> resourceList = roleService.getRoleResourceByRoleId(Integer.valueOf(id)); //获取所有的资源
//		for(MenuTreeModel remcheck: resourceList) {
//			remcheck.setChecked(true);
//		}
//		List<MenuTreeModel> privilegeList = new ArrayList(); //总的目录 
//		
//		for(MenuTreeModel rem : resourceList) { //遍历所有的资源文件,获得权限目录,将资源添加到权限目录中,最后返回整个权限目录
//			
//			UserRole userRole = new UserRole();
//			userRole.setResource_id(rem.getId());
//			userRole.setPrivilege_id(rem.getC_id());
//			MenuTreeModel privilege_menu = resourceService.getPrivilegeByResourceId(userRole);
//			
//			if(privilegeList.contains(privilege_menu)) {
//				//当前的list已经拥有这个权限目录,则直接将该资源加入到这个权限目录下面
//				for(MenuTreeModel pri_m: privilegeList) {
//					if(pri_m.equals(privilege_menu)) {
//						pri_m.getChildren().add(rem);
//					}
//				}
//			} else {
//				//当前list没有这个权限目录,则先将该资源加入到权限目录,再将权限目录加入到list中
//				privilege_menu.getChildren().add(rem);
//				privilegeList.add(privilege_menu);
//				
//			}
//		}
		
		List<Privilege> pri_list = privilegeService.getAllPrivilege();
		List<MenuTreeModel> pri_menu_list = new ArrayList();
		for(Privilege p : pri_list) {
			MenuTreeModel m = new MenuTreeModel();
			m.setId(p.getId());
			m.setText(p.getName());
			List<MenuTreeModel> resource_menu_list = privilegeService.getPrivilegeResourceById(p.getId());
			for(MenuTreeModel remre : resource_menu_list) {
				Attribute a = new Attribute();
				a.setUrl(remre.getUrl());
				remre.setAttributes(a);
			}
			m.getChildren().addAll(resource_menu_list);
			pri_menu_list.add(m);
		}
		
		List<MenuTreeModel> role_resource_list = roleService.getRoleResourceByRoleId(Integer.valueOf(id));
		
		for(MenuTreeModel prim : pri_menu_list) {
			//遍历一个权限目录
			for(MenuTreeModel role_re: role_resource_list) {
				//遍历角色资源
				if(prim.getChildren().contains(role_re)) {
					//如果权限目录下面含有这个角色资源
					for(MenuTreeModel mm: prim.getChildren()) {
						//找到这个资源,设置为checked
						if(mm.equals(role_re)) {
							mm.setChecked(true);
						}
					}
				}
			}
		}
//		
		
		System.out.println();
		return pri_menu_list;
	}
	
	@RequestMapping("resetpassword.xhtml")
	public @ResponseBody ResultMessage resetpassword(UserForm userForm) {
		ResultMessage message = new ResultMessage();
		String type = userForm.getType();
		if("学生".equals(type)) {
			//是学生
			Student student = studentService.getStudentById(userForm.getId());
			if(student == null) {
				message.setMessage("修改的用户不存在");
			} else {
				userForm.setPassword(MD5Util.string2MD5("000000"));
				studentService.updatePasswordById(userForm);
				message.setMessage("密码修改成功");
			}
		} else {
			//不是学生
			Teacher teacher = teacherService.getTeacherById(userForm.getId());
			if(teacher == null) {
				message.setMessage("修改的用户不存在");
			} else {
				userForm.setPassword(MD5Util.string2MD5("000000"));
				teacherService.updatePasswordById(userForm);
				message.setMessage("密码修改成功");
			}
		}
		
		System.out.println();
		return null;
	}
}

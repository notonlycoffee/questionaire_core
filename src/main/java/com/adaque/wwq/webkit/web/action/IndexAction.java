package com.adaque.wwq.webkit.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.dao.privilege.RoleMapper;
import com.adaque.wwq.questionaire.dao.student.StudentMapper;
import com.adaque.wwq.questionaire.dao.teacher.TeacherMapper;
import com.adaque.wwq.questionaire.model.privilege.QueryPrivilegeModel;
import com.adaque.wwq.questionaire.model.student.StudentModel;
import com.adaque.wwq.questionaire.model.teacher.TeacherModel;
import com.adaque.wwq.questionaire.po.Role;
import com.adaque.wwq.questionaire.po.Student;
import com.adaque.wwq.questionaire.po.Teacher;


@Controller
public class IndexAction {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private TeacherMapper teacherMapper;
	
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
			Role role = roleMapper.getRoleById(Integer.valueOf(userroleid));
			List<QueryPrivilegeModel> rolePriList = roleMapper.getUserRoleAndPrivilege(role.getId());
			
			
			
			if(role.getName().equals("学生")) {
				StudentModel studentModel = new StudentModel();
				studentModel.setUsername(username);
				studentModel.setPassword(password);
				Student student = studentMapper.getStduentByNameAndPwd(studentModel);
				if(student == null) {
					return "/login";
				} else {
					request.getSession().setAttribute("user", student);
					return "index";
				}
				
				
				
				
			} else {
				TeacherModel teacherModel = new TeacherModel();
				teacherModel.setPassword(password);
				teacherModel.setUsername(username);
				Teacher teacher = teacherMapper.getTeacherByNameAndPassword(teacherModel);
				if(teacher == null) {
					return "login";
				} else {
					String roleId = teacherMapper.getTeacherRoleId(teacher.getId());
					if(userroleid.equals(roleId)) {
						request.getSession().setAttribute("user", teacher);
						return "index";
					} else {
						return "/login";
					}
					
					
				}
				
			}
		}
		
		return null;
	}
	
	@RequestMapping(value="getAllRole.xhtml")
	public @ResponseBody List getAllRole(String username) {
		List<Role> roleList = roleMapper.getAllRole();
		
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
}

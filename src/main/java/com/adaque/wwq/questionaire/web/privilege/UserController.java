package com.adaque.wwq.questionaire.web.privilege;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adaque.wwq.questionaire.model.easyuimodel.EasyUIDataGradOutputModel;
import com.adaque.wwq.questionaire.model.easyuimodel.UserForm;
import com.adaque.wwq.questionaire.po.ResultMessage;
import com.adaque.wwq.questionaire.po.Role;
import com.adaque.wwq.questionaire.po.Student;
import com.adaque.wwq.questionaire.po.Teacher;
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
			if(teacherList.size()>0) {
				//说明添加的用户已经存在
				message.setMessage("您添加的用户已经存在");
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
			message.setMessage("添加成功");
			}
		} else if(num.length()==10&&userForm.getType().equals("学生")) {
			//学号/学生
			List<Student> studentList = studentService.getStudentByNumAndName(userForm);
			if(studentList.size() > 0) {
				//学生已经存在
				message.setMessage("您添加的用户已经存在");
			} else {
				Student s = new Student();
				s.setName(userForm.getName());
				s.setNum(userForm.getNum());
				s.setPassword(MD5Util.string2MD5(userForm.getPassword()));
				s.setSex(userForm.getSex());
				s.setId(UUID.randomUUID().toString());
				studentService.addFormStudent(s);
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
	
	
}

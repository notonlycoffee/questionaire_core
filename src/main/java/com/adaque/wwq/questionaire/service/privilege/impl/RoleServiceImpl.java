package com.adaque.wwq.questionaire.service.privilege.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaque.wwq.questionaire.dao.privilege.RoleMapper;
import com.adaque.wwq.questionaire.model.easyuimodel.MenuTreeModel;
import com.adaque.wwq.questionaire.model.privilege.QueryPrivilegeModel;
import com.adaque.wwq.questionaire.po.Role;
import com.adaque.wwq.questionaire.service.privilege.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public Role getRoleById(int id) {
		Role role = roleMapper.getRoleById(id);
		return role;
	}

	public List<Role> getAllRole() {
		List<Role> roleList = roleMapper.getAllRole();
		return roleList;
	}

	public void updateRoleById(int id) {
		roleMapper.updateRoleById(id);
	}

	public void deleteRoleById(int id) {
		roleMapper.deleteRoleById(id);
	}

	public void addRole(Role role) {
		roleMapper.addRole(role);
	}


	public List<MenuTreeModel> getUserRoleMenu(int roleid) {
		List<MenuTreeModel> modelList = roleMapper.getUserRoleMenu(roleid);
		return modelList;
	}

	public List<MenuTreeModel> getUserRoleLeave(int privilegeid) {
		List<MenuTreeModel> modelList = roleMapper.getUserRoleLeave(privilegeid);
		return modelList;
	}

}

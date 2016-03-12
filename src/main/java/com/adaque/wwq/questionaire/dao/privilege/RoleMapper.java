
package com.adaque.wwq.questionaire.dao.privilege;

import java.util.List;

import com.adaque.wwq.questionaire.model.easyuimodel.MenuTreeModel;
import com.adaque.wwq.questionaire.model.privilege.QueryPrivilegeModel;
import com.adaque.wwq.questionaire.po.Role;

public interface RoleMapper {
	public Role getRoleById(int id);
	
	public List<Role> getAllRole();
	
	public void updateRoleById(int id);
	
	public void deleteRoleById(int id);
	
	public void addRole(Role role);
	
	
	public List<MenuTreeModel> getUserRoleMenu(int roleid);
	
	public List<MenuTreeModel> getUserRoleLeave(int privilegeid);
	
	public Role getRoleByName(String name);
}

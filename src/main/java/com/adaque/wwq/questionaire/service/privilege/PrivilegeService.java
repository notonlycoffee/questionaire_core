package com.adaque.wwq.questionaire.service.privilege;

import java.util.List;

import com.adaque.wwq.questionaire.model.easyuimodel.MenuTreeModel;
import com.adaque.wwq.questionaire.po.Privilege;

public interface PrivilegeService {
	
	public Privilege getPrivilegeById(int id);

	public List<Privilege> getAllPrivilege();

	public void updatePrivilegeById(int id);

	public void deletePrivilegeById(int id);

	public void addPrivilege(Privilege privilege);
	
	public List<MenuTreeModel> getPrivilegeResourceById(int id);
	
	public int getRoleIdByPrivilegeId(int id);
}

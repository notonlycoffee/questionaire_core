package com.adaque.wwq.questionaire.dao.privilege;

import java.util.List;

import com.adaque.wwq.questionaire.po.Privilege;

public interface PrivilegeMapper {
	
	
	public Privilege getPrivilegeById(String id);
	
	public List<Privilege> getAllPrivilege();
	
	public void updatePrivilegeById(String id);
	
	public void deletePrivilegeById(String id);
	
	public void addPrivilege(Privilege privilege);
	
}

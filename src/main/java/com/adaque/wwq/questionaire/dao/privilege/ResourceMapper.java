package com.adaque.wwq.questionaire.dao.privilege;

import java.util.List;

import com.adaque.wwq.questionaire.model.easyuimodel.MenuTreeModel;
import com.adaque.wwq.questionaire.model.easyuimodel.UserRole;
import com.adaque.wwq.questionaire.po.Resource;

public interface ResourceMapper {
	
	
	public Resource getResourceById(int id);

	public Resource getResourceByName(String name);

	public List<Resource> getAllResource();

	public void updateResourceById(int id);

	public void deleteResourceById(int id);

	public void addResource(Resource resource);
	
	public MenuTreeModel getPrivilegeByResourceId(UserRole userRole);
	
	public int getMaxid();
	
}
